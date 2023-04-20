package com.br.gerenciadorportfolio.repository;

import com.br.gerenciadorportfolio.entity.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {
}
