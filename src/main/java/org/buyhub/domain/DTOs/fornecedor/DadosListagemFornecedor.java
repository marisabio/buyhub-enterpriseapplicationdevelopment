package org.buyhub.domain.DTOs.fornecedor;

import jakarta.validation.constraints.NotBlank;
import org.buyhub.domain.entities.CompraFornecedor;
import org.buyhub.domain.entities.CompraOrcamento;
import org.buyhub.domain.entities.CompraProduto;

import java.util.List;

public record DadosListagemFornecedor(
        Long cnpjFornecedor,
        String senhaFornecedor,
        String nomeFornecedor,
        String ramoFornecedor,
        List<CompraOrcamento> compraOrcamentos,
        List<CompraProduto> compraProdutos) {

    public DadosListagemFornecedor(CompraFornecedor CompraFornecedor) {
        this(CompraFornecedor.getCnpjFornecedor(), CompraFornecedor.getSenhaFornecedor(), CompraFornecedor.getNomeFornecedor(), CompraFornecedor.getRamoFornecedor(), CompraFornecedor.getCompraOrcamentos(), CompraFornecedor.getCompraProdutos());
    }
}
