package org.buyhub.domain.DTOs.produto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraFornecedor;

import java.util.List;

public record DadosCadastroProduto(
        @NotBlank
        Long idProduto,
        @NotBlank
        @Valid
        List<CompraFornecedor> compraFornecedor,
        @NotBlank
        String descricaoProduto,
        @NotBlank
        double valorProduto,
        @NotBlank
        String aplicacaoProduto) {
}
