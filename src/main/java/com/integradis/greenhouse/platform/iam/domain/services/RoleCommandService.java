package com.integradis.greenhouse.platform.iam.domain.services;

import com.integradis.greenhouse.platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
