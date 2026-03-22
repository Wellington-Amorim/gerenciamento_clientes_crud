package com.as.gerenciamento_clientes.services;

import com.as.gerenciamento_clientes.models.ClienteModel;
import com.as.gerenciamento_clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel criar(ClienteModel produtoModel) {
        return clienteRepository.save(produtoModel);
    }

    public List<ClienteModel> listar() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> buscarId(Long id) {
        return clienteRepository.findById(id);
    }

    public ClienteModel atualizar(Long id, ClienteModel produtoModel) {
        ClienteModel model = clienteRepository.findById(id).get();
        model.setNome(produtoModel.getNome());
        model.setEmail(produtoModel.getEmail());
        model.setTelefone(produtoModel.getTelefone());
        return clienteRepository.save(model);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
