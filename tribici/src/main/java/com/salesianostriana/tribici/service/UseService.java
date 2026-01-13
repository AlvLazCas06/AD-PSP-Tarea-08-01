package com.salesianostriana.tribici.service;

import com.salesianostriana.tribici.model.Bicycle;
import com.salesianostriana.tribici.model.Station;
import com.salesianostriana.tribici.model.Use;
import com.salesianostriana.tribici.model.User;
import com.salesianostriana.tribici.repository.BicycleRepository;
import com.salesianostriana.tribici.repository.StationRepository;
import com.salesianostriana.tribici.repository.UseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UseService {

    private static final double UMBRAL_SALDO_MINIMO = 0.10;

    /*
     * Los primeros 30 minutos, gratis.
     * */
    private final UseRepository useRepository;
    private final UserService userService;
    private final StationRepository stationRepository;
    private final BicycleRepository bicycleRepository;

    // User
    // Station
    // Bicycle
    public Use initUse(
            String numCard, String pin, Long idStation, Long idBicycle
    ) {
        User user = userService.autenticate(numCard, pin)
                .orElseThrow(() -> new RuntimeException(""));
        if (user.getBalance().doubleValue() < UMBRAL_SALDO_MINIMO) {
            throw new RuntimeException();
        }
        Station station = stationRepository.findById(idStation)
                .orElseThrow(() -> new RuntimeException(""));
        Bicycle bicycle = bicycleRepository.findById(idBicycle)
                .orElseThrow(() -> new RuntimeException(""));
        Use use = Use.builder()
                .cost(new BigDecimal(UMBRAL_SALDO_MINIMO))
                .startDate(LocalDateTime.now())
                .bicycle(bicycle)
                .station(station)
                .user(user)
                .build();
        return useRepository.save(use);
    }

    public Use finishUse(String numCard, String pin, Long idBicycle, Long stationId) {
        User user = userService.autenticate(numCard, pin)
                .orElseThrow(() -> new RuntimeException(""));
        Use use = useRepository.findFirstByUserOrderByStartDateDesc(user).orElseThrow(() -> new RuntimeException(""));
        if (idBicycle != use.getBicycle().getId()) {
            throw new RuntimeException();
        }

        LocalDateTime finish = LocalDateTime.now();
        double price = use.calculatePrice(finish);
        if (user.getBalance().doubleValue() < price) {
            throw new RuntimeException();
        }
        use.setStation(null);
        userService.updateBalance(user, price);
        return useRepository.save(use);
    }

    public Page<Use> findUseByUserId(Long id, Pageable pageable) {
        return useRepository.findByUserId(id, pageable);

    }

}
