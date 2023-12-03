package org.buyhub.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.buyhub.domain.DTOs.pedido.DadosAtualizacaoPedido;
import org.buyhub.domain.DTOs.pedido.DadosCadastroPedido;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "compras_pedido")
public class ComprasPedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idPedido;

    @ManyToOne(targetEntity = CompraOrcamento.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_orcamento")
    private List<CompraOrcamento> compraOrcamento;

    @ManyToOne(targetEntity = CompraRequisicao.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_requisicao")
    private List<CompraRequisicao> compraRequisicao;

    private int quantidadePedido;
    private Date dataPedido;

    @ManyToOne(targetEntity = CompraCliente.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioCliente")
    private List<CompraCliente> compraCliente;

    @ManyToOne(targetEntity = CompraFornecedor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpjFornecedor")
    private List<CompraFornecedor> compraFornecedor;

    @ManyToOne(targetEntity = CompraProduto.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private List<CompraProduto> compraProduto;

    public ComprasPedido(DadosCadastroPedido dados) {
        this.idPedido = dados.idPedido();
        this.compraOrcamento = dados.compraOrcamento();
        this.compraRequisicao = dados.compraRequisicao();
        this.quantidadePedido = dados.quantidadePedido();
        this.dataPedido = dados.dataPedido();
        this.compraCliente = dados.compraCliente();
        this.compraFornecedor = dados.compraFornecedor();
        this.compraProduto = dados.compraProduto();
    }

    public void atualizarInformacoes(DadosAtualizacaoPedido dados) {
        if (dados.idPedido() != null) {
            this.idPedido = dados.idPedido();
        }
        if (dados.compraOrcamento() != null) {
            this.compraOrcamento = dados.compraOrcamento();
        }
        if (dados.compraRequisicao() != null) {
            this.compraRequisicao = dados.compraRequisicao();
        }
        if (dados.quantidadePedido() != 0) {
            this.quantidadePedido = dados.quantidadePedido();
        }
        if (dados.dataPedido() != null) {
            this.dataPedido = dados.dataPedido();
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
