package com.integradis.greenhouse.platform.iam.interfaces.rest.transform;

import com.integradis.greenhouse.platform.iam.domain.model.commands.SignUpCommand;
import com.integradis.greenhouse.platform.iam.domain.model.entities.Role;
import com.integradis.greenhouse.platform.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource signUpResource) {
        var roles = signUpResource.roles() != null ? signUpResource.roles().stream()
                .map(name -> Role.toRoleFromName(name))
                .toList() : new ArrayList<Role>();
        return new SignUpCommand(signUpResource.username(), signUpResource.password(), roles);
    }
}
