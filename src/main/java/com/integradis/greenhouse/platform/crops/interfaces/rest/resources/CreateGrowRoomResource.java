package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateGrowRoomResource(
        String author,
        String day,
        LocalDate date,
        String time,
        int grow_room,
        int air_temperature,
        String compost_temperature,
        int carbon_dioxide,
        int air_humidity,
        float setting,
        String comment
) {
}
