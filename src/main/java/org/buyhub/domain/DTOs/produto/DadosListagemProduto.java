package org.buyhub.domain.DTOs.produto;

import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraFornecedor;
import org.buyhub.domain.entities.CompraOrcamento;
import org.buyhub.domain.entities.CompraProduto;

import java.util.List;

public record DadosListagemProduto(
        Long idProduto,
        List<CompraFornecedor> compraFornecedor,
        String descricaoProduto,
        double valorProduto,
        String aplicacaoProduto) {

    public DadosListagemProduto(CompraProduto CompraProduto) {
        this(CompraProduto.getIdProduto(), CompraProduto.getCompraFornecedor(), CompraProduto.getDescricaoProduto(), CompraProduto.getValorProduto(), CompraProduto.getAplicacaoProduto());
    }
}
