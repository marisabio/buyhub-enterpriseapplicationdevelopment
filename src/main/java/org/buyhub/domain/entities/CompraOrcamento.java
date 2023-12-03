package org.buyhub.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.buyhub.domain.DTOs.orcamento.DadosAtualizacaoOrcamento;
import org.buyhub.domain.DTOs.orcamento.DadosCadastroOrcamento;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "compra_orcamento")
public class CompraOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrcamento;

    @ManyToOne(targetEntity = CompraRequisicao.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_requisicao")
    private List<CompraRequisicao> compraRequisicao;

    private Date dataOrcamento;

    @ManyToOne(targetEntity = CompraCliente.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioCliente")
    private List<CompraCliente> compraCliente;

    @ManyToOne(targetEntity = CompraFornecedor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpjFornecedor")
    private List<CompraFornecedor> compraFornecedor;

    @ManyToOne(targetEntity = CompraProduto.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private List<CompraProduto> compraProduto;

    public CompraOrcamento(DadosCadastroOrcamento dados) {
        this.idOrcamento = dados.idOrcamento();
        this.compraRequisicao = dados.compraRequisicao();
        this.dataOrcamento = dados.dataOrcamento();
        this.compraCliente = dados.compraCliente();
        this.compraFornecedor = dados.compraFornecedor();
        this.compraProduto = dados.compraProduto();
    }

   public void atualizarInformacoes(DadosAtualizacaoOrcamento dados) {
        if (dados.idOrcamento() != null) {
            this.idOrcamento = dados.idOrcamento();
        }
        if (dados.compraRequisicao() != null) {
            this.compraRequisicao = dados.compraRequisicao();
        }
        if (dados.dataOrcamento() != null) {
            this.dataOrcamento = dados.dataOrcamento();
        }
        if (dados.compraCliente() != null) {
            this.compraCliente = dados.compraCliente();
        }
        if (dados.compraFornecedor() != null) {
            this.compraFornecedor = dados.compraFornecedor();
        }
        if (dados.compraProduto() != null) {
            this.compraProduto = dados.compraProduto();
        }
   }
}
