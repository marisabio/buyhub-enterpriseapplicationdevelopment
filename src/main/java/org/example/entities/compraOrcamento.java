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
public class compraOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrcamento;

    //private long idRequisicao;
    private Date dataOrcamento;
    //private long cnpjFornecedor;
    private int idProduto;
    private long cnpjFornecedor1;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioCliente")
    private compraRequisicao compraRequisicao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpjFornecedor")
    private compraFornecedor compraFornecedor;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioCliente")
    private compraRequisicao usuarioCliente;*/

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRequisicao")
    private compraRequisicao idRequisicao;*/
}
