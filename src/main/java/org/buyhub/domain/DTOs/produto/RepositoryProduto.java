package org.buyhub.domain.DTOs.produto;

import org.buyhub.domain.entities.CompraProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduto extends JpaRepository<CompraProduto, Long> {
    Page<CompraProduto> findAll(Pageable paginacao);
}
