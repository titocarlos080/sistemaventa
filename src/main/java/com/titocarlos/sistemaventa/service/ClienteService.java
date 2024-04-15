package com.titocarlos.sistemaventa.service;

import com.titocarlos.sistemaventa.model.entity.Cliente;
import com.titocarlos.sistemaventa.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public void addCliente(Cliente cliente) {

        clienteRepository.save(cliente);
    }

    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }

    public Cliente getCliente(int id) {
  
     return   clienteRepository.getReferenceById(id);
    }

    public void updateCliente(Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getId());
        if (clienteOptional.isPresent()) {
            Cliente clienteExistente = clienteOptional.get();
            // Actualizar los campos del cliente existente con los nuevos valores
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setNit(cliente.getNit());
            clienteExistente.setEmail(cliente.getEmail());
            
            // Guardar el cliente actualizado en la base de datos
            clienteRepository.save(clienteExistente);
        } else {
            // Manejar el caso en el que el cliente no existe
            throw new RuntimeException("Cliente no encontrado con ID: " + cliente.getId());
        }
    }

}
