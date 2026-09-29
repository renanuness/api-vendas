package com.exemplo.fornecedorservice.controller;

import com.exemplo.fornecedorservice.dto.CadastrarFornecedorDto;
import com.exemplo.fornecedorservice.exception.FornecedorNaoEncxontradoException;
import com.exemplo.fornecedorservice.model.Fornecedor;
import com.exemplo.fornecedorservice.service.FornecedorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService service;

    public String eureka;
    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fornecedor> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("{id}")
    public ResponseEntity obterPorId(@PathVariable long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CadastrarFornecedorDto dto){
        var fornecedor = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedor);

    }

    @GetMapping("/produtos")
    public ResponseEntity produtos(){
        var produtos = service.obterProdutos();

        return ResponseEntity.ok(produtos);
    }
}
