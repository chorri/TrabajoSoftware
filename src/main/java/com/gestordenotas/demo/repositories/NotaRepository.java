package com.gestordenotas.demo.repositories;

import com.gestordenotas.demo.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota,Long>
{
    @Override
    boolean existsById(Long idNota);

    @Query("SELECT Note FROM Nota Note where Note.usuarioid=?1")
    List<Nota> findNotas(String usuarioID);

    @Query("SELECT Note FROM Nota Note where Note.importancia=?1 and Note.usuarioid=?2")
    List<Nota> findTodasNotasImportancia(Integer importancia,String usuarioID);

    @Query("SELECT Note FROM Nota Note where Note.fecha_creacion=?1")
    List<Nota> findNotasFechaCreacion(Date fecha_creacion);

    /*@Query("SELECT Note FROM Nota Note where Note.fecha_creacion between ?1 and ?2")
    List<Nota> findNotasEntreFCYFCulmi(Date fecha_creacion,Date fecha_culminacion);

    @Query("SELECT Note FROM Nota Note where Note.name_nota like %?1%  and Note.usuario.id=?2")
    List<Nota> findNotaContainName(String name_nota,Long usuarioID);
*/

    @Transactional
    @Modifying
    @Query("update Nota note set note.name_nota= ?1 where note.id= ?2")
    int setUpdateNoteName(String name_nota,Long noteid);

    @Transactional
    @Modifying
    @Query("update Nota note set note.contenido= ?1 where note.id= ?2")
    int updateDescriptionNota(String contenido,Long noteid);

    @Transactional
    @Modifying
    @Query("delete from Nota note where note.id = ?1")
    void deleteNote(Long note_id);
}
