package org.buyhub.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.buyhub.domain.DTOs.fornecedor.DadosAtualizacaoFornecedor;
import org.buyhub.domain.DTOs.fornecedor.RepositoryFornecedor;
import org.buyhub.domain.DTOs.fornecedor.DadosCadastroFornecedor;
import org.buyhub.domain.DTOs.fornecedor.DadosListagemFornecedor;
import org.buyhub.domain.entities.CompraFornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/fornecedores")
@Tag(name = "Fornecedor",description = "CRUD de fornecedor.")
public class ControllerFornecedor {

    private RepositoryFornecedor repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de fornecedor", description = "Endpoint do cadastro de novos fornecedores.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroFornecedor dados, UriComponentsBuilder uriBuilder) {
        var fornecedor = new CompraFornecedor(dados);
        repository.save(fornecedor);
        var uri = uriBuilder.path("/fornecedor/{cnpjFornecedor}").buildAndExpand(fornecedor.getCnpjFornecedor()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemFornecedor(fornecedor));
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "Listagem de fornecedores", description = "Endpoint da listagem de fornecedores cadastrados.")
    public ResponseEntity<Page<DadosListagemFornecedor>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemFornecedor::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping(path = "/{cnpjFornecedor}", produces = "application/json")
    @Operation(summary = "Exibir fornecedor", description = "Endpoint da exibição de um único fornecedor cadastrado.")
    public ResponseEntity exibir(@PathVariable Long CompraFornecedor) {
        var fornecedor = repository.getReferenceById(CompraFornecedor);
        return ResponseEntity.ok(new DadosListagemFornecedor(fornecedor));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar fornecedor", description = "Endpoint da atualização de um único fornecedor cadastrado.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoFornecedor dados) {
        var fornecedor = repository.getReferenceById(dados.cnpjFornecedor());
        fornecedor.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemFornecedor(fornecedor));
    }

    @DeleteMapping(path = "/{cnpjFornecedor}")
    @Transactional
    @Operation(summary = "Excluir fornecedor", description = "Endpoint da exclusão de um único fornecedor cadastrado.")
    public ResponseEntity excluir(@PathVariable Long CompraFornecedor) {
        repository.deleteById(CompraFornecedor);
        return ResponseEntity.ok().body("Fornecedor " + CompraFornecedor + " deletado.");
    }
}
