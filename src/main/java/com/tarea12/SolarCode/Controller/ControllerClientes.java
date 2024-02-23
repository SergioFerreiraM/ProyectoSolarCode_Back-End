package com.tarea12.SolarCode.Controller;
// controller de clientes

import com.tarea12.SolarCode.Entity.Clientes;
import com.tarea12.SolarCode.Repositorio.RepositorioClientes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
public class ControllerClientes {
    private RepositorioClientes repositorioClientes;
    public ControllerClientes(RepositorioClientes repositorioClientes){
        this.repositorioClientes = repositorioClientes;
    }
    // Obtener todos los clientes
    @GetMapping
    public List<Clientes> obtenerClientes(){
        return repositorioClientes.findAll();
    }
    // Agregar clientes
    @PostMapping
    public Clientes agregarCliente(@RequestBody Clientes clientes){
        return repositorioClientes.save(clientes);
    }
    // Eliminar clientes
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable int id){
        repositorioClientes.deleteById(id);
    }
    // Actualizar clientes
    @PutMapping("/{id}")
    public Clientes actualizarCliente(@PathVariable int id, @RequestBody Clientes cliente) {
        Clientes clienteActualizar = repositorioClientes.findById(id).orElse(null);
        if (clienteActualizar != null) {
            clienteActualizar.setNombre(cliente.getNombre());
            clienteActualizar.setApellido(cliente.getApellido());
            clienteActualizar.setTelefono(cliente.getTelefono());
            clienteActualizar.setDireccion(cliente.getDireccion());
            clienteActualizar.setCorreo(cliente.getCorreo());
            clienteActualizar.setIdCompra(cliente.getIdCompra());
            return repositorioClientes.save(clienteActualizar);
        } else {
            return null;
        }
    }

}
