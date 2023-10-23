package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "compra_produto")
public class CompraProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpj_fornecedor")
    private CompraFornecedor compraFornecedor;

    private String descricaoProduto;
    private double valorProduto;
    private String aplicacaoProduto;
}
