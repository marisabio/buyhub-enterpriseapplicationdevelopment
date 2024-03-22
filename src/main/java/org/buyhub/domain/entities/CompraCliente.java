package org.buyhub.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.buyhub.domain.DTOs.cliente.DadosAtualizacaoCliente;
import org.buyhub.domain.DTOs.cliente.DadosCadastroCliente;

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

   private long cnpjCliente;
   private String nmCliente;
   private String senhaCliente;
   private String setorCliente;

   @OneToMany(targetEntity = CompraRequisicao.class, mappedBy = "compraCliente", fetch = FetchType.LAZY)
   private List<CompraRequisicao> compraRequisicoes;

   public CompraCliente(DadosCadastroCliente dados) {
      this.usuarioCliente = dados.usuarioCliente();
      this.cnpjCliente = dados.cnpjCliente();
      this.nmCliente = dados.nmCliente();
      this.senhaCliente = dados.senhaCliente();
      this.compraRequisicoes = dados.requisicao();
   }

   public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
      if (dados.usuarioCliente() != null) {
         this.usuarioCliente = dados.usuarioCliente();
      }
      if (dados.cnpj() != null) {
         this.cnpjCliente = dados.cnpj();
      }
      if (dados.nmCliente() !=  null) {
         this.nmCliente = dados.nmCliente();
      }
      if (dados.senhaCliente() != null) {
         this.senhaCliente = dados.senhaCliente();
      }
      if (dados.requisicao() != null) {
         this.compraRequisicoes = dados.requisicao();
      }
   }
}
