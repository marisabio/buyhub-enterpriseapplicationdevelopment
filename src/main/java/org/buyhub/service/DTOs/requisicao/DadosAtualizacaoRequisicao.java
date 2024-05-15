package org.buyhub.service.DTOs.requisicao;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraCliente;
import org.buyhub.domain.entities.CompraFornecedor;
import org.buyhub.domain.entities.CompraProduto;

import java.sql.Date;
import java.util.List;

public record DadosAtualizacaoRequisicao(
        @NotBlank
        Long idRequisicao,
        @Valid
        List<CompraProduto> compraProduto,
        @Valid
        List<CompraFornecedor> compraFornecedor,
        @Valid
        List<CompraCliente> compraCliente,
        Date dtRequisicao,
        int qntdRequisicao) {
}
