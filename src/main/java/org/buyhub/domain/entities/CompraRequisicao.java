package org.buyhub.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.buyhub.domain.DTOs.requisicao.DadosAtualizacaoRequisicao;
import org.buyhub.domain.DTOs.requisicao.DadosCadastroRequisicao;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_compra_requisicao")
public class CompraRequisicao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idRequisicao;

    @ManyToOne(targetEntity = CompraProduto.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduto")
    private List<CompraProduto> compraProduto;

    @ManyToOne(targetEntity = CompraFornecedor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpjFornecedor")
    private List<CompraFornecedor> compraFornecedor;

    @ManyToOne(targetEntity = CompraCliente.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioCliente")
    private List<CompraCliente> compraCliente;

    private Date dtRequisicao;
    private int qntdRequisicao;

    public CompraRequisicao(DadosCadastroRequisicao dados) {
        this.idRequisicao = dados.idRequisicao();
        this.compraProduto = dados.compraProduto();
        this.compraFornecedor = dados.compraFornecedor();
        this.compraCliente = dados.compraCliente();
        this.dtRequisicao = dados.dtRequisicao();
        this.qntdRequisicao = dados.qntdRequisicao();
    }

    public void atualizarInformacoes(DadosAtualizacaoRequisicao dados) {
        if (dados.idRequisicao() != null) {
            this.idRequisicao = dados.idRequisicao();
        }
        if (dados.compraProduto() != null) {
            this.compraProduto = dados.compraProduto();
        }
        if (dados.compraFornecedor() != null) {
            this.compraFornecedor = dados.compraFornecedor();
        }
        if (dados.compraCliente() != null) {
            this.compraCliente = dados.compraCliente();
        }
        if (dados.dtRequisicao() != null) {
            this.dtRequisicao = dados.dtRequisicao();
        }
        if (dados.qntdRequisicao() != 0) {
            this.qntdRequisicao = dados.qntdRequisicao();
        }
    }
}
