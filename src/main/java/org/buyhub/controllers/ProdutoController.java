package org.buyhub.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.buyhub.domain.DTOs.produto.DadosAtualizacaoProduto;
import org.buyhub.domain.DTOs.produto.DadosCadastroProduto;
import org.buyhub.domain.DTOs.produto.DadosListagemProduto;
import org.buyhub.domain.DTOs.produto.RepositoryProduto;
import org.buyhub.domain.entities.CompraProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produto")
@Tag(name = "Produto",description = "CRUD de produto.")
public class ProdutoController {

    @Autowired
    private RepositoryProduto repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de produto", description = "Endpoint do cadastro de novos produtos.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {
        var produto = new CompraProduto(dados);
        repository.save(produto);
        var uri = uriBuilder.path("/produto/{idProduto}").buildAndExpand(produto.getIdProduto()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemProduto(produto));
    }

    @GetMapping
    @Operation(summary = "Listagem de produtos", description = "Endpoint da listagem de produtos cadastrados.")
    public ResponseEntity<Page<DadosListagemProduto>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemProduto::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{idProduto}")
    @Operation(summary = "Exibir produto", description = "Endpoint da exibição de um único produto cadastrado.")
    public ResponseEntity exibir(@PathVariable long CompraProduto) {
        var produto = repository.getReferenceById(CompraProduto);
        return ResponseEntity.ok(new DadosListagemProduto(produto));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar produto", description = "Endpoint da atualização de um único produto cadastrado.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados) {
        var produto = repository.getReferenceById(dados.idProduto());
        produto.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemProduto(produto));
    }

    @DeleteMapping("/{idProduto}")
    @Transactional
    @Operation(summary = "Excluir produto", description = "Endpoint da exclusão de um único produto cadastrado.")
    public ResponseEntity excluir(@PathVariable long CompraProduto) {
        repository.deleteById(CompraProduto);
        return ResponseEntity.ok().body("Cliente " + CompraProduto + " deletado.");
    }
}
