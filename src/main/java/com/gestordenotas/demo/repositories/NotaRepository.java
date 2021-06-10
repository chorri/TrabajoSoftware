package com.gestordenotas.demo.repositories;

import com.gestordenotas.demo.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota,Long>{

}
