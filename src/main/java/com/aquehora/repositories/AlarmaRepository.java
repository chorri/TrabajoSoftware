package com.tp.tp.repository;

import com.tp.tp.entity.Alarma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmaRepository extends JpaRepository<Alarma,Long> {
}




