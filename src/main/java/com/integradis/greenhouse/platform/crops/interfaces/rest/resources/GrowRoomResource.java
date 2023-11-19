package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public record GrowRoomResource(
        Long growRoomId,
        String author,
        String day,
        LocalDate date,
        LocalTime time,
        String cropPhase,
        int growRoom,
        float airTemperature,
        String compostTemperature,
        int carbonDioxide,
        int airHumidity,
        float setting,
        String comment

) {
}
