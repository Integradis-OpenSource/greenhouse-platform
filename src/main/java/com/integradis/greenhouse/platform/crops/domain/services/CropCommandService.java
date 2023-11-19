package com.integradis.greenhouse.platform.crops.domain.services;

import com.integradis.greenhouse.platform.crops.domain.model.commands.CreateCropCommand;
import com.integradis.greenhouse.platform.crops.domain.model.commands.EndCropPhaseCommand;

public interface CropCommandService {
    Long handle(CreateCropCommand command);

    Long handle(EndCropPhaseCommand command);
}
