package com.salesianostriana.tribici;

import com.salesianostriana.tribici.model.*;
import com.salesianostriana.tribici.repository.BicycleRepository;
import com.salesianostriana.tribici.repository.StationRepository;
import com.salesianostriana.tribici.repository.UseRepository;
import com.salesianostriana.tribici.repository.UserRepository;
import com.salesianostriana.tribici.service.BicycleService;
import com.salesianostriana.tribici.service.StationService;
import com.salesianostriana.tribici.service.UseService;
import com.salesianostriana.tribici.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final UserService userService;
    private final UseService useService;
    private final BicycleService bicycleService;
    private final StationService stationService;

    @PostConstruct
    public void run() {
        Station station = Station.builder()
                .name("Plaza de armas")
                .coordinates("12, 0")
                .number(1)
                .capacity(1)
                .build();
        log.info(stationService.saveStation(station).toString());
    }

}
