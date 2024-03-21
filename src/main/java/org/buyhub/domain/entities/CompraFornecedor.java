package org.buyhub.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.buyhub.domain.DTOs.fornecedor.DadosAtualizacaoFornecedor;
import org.buyhub.domain.DTOs.fornecedor.DadosCadastroFornecedor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_compra_fornecedor")
public class CompraFornecedor {

    @Id
    private long cnpjFornecedor;

    private String senhaFornecedor;
    private String nmFornecedor;
    private String ramoFornecedor;

    @OneToMany(targetEntity = CompraOrcamento.class, mappedBy = "compraFornecedor", fetch = FetchType.LAZY)
    private List<CompraOrcamento> compraOrcamentos;

    @OneToMany(targetEntity = CompraProduto.class, mappedBy = "compraFornecedor", fetch = FetchType.LAZY)
    private List<CompraProduto> compraProdutos;

    public CompraFornecedor(DadosCadastroFornecedor dados) {
        this.cnpjFornecedor = dados.cnpjFornecedor();
        this.senhaFornecedor = dados.senhaFornecedor();
        this.nmFornecedor = dados.nmFornecedor();
        this.ramoFornecedor = dados.ramoFornecedor();
        this.compraOrcamentos = dados.compraOrcamentos();
        this.compraProdutos = dados.compraProdutos();
    }

    public void atualizarInformacoes(DadosAtualizacaoFornecedor dados) {
        if (dados.cnpjFornecedor() != null) {
            this.cnpjFornecedor = dados.cnpjFornecedor();
        }
        if (dados.senhaFornecedor() != null) {
            this.senhaFornecedor = dados.senhaFornecedor();
        }
        if (dados.nmFornecedor() != null) {
            this.nmFornecedor = dados.nmFornecedor();
        }
        if (dados.ramoFornecedor() != null) {
            this.compraOrcamentos = dados.compraOrcamentos();
        }
        if (dados.compraOrcamentos() != null) {
            this.compraOrcamentos = dados.compraOrcamentos();
        }
        if (dados.compraProdutos() != null) {
            this.compraProdutos = dados.compraProdutos();
        }
    }
}
