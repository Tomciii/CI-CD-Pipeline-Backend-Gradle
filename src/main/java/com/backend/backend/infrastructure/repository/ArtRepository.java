package com.backend.backend.infrastructure.repository;

import com.backend.backend.infrastructure.entity.ArtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepository extends JpaRepository<ArtEntity, Integer> {

}
