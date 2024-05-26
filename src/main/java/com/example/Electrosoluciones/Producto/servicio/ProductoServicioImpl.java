package com.example.Electrosoluciones.Producto.servicio;

import com.example.Electrosoluciones.Producto.modelo.Producto;
import com.example.Electrosoluciones.Producto.modelo.dto.ProductoDTO;
import com.example.Electrosoluciones.Producto.modelo.dto.ProductoDTOGuardar;
import com.example.Electrosoluciones.Producto.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio {
    private ProductoRepositorio productoRepositorio;

    @Autowired
    public ProductoServicioImpl(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }
    @Override
    public List<ProductoDTO> obtenerTodosLosProductos() {
        List<Producto> listaProductos = productoRepositorio.findAll();
        List<ProductoDTO> listaProductosDTO = new ArrayList<>();

        listaProductos.forEach(producto -> {
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId(producto.getId());
            productoDTO.setDescripcion(producto.getDescripcion());
            productoDTO.setUnidad(producto.getUnidad()); // Usar el getter generado por Lombok
            productoDTO.setPrecio(producto.getPrecio());
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setCantidad(producto.getCantidad());
            productoDTO.setEstatus(agregarEstadoDelProducto(producto.getCantidad()));
            listaProductosDTO.add(productoDTO);
        });

        return listaProductosDTO;
    }

    @Override
    public String guardarProducto(Producto nuevo){

            productoRepositorio.save(nuevo);

        return "Guardado exitoso";
    }

    @Override
    public ProductoDTO actualizarProducto(Producto productoActualizado) {
        ProductoDTO productoDTO = new ProductoDTO();

        Optional<Producto> producto = productoRepositorio.findById(productoActualizado.getId());
        if (producto.isPresent()) {
            producto.get().setNombre(productoActualizado.getNombre());
            producto.get().setUnidad(productoActualizado.getUnidad());
            producto.get().setPrecio(productoActualizado.getPrecio());
            producto.get().setCantidad(productoActualizado.getCantidad());
            producto.get().setDescripcion(productoActualizado.getDescripcion());




            productoDTO.setUnidad(producto.get().getUnidad());
            productoDTO.setPrecio(producto.get().getPrecio());
            productoDTO.setNombre(producto.get().getNombre());
            productoRepositorio.save(producto.get());

        }

        return productoDTO;
    }

    @Override
    public String eliminarProducto(Long id) {

        if (productoRepositorio.findById(id).isPresent()) {
            productoRepositorio.deleteById(id);
            return "Producto eliminado de manera exitosa";
        }
        return "Producto no encontrado";

    }

    public String agregarEstadoDelProducto(Long cantidad){
        if(cantidad<=0){
            return "Sin existencia";
        }

        if(cantidad>=1 && cantidad<=50){
            return "Baja existencia";
        }

        if(cantidad>50){
            return "En existencia";
        }
        return "";
    }

}
