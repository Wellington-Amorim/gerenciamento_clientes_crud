package com.as.gerenciamento_clientes.controllers;

import com.as.gerenciamento_clientes.models.ClienteModel;
import com.as.gerenciamento_clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteModel> criar(@RequestBody ClienteModel clienteModel){
        ClienteModel cliente = clienteService.criar(clienteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(clienteModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listar() {
        List<ClienteModel> clientes = clienteService.listar();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/{id}")
    public Optional<ClienteModel> buscarId(@PathVariable Long id) {
        return clienteService.buscarId(id);
    }

    @PutMapping("/{id}")
    public ClienteModel atualizar(@PathVariable Long id, @RequestBody ClienteModel clienteModel) {
        return clienteService.atualizar(id, clienteModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
