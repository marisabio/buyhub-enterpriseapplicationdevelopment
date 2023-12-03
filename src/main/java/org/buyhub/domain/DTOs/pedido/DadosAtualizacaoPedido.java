package org.buyhub.domain.DTOs.pedido;

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
        int quantidadePedido,
        Date dataPedido,
        @Valid
        List<CompraCliente> compraCliente,
        @Valid
        List<CompraFornecedor> compraFornecedor,
        @Valid
        List<CompraProduto> compraProduto) {
}
