package org.buyhub.domain.DTOs.pedido;

import org.buyhub.domain.entities.ComprasPedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPedido extends JpaRepository<ComprasPedido, Long> {
    Page<ComprasPedido> findAll(Pageable paginacao);
}
