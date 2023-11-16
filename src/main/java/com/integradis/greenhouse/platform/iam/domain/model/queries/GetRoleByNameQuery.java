package com.integradis.greenhouse.platform.iam.domain.model.queries;

import com.integradis.greenhouse.platform.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
