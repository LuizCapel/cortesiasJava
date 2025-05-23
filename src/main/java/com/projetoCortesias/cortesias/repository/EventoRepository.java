package com.projetoCortesias.cortesias.repository;

import com.projetoCortesias.cortesias.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {}
