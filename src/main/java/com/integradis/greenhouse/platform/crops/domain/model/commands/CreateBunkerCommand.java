package com.integradis.greenhouse.platform.crops.domain.model.commands;

public record CreateBunkerCommand(
        Long cropId,
        String author,
        int thermocoupleOne,
        int thermocoupleTwo,
        int thermocoupleThree,
        int motorFrequency,
        String comment

) {
}
