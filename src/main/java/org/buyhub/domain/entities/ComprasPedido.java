package org.buyhub.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_orcamento")
    private CompraOrcamento compraOrcamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_requisicao")
    private CompraRequisicao compraRequisicao;

    private int quantidadePedido;
    private Date dataPedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioCliente")
    private CompraCliente compraCliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpjFornecedor")
    private CompraFornecedor compraFornecedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private CompraProduto compraProduto;

}
