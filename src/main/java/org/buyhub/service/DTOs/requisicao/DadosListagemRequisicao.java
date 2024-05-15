package org.buyhub.service.DTOs.requisicao;

import org.buyhub.domain.entities.CompraCliente;
import org.buyhub.domain.entities.CompraFornecedor;
import org.buyhub.domain.entities.CompraProduto;
import org.buyhub.domain.entities.CompraRequisicao;

import java.sql.Date;
import java.util.List;

public record DadosListagemRequisicao(
        Long idRequisicao,
        List<CompraProduto> compraProduto,
        List<CompraFornecedor> compraFornecedor,
        List<CompraCliente> compraCliente,
        Date dtRequisicao,
        int qntdRequisicao) {

    public DadosListagemRequisicao(CompraRequisicao CompraRequisicao) {
        this(CompraRequisicao.getIdRequisicao(), CompraRequisicao.getCompraProduto(), CompraRequisicao.getCompraFornecedor(), CompraRequisicao.getCompraCliente(), CompraRequisicao.getDtRequisicao(), CompraRequisicao.getQntdRequisicao());
    }
}
