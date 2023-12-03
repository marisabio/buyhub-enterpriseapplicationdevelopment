package org.buyhub.domain.DTOs.requisicao;

import org.buyhub.domain.entities.CompraRequisicao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRequisicao extends JpaRepository<CompraRequisicao, Long> {
    Page<CompraRequisicao> findAll(Pageable paginacao);
}
