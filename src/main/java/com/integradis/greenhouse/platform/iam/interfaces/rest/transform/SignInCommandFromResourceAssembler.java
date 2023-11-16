package com.integradis.greenhouse.platform.iam.interfaces.rest.transform;

import com.integradis.greenhouse.platform.iam.domain.model.commands.SignInCommand;
import com.integradis.greenhouse.platform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
