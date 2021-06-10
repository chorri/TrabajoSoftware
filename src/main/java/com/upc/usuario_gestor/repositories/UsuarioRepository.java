package com.upc.usuario_gestor.repositories;

import com.upc.usuario_gestor.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//Solo metodo que hagan un insert select, drop to do contra la base de datos
//Consultas cuando utilizas un atributo de la entidad
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>
{
    Optional<Usuario> findById(Long id);
    Optional<Usuario>  findByNombreAndContrasena(String nombre, String contrasena);

    @Transactional
    @Modifying
    @Query("update Usuario user set user.contrasena= ?1 where user.id= ?2")
    int setUpdatePassword(String contrasena,Long userId);

    @Transactional
    @Modifying
    @Query("update Usuario user set user.correo= ?1 where user.id= ?2")
    int setUpdateUserCorreo(String correo,Long userId);

    @Transactional
    @Modifying
    @Query("delete from Usuario user where user.id = ?1")
    void deleteUser(Long user_id);

}
