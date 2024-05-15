package org.buyhub.service.DTOs.produto;

import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraFornecedor;
import org.buyhub.domain.entities.CompraOrcamento;
import org.buyhub.domain.entities.CompraProduto;

import java.util.List;

public record DadosListagemProduto(
        Long idProduto,
        List<CompraFornecedor> compraFornecedor,
        String descProduto,
        double vlProduto,
        String aplicacaoProduto) {

    public DadosListagemProduto(CompraProduto CompraProduto) {
        this(CompraProduto.getIdProduto(), CompraProduto.getCompraFornecedor(), CompraProduto.getDescProduto(), CompraProduto.getVlProduto(), CompraProduto.getAplicacaoProd());
    }
}
