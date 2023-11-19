package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreatePreparationAreaResource(
        String author,
        String day,
        LocalDate date,
        LocalTime time,
        int activities,
        int temperature,
        String comment

) {
}
