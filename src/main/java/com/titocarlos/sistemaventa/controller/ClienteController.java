package com.titocarlos.sistemaventa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.titocarlos.sistemaventa.model.entity.Cliente;
import com.titocarlos.sistemaventa.service.ClienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente/all")
    public String getClientes(Model model) {
        model.addAttribute("clientes", clienteService.getClientes());
        return "cliente/clientes";
    }

    @GetMapping("/cliente/create")
    public String mostrarFormString() {
        return "cliente/crearCliente";
    }

    @PostMapping("/cliente/add")
    public String addCliente(@RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
        return "redirect:/cliente/all";
    }

    @GetMapping("/cliente/delete/{id}")
    public String deleteCliente(@PathVariable int id) {
        clienteService.deleteCliente(id);
        return "redirect:/cliente/all";
    }

     @GetMapping("/cliente/edit/{id}")
    public String mostrarFormEdit(@PathVariable int id,Model model) {
      model.addAttribute("cliente", clienteService.getCliente(id));
        return "/cliente/editCliente";
    }

    @PostMapping("/cliente/update")
    public String updateCliente(@RequestBody Cliente cliente) {
        clienteService.updateCliente(cliente);
        return "redirect:/cliente/all";
    }

}
