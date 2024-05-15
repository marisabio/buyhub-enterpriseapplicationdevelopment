package org.buyhub.service.DTOs.produtoWeb;

import org.buyhub.domain.entities.ProdutoWeb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProdutoWeb extends JpaRepository<ProdutoWeb, String> {
    Page<ProdutoWeb> findAll(Pageable pageable);
}
