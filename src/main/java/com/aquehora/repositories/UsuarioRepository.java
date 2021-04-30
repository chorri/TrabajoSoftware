package com.aquehora.repositories;

import com.aquehora.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>
{
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByNombre(String nombre);

    @Query("SELECT User FROM Usuario User")
    List<Usuario> findUsuarios();

}
