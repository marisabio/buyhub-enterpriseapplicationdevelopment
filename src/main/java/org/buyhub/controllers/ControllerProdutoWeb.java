package org.buyhub.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.buyhub.exceptions.ResourceNotFoundException;
import org.buyhub.service.DTOs.produtoWeb.DadosListagemProdutoWeb;
import org.buyhub.service.DTOs.produtoWeb.RepositoryProdutoWeb;
import org.buyhub.domain.entities.ProdutoWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto_web")
@Tag(name = "Webscrapping", description = "Resultados do webscrapping.")
public class ControllerProdutoWeb {

    @Autowired
    private RepositoryProdutoWeb repository;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Resultados do webscrapping", description = "Endpoint da listagem dos resultados do webscrapping.")
    public ResponseEntity<Page<DadosListagemProdutoWeb>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemProdutoWeb::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping(path = "/{titulo}", produces = "application/json")
    @Operation(summary = "Resultado do webscrapping", description = "Endpoint da exibição de um único resultado do webscrapping.")
    public ResponseEntity<DadosListagemProdutoWeb> exibir(@PathVariable String titulo) {
        var produtoWeb = repository.findById(titulo)
                .orElseThrow(() -> new ResourceNotFoundException("ProdutoWeb não encontrado para este título :: " + titulo));
        return ResponseEntity.ok(new DadosListagemProdutoWeb(produtoWeb));
    }
}
