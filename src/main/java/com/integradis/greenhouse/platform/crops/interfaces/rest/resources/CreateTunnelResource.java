package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateTunnelResource(
        String author,
        int thermocoupleOne,
        int thermocoupleTwo,
        int thermocoupleThree,
        int motorFrequency,
        float roomTemperature,
        int freshAir,
        int recirculation,
        String comment
) {
}
