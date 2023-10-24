package com.integradis.greenhouse.platform.profiles.domain.model.aggregates;

import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.CompanyName;
import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.TIN;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Company extends AbstractAggregateRoot<Company> {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Embedded
    private CompanyName companyName;

    @Embedded
    private TIN tin;
}
