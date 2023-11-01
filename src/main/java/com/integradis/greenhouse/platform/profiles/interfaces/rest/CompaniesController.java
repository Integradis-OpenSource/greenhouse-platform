package com.integradis.greenhouse.platform.profiles.interfaces.rest;

import com.integradis.greenhouse.platform.profiles.domain.model.queries.GetCompanyByIdQuery;
import com.integradis.greenhouse.platform.profiles.domain.services.CompanyQueryService;
import com.integradis.greenhouse.platform.profiles.interfaces.rest.resources.CompanyResource;
import com.integradis.greenhouse.platform.profiles.interfaces.rest.transform.CompanyResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/companies", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Companies", description = "Companies Management Endpoints")
public class CompaniesController {
    private final CompanyQueryService companyQueryService;

    public CompaniesController(CompanyQueryService companyQueryService) {
        this.companyQueryService = companyQueryService;
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResource> getCompanyById(@PathVariable Long companyId) {
        var getCompanyByIdQuery = new GetCompanyByIdQuery(companyId);
        var company = companyQueryService.handle(getCompanyByIdQuery);
        if (company.isEmpty()) return ResponseEntity.badRequest().build();
        var companyResource = CompanyResourceFromEntityAssembler.toResourceFromEntity(company.get());
        return ResponseEntity.ok(companyResource);
    }

}
