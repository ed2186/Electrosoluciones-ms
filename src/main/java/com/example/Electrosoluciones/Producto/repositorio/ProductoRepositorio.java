package com.example.Electrosoluciones.Producto.repositorio;

import com.example.Electrosoluciones.Producto.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,Long> {

    List<Producto> findAll();
    Optional<Producto> findById(Long id);

}
