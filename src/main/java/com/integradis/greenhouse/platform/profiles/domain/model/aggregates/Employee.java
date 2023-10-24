package com.integradis.greenhouse.platform.profiles.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Employee extends AbstractAggregateRoot<Employee> {
    @Id
    @GeneratedValue
    @Getter
    private Long id;
}
