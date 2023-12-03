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

   private long cnpj;
   private String nomeCliente;
   private String senhaCliente;
   private String setorCliente;

   @OneToMany(targetEntity = CompraRequisicao.class, mappedBy = "compraCliente", fetch = FetchType.LAZY)
   private List<CompraRequisicao> compraRequisicoes;

   public CompraCliente(DadosCadastroCliente dados) {
      this.usuarioCliente = dados.usuarioCliente();
      this.cnpj = dados.cnpj();
      this.nomeCliente = dados.nomeCliente();
      this.senhaCliente = dados.senhaCliente();
      this.compraRequisicoes = dados.requisicao();
   }

   public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
      if (dados.usuarioCliente() != null) {
         this.usuarioCliente = dados.usuarioCliente();
      }
      if (dados.cnpj() != null) {
         this.cnpj = dados.cnpj();
      }
      if (dados.nomeCliente() !=  null) {
         this.nomeCliente = dados.nomeCliente();
      }
      if (dados.senhaCliente() != null) {
         this.senhaCliente = dados.senhaCliente();
      }
      if (dados.requisicao() != null) {
         this.compraRequisicoes = dados.requisicao();
      }
   }
}
