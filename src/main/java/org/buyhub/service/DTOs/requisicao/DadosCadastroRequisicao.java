package org.buyhub.service.DTOs.requisicao;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraCliente;
import org.buyhub.domain.entities.CompraFornecedor;
import org.buyhub.domain.entities.CompraProduto;

import java.sql.Date;
import java.util.List;

public record DadosCadastroRequisicao(
        @NotBlank
        Long idRequisicao,
        @NotBlank
        @Valid
        List<CompraProduto> compraProduto,
        @NotBlank
        @Valid
        List<CompraFornecedor> compraFornecedor,
        @NotBlank
        @Valid
        List<CompraCliente> compraCliente,
        @NotBlank
        Date dtRequisicao,
        @NotBlank
        int qntdRequisicao) {
}
