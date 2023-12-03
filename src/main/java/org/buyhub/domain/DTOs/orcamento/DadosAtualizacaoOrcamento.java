package org.buyhub.domain.DTOs.orcamento;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraCliente;
import org.buyhub.domain.entities.CompraFornecedor;
import org.buyhub.domain.entities.CompraProduto;
import org.buyhub.domain.entities.CompraRequisicao;

import java.sql.Date;
import java.util.List;

public record DadosAtualizacaoOrcamento(
        @NotBlank
        Long idOrcamento,
        @Valid
        List<CompraRequisicao> compraRequisicao,
        Date dataOrcamento,
        @Valid
        List<CompraCliente> compraCliente,
        @Valid
        List<CompraFornecedor> compraFornecedor,
        @Valid
        List<CompraProduto> compraProduto) {
}
