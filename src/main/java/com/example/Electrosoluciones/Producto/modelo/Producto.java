package com.example.Electrosoluciones.Producto.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="unidad")
    private String unidad;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private Long cantidad;


    @Column (name = "imagen")
    private String imagen;

    @Column(name="valor_unitario")
    private Long precio;

}
