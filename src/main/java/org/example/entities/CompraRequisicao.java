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
@Table(name = "compra_requisicao")
public class CompraRequisicao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idRequisicao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private CompraProduto compraProduto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpj_forncedor")
    private CompraFornecedor compraFornecedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioCliente")
    private CompraCliente compraCliente;

    private Date dataRequisicao;
    private int quantidadeRequisicao;



}
