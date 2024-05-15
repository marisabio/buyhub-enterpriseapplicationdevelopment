package org.buyhub.service.DTOs.pedido;

import org.buyhub.domain.entities.*;

import java.sql.Date;
import java.util.List;

public record DadosListagemPedido(
        Long idPedido,
        List<CompraOrcamento> compraOrcamento,
        List<CompraRequisicao> compraRequisicao,
        int qntdPedido,
        Date dtPedido,
        List<CompraCliente> compraCliente,
        List<CompraFornecedor> compraFornecedor,
        List<CompraProduto> compraProduto) {

    public DadosListagemPedido(ComprasPedido ComprasPedido) {
        this(ComprasPedido.getIdPedido(), ComprasPedido.getCompraOrcamento(), ComprasPedido.getCompraRequisicao(), ComprasPedido.getQntdPedido(), ComprasPedido.getDtPedido(), ComprasPedido.getCompraCliente(), ComprasPedido.getCompraFornecedor(), ComprasPedido.getCompraProduto());
    }
}
