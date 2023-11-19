package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateTunnelCommand;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.CreateTunnelResource;

public class CreateTunnelCommandFromResourceAssembler {
    public static CreateTunnelCommand toCommandFromResource(CreateTunnelResource resource, Long cropId){
        return new CreateTunnelCommand(cropId, resource.author(), resource.thermocoupleOne(),
                resource.thermocoupleTwo(), resource.thermocoupleThree(), resource.motorFrequency(),
                resource.roomTemperature(), resource.freshAir(), resource.recirculation(), resource.comment());
    }
}
