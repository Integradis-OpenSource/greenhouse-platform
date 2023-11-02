package com.integradis.greenhouse.platform.crops.interfaces.rest.resources;

public record CreatePreparationAreaResource(
        String author, int activities, int temperature, String comment
) {
}
