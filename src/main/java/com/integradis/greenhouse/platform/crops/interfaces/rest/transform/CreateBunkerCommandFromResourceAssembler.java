package com.integradis.greenhouse.platform.crops.interfaces.rest.transform;

import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateBunkerCommand;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.CreateBunkerResource;

public class CreateBunkerCommandFromResourceAssembler {
    public static CreateBunkerCommand toCommandFromResource(CreateBunkerResource resource, Long cropId){
        return new CreateBunkerCommand(cropId, resource.author(), resource.thermocoupleOne(),
                resource.thermocoupleTwo(), resource.thermocoupleThree(), resource.motorFrequency(), resource.comment());
    }
}
