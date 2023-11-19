package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public record TunnelResource(
        Long tunnelId,
        String author,
        String day,
        LocalDate date,
        String time,
        int thermocoupleOne,
        int thermocoupleTwo,
        int thermocoupleThree,
        float averageThermocouple,
        int motorFrequency,
        float roomTemperature,
        int freshAir,
        int recirculation,
        String comment
) {
}
