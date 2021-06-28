package com.aquehora.pomodoroservice.repository;

import com.aquehora.pomodoroservice.entity.ReporteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PomRepository extends JpaRepository<ReporteEntity, String> {

}
