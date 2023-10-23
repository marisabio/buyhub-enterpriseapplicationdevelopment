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
@Table(name = "compras_pedido")
public class comprasPedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idPedido;


    private long idOrcamento;
    private long idRequisicao;
    private int quantidadePedido;
    private Date dataPedido;
    private String usuarioCliente;
    private long cnpjFornecedor;
    private int idProduto;
    private long cnpjFornecedor1;

}
