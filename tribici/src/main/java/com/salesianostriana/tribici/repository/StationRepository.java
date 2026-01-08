package com.salesianostriana.tribici.repository;

import com.salesianostriana.tribici.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository
        extends JpaRepository<Station, Long> {
}
