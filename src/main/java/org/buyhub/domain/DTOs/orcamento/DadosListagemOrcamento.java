package org.buyhub.domain.DTOs.orcamento;

import org.buyhub.domain.entities.*;

import java.sql.Date;
import java.util.List;

public record DadosListagemOrcamento (
        Long idOrcamento,
        List<CompraRequisicao> compraRequisicao,
        Date dtOrcamento,
        List<CompraCliente> compraCliente,
        List<CompraFornecedor> compraFornecedor,
        List<CompraProduto> compraProduto){
    public DadosListagemOrcamento(CompraOrcamento CompraOrcamento) {
        this(CompraOrcamento.getIdOrcamento(), CompraOrcamento.getCompraRequisicao(), CompraOrcamento.getDtOrcamento(), CompraOrcamento.getCompraCliente(), CompraOrcamento.getCompraFornecedor(), CompraOrcamento.getCompraProduto());
    }
}
