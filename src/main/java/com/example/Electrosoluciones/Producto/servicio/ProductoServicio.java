package com.example.Electrosoluciones.Producto.servicio;

import com.example.Electrosoluciones.Producto.modelo.Producto;
import com.example.Electrosoluciones.Producto.modelo.dto.ProductoDTO;
import com.example.Electrosoluciones.Producto.modelo.dto.ProductoDTOGuardar;

import java.util.List;

public interface ProductoServicio {
    List<ProductoDTO> obtenerTodosLosProductos();
    String guardarProducto(Producto nuevo) ;
    ProductoDTO actualizarProducto(Producto productoActualizado);
    String eliminarProducto(Long id);

}
