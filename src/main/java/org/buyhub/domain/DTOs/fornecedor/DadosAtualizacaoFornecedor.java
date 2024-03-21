package org.buyhub.domain.DTOs.fornecedor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraOrcamento;
import org.buyhub.domain.entities.CompraProduto;

import java.util.List;

public record DadosAtualizacaoFornecedor(
        @NotBlank
        Long cnpjFornecedor,
        String senhaFornecedor,
        String nmFornecedor,
        String ramoFornecedor,
        @Valid
        List<CompraOrcamento> compraOrcamentos,
        @Valid
        List<CompraProduto> compraProdutos) {
}
