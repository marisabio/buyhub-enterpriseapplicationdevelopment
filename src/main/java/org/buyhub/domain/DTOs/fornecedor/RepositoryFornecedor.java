package org.buyhub.domain.DTOs.fornecedor;

import org.buyhub.domain.entities.CompraFornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryFornecedor extends JpaRepository<CompraFornecedor, Long> {
    Page<CompraFornecedor> findAll(Pageable paginacao);
}
