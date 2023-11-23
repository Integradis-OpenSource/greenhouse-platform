package com.integradis.greenhouse.platform;
import com.integradis.greenhouse.platform.profiles.domain.model.aggregates.Company;
import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.CompanyName;
import com.integradis.greenhouse.platform.profiles.infrastructure.persistence.jpa.repositories.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void testFindByCompanyName() throws Exception {
        this.testEntityManager.persist(new Company("Aostito S.A.","1245834581"));
        Optional<Company> company = this.companyRepository.findByCompanyName(new CompanyName("Aostito S.A."));
        assertThat(company.get().getCompanyName()).isEqualTo("Aostito S.A.");
        assertThat(company.get().getTin()).isEqualTo("1245834581");
    }
}
