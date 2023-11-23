package com.integradis.greenhouse.platform;

import com.integradis.greenhouse.platform.iam.domain.model.aggregates.User;
import com.integradis.greenhouse.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByUsername() throws Exception {
        this.testEntityManager.persist(new User("Soto", "hierbas"));
        Optional<User> user = this.userRepository.findByUsername("Soto");
        assertThat(user.get().getUsername()).isEqualTo("Soto");
        assertThat(user.get().getPassword()).isEqualTo("hierbas");
    }
}
