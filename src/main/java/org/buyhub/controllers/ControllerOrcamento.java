package org.buyhub.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.buyhub.domain.entities.CompraOrcamento;
import org.buyhub.exceptions.ResourceNotFoundException;
import org.buyhub.service.DTOs.orcamento.DadosAtualizacaoOrcamento;
import org.buyhub.service.DTOs.orcamento.DadosCadastroOrcamento;
import org.buyhub.service.DTOs.orcamento.DadosListagemOrcamento;
import org.buyhub.service.DTOs.orcamento.RepositoryOrcamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/orcamentos")
@Tag(name = "Orçamento", description = "CRUD de orçamento.")
public class ControllerOrcamento {

    @Autowired
    private RepositoryOrcamento repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de orçamento", description = "Endpoint do cadastro de novos orçamentos.")
    public ResponseEntity<DadosListagemOrcamento> cadastrar(@RequestBody @Valid DadosCadastroOrcamento dados, UriComponentsBuilder uriBuilder) {
        var orcamento = new CompraOrcamento(dados);
        repository.save(orcamento);
        var uri = uriBuilder.path("/orcamentos/{idOrcamento}").buildAndExpand(orcamento.getIdOrcamento()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemOrcamento(orcamento));
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "Listagem de orçamentos", description = "Endpoint da listagem de orçamentos cadastrados.")
    public ResponseEntity<Page<DadosListagemOrcamento>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemOrcamento::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping(path = "/{idOrcamento}", produces = "application/json")
    @Operation(summary = "Exibir orçamento", description = "Endpoint da exibição de um único orçamento cadastrado.")
    public ResponseEntity<DadosListagemOrcamento> exibir(@PathVariable Long idOrcamento) {
        var orcamento = repository.findById(idOrcamento)
                .orElseThrow(() -> new ResourceNotFoundException("Orçamento não encontrado para este ID :: " + idOrcamento));
        return ResponseEntity.ok(new DadosListagemOrcamento(orcamento));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar orçamento", description = "Endpoint da atualização de um único orçamento cadastrado.")
    public ResponseEntity<DadosListagemOrcamento> atualizar(@RequestBody @Valid DadosAtualizacaoOrcamento dados) {
        var orcamento = repository.findById(dados.idOrcamento())
                .orElseThrow(() -> new ResourceNotFoundException("Orçamento não encontrado para este ID :: " + dados.idOrcamento()));
        orcamento.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemOrcamento(orcamento));
    }

    @DeleteMapping(path = "/{idOrcamento}")
    @Transactional
    @Operation(summary = "Excluir orçamento", description = "Endpoint da exclusão de um único orçamento cadastrado.")
    public ResponseEntity<String> excluir(@PathVariable Long idOrcamento) {
        var orcamento = repository.findById(idOrcamento)
                .orElseThrow(() -> new ResourceNotFoundException("Orçamento não encontrado para este ID :: " + idOrcamento));
        repository.delete(orcamento);
        return ResponseEntity.ok("Orçamento " + idOrcamento + " deletado.");
    }
}
