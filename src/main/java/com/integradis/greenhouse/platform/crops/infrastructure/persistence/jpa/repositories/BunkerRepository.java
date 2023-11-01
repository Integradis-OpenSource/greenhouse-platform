package com.integradis.greenhouse.platform.crops.infrastructure.persistence.jpa.repositories;

import com.integradis.greenhouse.platform.crops.domain.model.entities.Bunker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BunkerRepository extends JpaRepository<Bunker, Long> {
    List<Bunker> findAllByCropId(Long cropId);
}
