package com.salesianostriana.tribici.repository;

import com.salesianostriana.tribici.model.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRepository
        extends JpaRepository<Bicycle, Long> {
}
