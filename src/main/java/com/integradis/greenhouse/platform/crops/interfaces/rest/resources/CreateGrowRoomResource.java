package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateGrowRoomResource(
        String author,
        int growRoom,
        int airTemperature,
        String compostTemperature,
        int carbonDioxide,
        int airHumidity,
        float setting,
        String comment
) {
}
