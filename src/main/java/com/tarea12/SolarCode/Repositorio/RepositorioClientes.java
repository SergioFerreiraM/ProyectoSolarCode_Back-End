package com.tarea12.SolarCode.Repositorio;

import com.tarea12.SolarCode.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioClientes extends JpaRepository<Clientes,Integer> {
}
