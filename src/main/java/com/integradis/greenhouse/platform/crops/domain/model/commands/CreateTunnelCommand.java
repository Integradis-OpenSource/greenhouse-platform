package com.integradis.greenhouse.platform.crops.domain.model.commands;

public record CreateTunnelCommand(
        Long cropId,
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
