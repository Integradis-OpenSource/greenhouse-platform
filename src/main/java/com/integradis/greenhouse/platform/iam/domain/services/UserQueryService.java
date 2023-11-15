package com.integradis.greenhouse.platform.iam.domain.services;

import com.integradis.greenhouse.platform.iam.domain.model.aggregates.User;
import com.integradis.greenhouse.platform.iam.domain.model.queries.GetAllUsersQuery;
import com.integradis.greenhouse.platform.iam.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
}
