package com.as.gerenciamento_clientes.repositories;

import com.as.gerenciamento_clientes.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
