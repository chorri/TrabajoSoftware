package com.tp.tp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Alarmas")

public class Alarma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idNota;
    private long idCalendario;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;
    @Column(name = "Descripcion")
    private String Descripcion;
}
