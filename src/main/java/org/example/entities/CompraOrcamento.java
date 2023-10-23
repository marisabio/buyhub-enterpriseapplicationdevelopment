package org.example.entities;

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
@Table(name = "compra_orcamento")
public class CompraOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrcamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_requisicao")
    private CompraRequisicao compraRequisicao;

    private Date dataOrcamento;

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
