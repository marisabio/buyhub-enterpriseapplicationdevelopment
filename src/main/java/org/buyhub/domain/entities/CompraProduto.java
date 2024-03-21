package org.buyhub.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.buyhub.domain.DTOs.produto.DadosAtualizacaoProduto;
import org.buyhub.domain.DTOs.produto.DadosCadastroProduto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_compra_produto")
public class CompraProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;

    @ManyToOne(targetEntity = CompraFornecedor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpj_fornecedor")
    private List<CompraFornecedor> compraFornecedor;

    private String descProduto;
    private double vlProduto;
    private String aplicacaoProd;

    public CompraProduto(DadosCadastroProduto dados) {
        this.idProduto = dados.idProduto();
        this.compraFornecedor = dados.compraFornecedor();
        this.descProduto = dados.descProduto();
        this.vlProduto = dados.vlProduto();
        this.aplicacaoProd = dados.aplicacaoProd();
    }

    public void atualizarInformacoes(DadosAtualizacaoProduto dados) {
        if (dados.idProduto() != null) {
            this.idProduto = dados.idProduto();
        }
        if (dados.compraFornecedor() != null) {
            this.compraFornecedor = dados.compraFornecedor();
        }
        if (dados.descProduto() != null) {
            this.descProduto = dados.descProduto();
        }
        if (dados.vlProduto() != 0) {
            this.vlProduto = dados.vlProduto();
        }
        if (dados.aplicacaoProd() != null) {
            this.aplicacaoProd = dados.aplicacaoProd();
        }
    }

}
