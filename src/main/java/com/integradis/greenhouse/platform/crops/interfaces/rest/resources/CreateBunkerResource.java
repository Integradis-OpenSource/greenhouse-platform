package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateBunkerResource(
        String author,
        int thermocoupleOne,
        int thermocoupleTwo,
        int thermocoupleThree,
        int motorFrequency,
        String comment
) {
}
