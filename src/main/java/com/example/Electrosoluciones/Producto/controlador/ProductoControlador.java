package com.example.Electrosoluciones.Producto.controlador;


import com.example.Electrosoluciones.Producto.modelo.Producto;
import com.example.Electrosoluciones.Producto.modelo.dto.ProductoDTO;
import com.example.Electrosoluciones.Producto.modelo.dto.ProductoDTOGuardar;
import com.example.Electrosoluciones.Producto.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("producto")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST, RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.HEAD})
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    @Autowired
    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping(value="obtenerTodos")
        public List<ProductoDTO> obtenerTodosLosProductos() {
        return productoServicio.obtenerTodosLosProductos();
    }

    @GetMapping("/")
    public String home() {
        return "¡Bienvenido a Electrosoluciones!";
    }

    @PostMapping(value = {"agregarProducto"})
    public String crearProducto(@RequestBody Producto nuevoProducto)  {
        return productoServicio.guardarProducto(nuevoProducto);
    }

    @PutMapping(value = "actualizarProducto")
        public ProductoDTO actualizarProducto(@RequestBody Producto nuevoProducto) {
        return productoServicio.actualizarProducto(nuevoProducto);
        }

        @DeleteMapping( value = "eliminarProducto/{id}")
        public String eliminarProducto(@PathVariable(name = "id") Long id) {
            return productoServicio.eliminarProducto(id);
        }
    }


