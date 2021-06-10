package com.upc.usuario_gestor.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity  // Esta clase se comportara como entidad, hara que tu entidad sea persistente en la bd.
@Table(name="usuarios",
        uniqueConstraints = {
                @UniqueConstraint(name="usuario_name_unique",columnNames="name")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario
{
    @Id
    @SequenceGenerator(name="usuario_sequence",
            sequenceName = "usuario_sequence",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="usuario_sequence")

    @Column(name="id",updatable = false)
    private Long id;

    @Column(name="name",nullable = false,columnDefinition = "TEXT")
    private String nombre;

    @Column(name="correo",nullable = false,columnDefinition = "TEXT")
    private String correo;

    @Column(name="contrasena",nullable = false,columnDefinition = "TEXT")
    private String contrasena;


}
