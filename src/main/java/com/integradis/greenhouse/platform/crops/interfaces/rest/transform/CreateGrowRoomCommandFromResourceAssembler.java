package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateGrowRoomCommand;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.CreateGrowRoomResource;

public class CreateGrowRoomCommandFromResourceAssembler {
    public static CreateGrowRoomCommand toCommandFromResource(CreateGrowRoomResource resource, Long cropId, CropPhase cropPhase){
        return new CreateGrowRoomCommand(cropId, resource.author(), cropPhase,
                resource.grow_room(), resource.air_temperature(), resource.compost_temperature(),
                resource.carbon_dioxide(), resource.air_humidity(), resource.setting(), resource.comment());
    }
}
