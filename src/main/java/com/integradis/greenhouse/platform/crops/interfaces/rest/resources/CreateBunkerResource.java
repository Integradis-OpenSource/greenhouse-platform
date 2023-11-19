package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateBunkerResource(
        String author,
        String day,
        LocalDate date,
        LocalTime time,
        int thermocoupleOne,
        int thermocoupleTwo,
        int thermocoupleThree,
        float averageThermocouple,
        int motorFrequency,
        String comment
) {
}
