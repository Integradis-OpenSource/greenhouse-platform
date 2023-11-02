package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

public record CreateGrowRoomResource(
        String author,
        int grow_room,
        int air_temperature,
        String compost_temperature,
        int carbon_dioxide,
        int air_humidity,
        float setting,
        String comment
) {
}
