package org.buyhub.domain.DTOs.cliente;

import org.buyhub.domain.entities.CompraCliente;
import org.buyhub.domain.entities.CompraRequisicao;

import java.util.List;

public record DadosListagemCliente(
        String usuarioCliente,
        long cnpj,
        String nomeCliente,
        String senhaCliente,
        String setorCliente,
        List<CompraRequisicao> requisicao) {

    public DadosListagemCliente(CompraCliente cliente) {
        this(cliente.getUsuarioCliente(), cliente.getCnpj(), cliente.getNomeCliente(), cliente.getSenhaCliente(), cliente.getSetorCliente(), cliente.getCompraRequisicoes());
    }
}
