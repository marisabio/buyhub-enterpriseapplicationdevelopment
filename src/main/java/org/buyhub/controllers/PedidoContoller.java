package org.buyhub.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.buyhub.domain.DTOs.pedido.DadosAtualizacaoPedido;
import org.buyhub.domain.DTOs.pedido.DadosCadastroPedido;
import org.buyhub.domain.DTOs.pedido.DadosListagemPedido;
import org.buyhub.domain.DTOs.pedido.RepositoryPedido;
import org.buyhub.domain.entities.ComprasPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pedido")
@Tag(name = "Pedido",description = "CRUD de pedido.")
public class PedidoContoller {

    @Autowired
    private RepositoryPedido repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de pedido", description = "Endpoint do cadastro de novos pedidos.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPedido dados, UriComponentsBuilder uriBuilder) {
        var pedido = new ComprasPedido(dados);
        repository.save(pedido);
        var uri = uriBuilder.path("/pedido/{idPedido}").buildAndExpand(pedido.getIdPedido()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemPedido(pedido));
    }

    @GetMapping
    @Operation(summary = "Listagem de pedido", description = "Endpoint da listagem de pedidos cadastrados.")
    public ResponseEntity<Page<DadosListagemPedido>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemPedido::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{pedido}")
    @Operation(summary = "Exibir pedido", description = "Endpoint da exibição de um único pedido cadastrado.")
    public ResponseEntity exibir(@PathVariable Long ComprasPedido) {
        var pedido = repository.getReferenceById(ComprasPedido);
        return ResponseEntity.ok(new DadosListagemPedido(pedido));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar pedido", description = "Endpoint da atualização de um único pedido cadastrado.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPedido dados) {
        var pedido = repository.getReferenceById(dados.idPedido());
        pedido.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemPedido(pedido));
    }

    @DeleteMapping("/{pedido}")
    @Transactional
    @Operation(summary = "Excluir pedido", description = "Endpoint da exclusão de um único pedido cadastrado.")
    public ResponseEntity excluir(@PathVariable Long ComprasPedido) {
        repository.deleteById(ComprasPedido);
        return ResponseEntity.ok().body("Pedido " + ComprasPedido + " deletado.");
    }
}
