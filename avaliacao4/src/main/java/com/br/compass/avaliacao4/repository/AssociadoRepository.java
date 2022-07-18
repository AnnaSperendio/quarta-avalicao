package com.br.compass.avaliacao4.repository;

import com.br.compass.avaliacao4.entities.AssociadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<AssociadoEntity, Long> {
}
