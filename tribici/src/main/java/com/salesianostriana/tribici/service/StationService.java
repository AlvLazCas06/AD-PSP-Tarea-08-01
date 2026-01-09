package com.salesianostriana.tribici.service;

import com.salesianostriana.tribici.model.Station;
import com.salesianostriana.tribici.repository.StationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;

    public Station saveStation(Station station) {
        if (!StringUtils.hasText(station.getCoordinates()) || !StringUtils.hasText(station.getName())
                || station.getCapacity() <= 0 || station.getNumber() <= 0) {
            throw new RuntimeException();
        }
        return stationRepository.save(station);
    }

    public List<Station> findAll() {
        List<Station> result =  stationRepository.findAll();
        if (result.isEmpty()) {
            throw new RuntimeException();
        }
        return result;
    }

    public void deleteStation(Long id) {
        Station station = stationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(""));
        stationRepository.delete(station);
    }

}
