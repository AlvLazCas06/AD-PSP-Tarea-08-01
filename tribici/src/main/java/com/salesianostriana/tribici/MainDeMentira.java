package com.salesianostriana.tribici;

import com.salesianostriana.tribici.model.*;
import com.salesianostriana.tribici.repository.BicycleRepository;
import com.salesianostriana.tribici.repository.StationRepository;
import com.salesianostriana.tribici.repository.UseRepository;
import com.salesianostriana.tribici.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final UserRepository userRepository;
    private final StationRepository stationRepository;
    private final BicycleRepository bicycleRepository;
    private final UseRepository useRepository;

    @PostConstruct
    public void run() {
        User user = User.builder()
                .name("")
                .numCard("")
                .pin("")
                .balance(new BigDecimal(0))
                .build();
        user = userRepository.save(user);
        Station station = Station.builder()
                .name("")
                .capacity(2)
                .coordinates("")
                .number(21)
                .build();
        station = stationRepository.save(station);
        Bicycle bicycle = Bicycle.builder()
                .brand("")
                .model("")
                .status(Status.NEW)
                .station(station)
                .build();
        bicycle = bicycleRepository.save(bicycle);
        station.getBicycles().add(bicycle);
        Use use = Use.builder()
                .startDate(LocalDate.now())
                .finishDate(LocalDate.now())
                .cost(new BigDecimal(0))
                .bicycle(bicycle)
                .user(user)
                .station(station)
                .build();
        use = useRepository.save(use);
        user.getUses().add(use);
        bicycle.getUses().add(use);
        station.getUses().add(use);

        log.info(user.getUses().toString());
        log.info(station.getBicycles().toString());
        log.info(bicycle.getUses().toString());
    }

}
