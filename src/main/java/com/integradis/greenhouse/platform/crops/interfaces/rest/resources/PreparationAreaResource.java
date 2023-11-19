package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public record PreparationAreaResource(
        Long preparationAreaId,
        String author,
        String day,
        LocalDate date,
        String time,
        int activities,
        int temperature,
        String comment
) {
}
