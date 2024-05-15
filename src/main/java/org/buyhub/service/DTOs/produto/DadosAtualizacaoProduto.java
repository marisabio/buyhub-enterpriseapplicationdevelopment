package org.buyhub.service.DTOs.produto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraFornecedor;

import java.util.List;

public record DadosAtualizacaoProduto(
        @NotBlank
        Long idProduto,
        @Valid
        List<CompraFornecedor> compraFornecedor,
        String descProduto,
        double vlProduto,
        String aplicacaoProd) {
}
