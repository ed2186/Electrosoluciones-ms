package com.example.Electrosoluciones.Producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Long precio;
    private Long cantidad;
    private String unidad;
    private String estatus;
}




