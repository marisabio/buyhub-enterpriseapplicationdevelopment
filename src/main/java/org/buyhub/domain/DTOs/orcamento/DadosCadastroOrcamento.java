package org.buyhub.domain.DTOs.orcamento;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraCliente;
import org.buyhub.domain.entities.CompraRequisicao;
import org.buyhub.domain.entities.CompraFornecedor;
import org.buyhub.domain.entities.CompraProduto;


import java.sql.Date;
import java.util.List;

public record DadosCadastroOrcamento(
        @NotBlank
        Long idOrcamento,
        @NotBlank
        @Valid
        List<CompraRequisicao> compraRequisicao,
        @NotBlank
        Date dtOrcamento,
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
