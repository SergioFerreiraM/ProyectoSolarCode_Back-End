package com.tarea12.SolarCode.Repositorio;

import com.tarea12.SolarCode.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioProductos extends JpaRepository<Productos,Integer> {
}

