package org.buyhub.domain.DTOs.pedido;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.*;

import java.sql.Date;
import java.util.List;

public record DadosCadastroPedido(
        @NotBlank
        Long idPedido,
        @NotBlank
        @Valid
        List<CompraOrcamento> compraOrcamento,
        @NotBlank
        @Valid
        List<CompraRequisicao> compraRequisicao,
        @NotBlank
        int qntdPedido,
        @NotBlank
        Date dtPedido,
        @NotBlank
        @Valid
        List<CompraCliente> compraCliente,
        @NotBlank
        @Valid
        List<CompraFornecedor> compraFornecedor,
        @NotBlank
        @Valid
        List<CompraProduto> compraProduto) {
}
