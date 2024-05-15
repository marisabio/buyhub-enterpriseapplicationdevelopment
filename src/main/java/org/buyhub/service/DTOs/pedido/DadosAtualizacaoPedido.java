package org.buyhub.service.DTOs.pedido;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.*;

import java.sql.Date;
import java.util.List;

public record DadosAtualizacaoPedido(
        @NotBlank
        Long idPedido,
        @Valid
        List<CompraOrcamento> compraOrcamento,
        @Valid
        List<CompraRequisicao> compraRequisicao,
        int qntdPedido,
        Date dtPedido,
        @Valid
        List<CompraCliente> compraCliente,
        @Valid
        List<CompraFornecedor> compraFornecedor,
        @Valid
        List<CompraProduto> compraProduto) {
}
