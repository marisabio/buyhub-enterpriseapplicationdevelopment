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
@Table(name = "compra_cliente")
public class CompraCliente {

   @Id
   private String usuarioCliente;

   private long cnpj;
   private String nomeCliente;
   private String senhaCliente;
   private String setorCliente;

   @OneToMany(mappedBy = "compraCliente", fetch = FetchType.LAZY)
   private List<CompraRequisicao> compraRequisicaos;

}
