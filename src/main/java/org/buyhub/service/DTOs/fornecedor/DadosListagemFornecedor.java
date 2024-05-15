package org.buyhub.service.DTOs.fornecedor;

import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraFornecedor;
import org.buyhub.domain.entities.CompraOrcamento;
import org.buyhub.domain.entities.CompraProduto;

import java.util.List;

public record DadosListagemFornecedor(
        Long cnpjFornecedor,
        String senhaFornecedor,
        String nmFornecedor,
        String ramoFornecedor,
        List<CompraOrcamento> compraOrcamentos,
        List<CompraProduto> compraProdutos) {

    public DadosListagemFornecedor(CompraFornecedor CompraFornecedor) {
        this(CompraFornecedor.getCnpjFornecedor(), CompraFornecedor.getSenhaFornecedor(), CompraFornecedor.getNmFornecedor(), CompraFornecedor.getRamoFornecedor(), CompraFornecedor.getCompraOrcamentos(), CompraFornecedor.getCompraProdutos());
    }
}
