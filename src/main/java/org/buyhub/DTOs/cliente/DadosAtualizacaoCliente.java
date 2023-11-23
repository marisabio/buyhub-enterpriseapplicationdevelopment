package org.buyhub.DTOs.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.buyhub.entities.CompraRequisicao;

import java.util.List;

public record DadosAtualizacaoCliente(
        @NotNull
        @Email
        String usuarioCliente,
        Long cnpj,
        String nomeCliente,
        String senhaCliente,
        String setorCliente,
        List<CompraRequisicao> requisicao) {
}
