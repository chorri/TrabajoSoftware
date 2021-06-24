package com.gestordenotas.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="notas")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nota
{
    @Id
    @SequenceGenerator(name="nota_sequence",sequenceName = "nota_sequence",
    allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nota_sequence")

    @Column(name="id",updatable = false)
    private Long id;

    @Column(name="name_nota",nullable = false,columnDefinition = "TEXT")
    private String name_nota;

    @Column(
            name = "importancia",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private Integer importancia;

    @Column(
            name = "contenido",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String contenido;
    @Column(
            name = "fecha_creacion",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime fecha_creacion;
    @Column(name = "usuario_ID")
    private String usuarioid;

    /*@ManyToOne
    @JoinColumn(
            name="usuario_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="usuario_note_fk"
            )
    )
    private Usuario usuario;*/
}
