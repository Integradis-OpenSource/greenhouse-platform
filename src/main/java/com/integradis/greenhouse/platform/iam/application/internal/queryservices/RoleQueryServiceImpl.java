package com.integradis.greenhouse.platform.iam.application.internal.queryservices;

import com.integradis.greenhouse.platform.iam.domain.model.entities.Role;
import com.integradis.greenhouse.platform.iam.domain.model.queries.GetAllRolesQuery;
import com.integradis.greenhouse.platform.iam.domain.services.RoleQueryService;
import com.integradis.greenhouse.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }
}
