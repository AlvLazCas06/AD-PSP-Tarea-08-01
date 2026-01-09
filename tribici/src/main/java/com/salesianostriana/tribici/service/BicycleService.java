package com.salesianostriana.tribici.service;

import com.salesianostriana.tribici.repository.BicycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BicycleService {

    private final BicycleRepository bicycleRepository;

}
