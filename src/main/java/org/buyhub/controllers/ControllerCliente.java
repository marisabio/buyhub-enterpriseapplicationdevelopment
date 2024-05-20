package org.buyhub.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.buyhub.domain.entities.CompraCliente;
import org.buyhub.exceptions.ResourceNotFoundException;
import org.buyhub.service.DTOs.cliente.DadosAtualizacaoCliente;
import org.buyhub.service.DTOs.cliente.DadosCadastroCliente;
import org.buyhub.service.DTOs.cliente.DadosListagemCliente;
import org.buyhub.service.DTOs.cliente.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Cliente", description = "CRUD do Cliente.")
public class ControllerCliente {

    @Autowired
    private RepositoryCliente repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de cliente", description = "Endpoint do cadastro de novos clientes.")
    public ResponseEntity<DadosListagemCliente> cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
        var cliente = new CompraCliente(dados);
        repository.save(cliente);
        var uri = uriBuilder.path("/clientes/{usuarioCliente}").buildAndExpand(cliente.getUsuarioCliente()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemCliente(cliente));
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "Listagem de clientes", description = "Endpoint da listagem de clientes cadastrados.")
    public ResponseEntity<Page<DadosListagemCliente>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemCliente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping(path = "/{usuarioCliente}", produces = "application/json")
    @Operation(summary = "Exibir cliente", description = "Endpoint da exibição de um único cliente cadastrado.")
    public ResponseEntity<DadosListagemCliente> exibir(@PathVariable String usuarioCliente) {
        var cliente = repository.findById(usuarioCliente)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para este ID :: " + usuarioCliente));
        return ResponseEntity.ok(new DadosListagemCliente(cliente));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar cliente", description = "Endpoint da atualização de um único cliente cadastrado.")
    public ResponseEntity<DadosListagemCliente> atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados) {
        var cliente = repository.findById(dados.usuarioCliente())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para este ID :: " + dados.usuarioCliente()));
        cliente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemCliente(cliente));
    }

    @DeleteMapping(path = "/{usuarioCliente}")
    @Transactional
    @Operation(summary = "Excluir cliente", description = "Endpoint da exclusão de um único cliente cadastrado.")
    public ResponseEntity<String> excluir(@PathVariable String usuarioCliente) {
        var cliente = repository.findById(usuarioCliente)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para este ID :: " + usuarioCliente));
        repository.delete(cliente);
        return ResponseEntity.ok("Cliente " + usuarioCliente + " deletado.");
    }
}
