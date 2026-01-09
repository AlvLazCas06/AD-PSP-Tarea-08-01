package com.salesianostriana.tribici.dto;

import java.time.LocalDateTime;

public record CreateUseRequest(
        LocalDateTime startDate,
        LocalDateTime finishDate,
        Long stationId,
        Long bicycleId,
        Long userId
) {
}
