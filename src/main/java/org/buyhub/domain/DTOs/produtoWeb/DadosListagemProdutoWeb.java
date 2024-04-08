package org.buyhub.domain.DTOs.produtoWeb;

import org.buyhub.domain.entities.ProdutoWeb;

public record DadosListagemProdutoWeb(
        String titulo,
        String preco,
        String url) {

    public DadosListagemProdutoWeb(ProdutoWeb ProdutoWeb) {
        this(ProdutoWeb.getTitulo(), ProdutoWeb.getPreco(), ProdutoWeb.getUrl());
    }
}
