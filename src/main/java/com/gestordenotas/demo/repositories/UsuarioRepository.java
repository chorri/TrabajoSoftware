package com.gestordenotas.demo.repositories;

import com.gestordenotas.demo.DTO.UsuarioDto;
import com.gestordenotas.demo.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>
{
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByNombre(String nombre);
    Optional<Usuario> findByNombreEqualsAndContrasenaEquals(String nombre,String contrasena);


    @Query("SELECT User FROM Usuario User")
    List<Usuario> findUsuarios();

    @Transactional
    @Modifying
    @Query("update Usuario user set user.contrasena= ?1 where user.id= ?2")
    int setUpdateUser(String contrasena,Long userId);

    @Transactional
    @Modifying
    @Query("update Usuario user set user.correo= ?1 where user.id= ?2")
    int setUpdateUserCorreo(String correo,Long userId);


}
