package com.javaeo.usuario.infrastructure.repository;

import com.javaeo.aprendendospring.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
