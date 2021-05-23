package com.aquehora.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="alarmas" ,uniqueConstraints = {
        @UniqueConstraint(name="alarma_name_unique",columnNames="name_alarma")
})

public class Alarma {
    //Identificador
    @Id
    @SequenceGenerator(name="alarma_sequence",
            sequenceName = "alarma_sequence",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator="alarma_sequence")
    @Column(name = "id", updatable = false)
    private long id;

    //Atributos Generales
    @Column(name = "nombre",nullable = false,columnDefinition = "TEXT")
    private String nombre;

    @Column(name = "fechaCreacion", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime fechaCreacion;

    @Column(name = "duracion",nullable = false,columnDefinition = "INTEGER")
    private Integer duracion;

    @Column(name = "Descripcion",nullable = false,columnDefinition = "TEXT")
    private String Descripcion;

    //Relaciones
    //Relacion uno a uno con Nota
    @OneToOne
    @JoinColumn(
            name = "nota_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "nota_alarma_fk"
            )
    )
    private Nota usuario;

    //Relacion muchos a uno con Calendario
    @ManyToOne
    @JoinColumn(
            name="calendario_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="calendario_alarma_fk"
            )
    )
    private Calendario calendario;

}
