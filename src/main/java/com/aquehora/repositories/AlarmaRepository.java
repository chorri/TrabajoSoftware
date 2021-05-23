package com.aquehora.repositories;

import com.aquehora.entities.Alarma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmaRepository extends JpaRepository<Alarma,Long> {
    List<Alarma> findByCalendarioId(Long CalendarioId);
}




