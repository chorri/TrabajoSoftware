package com.aquehora.repositories;

import com.aquehora.entities.Pomodoro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PomodoroRepository extends JpaRepository<Pomodoro,Long> {
}
