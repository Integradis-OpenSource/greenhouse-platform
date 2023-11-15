package com.integradis.greenhouse.platform.iam.domain.services;

import com.integradis.greenhouse.platform.iam.domain.model.aggregates.User;
import com.integradis.greenhouse.platform.iam.domain.model.queries.GetAllUsersQuery;

import java.util.List;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
}
