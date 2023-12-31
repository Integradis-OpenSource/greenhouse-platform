package com.integradis.greenhouse.platform.profiles.infrastructure.persistence.jpa.repositories;

import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;
import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.CompanyName;
import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.TIN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Long> {

    Optional<Company> findByCompanyName(CompanyName companyName);

    Optional<Company> findByTin(TIN tin);
}
