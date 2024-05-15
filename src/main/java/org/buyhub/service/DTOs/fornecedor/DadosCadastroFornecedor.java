package org.buyhub.service.DTOs.fornecedor;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraOrcamento;
import org.buyhub.domain.entities.CompraProduto;

import java.util.List;

public record DadosCadastroFornecedor(
        @NotBlank
        Long cnpjFornecedor,
        @NotBlank
        String senhaFornecedor,
        @NotBlank
        String nmFornecedor,
        @NotBlank
        String ramoFornecedor,
        @NotBlank
        @Valid
        List<CompraOrcamento> compraOrcamentos,
        @NotBlank
        @Valid
        List<CompraProduto> compraProdutos) {
}
