package org.buyhub.domain.DTOs.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.buyhub.domain.entities.CompraRequisicao;

import java.util.List;

public record DadosAtualizacaoCliente(
        @NotNull
        @Email
        String usuarioCliente,
        Long cnpj,
        String nmCliente,
        String senhaCliente,
        String setorCliente,
        List<CompraRequisicao> requisicao
        ) {
}
