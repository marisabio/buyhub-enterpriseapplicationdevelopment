package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "compra_fornecedor")
public class compraFornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long cnpjFornecedor;

    private String senhaFornecedor;
    private String nomeFornecedor;
    private String ramoFornecedor;

    @OneToMany(mappedBy = "compraFornecedor", fetch = FetchType.LAZY)
    private List<compraOrcamento> compraOrcamento;
}
