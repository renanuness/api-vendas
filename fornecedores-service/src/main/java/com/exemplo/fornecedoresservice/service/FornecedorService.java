package com.exemplo.fornecedorservice.service;

import com.exemplo.fornecedorservice.client.ProdutosClient;
import com.exemplo.fornecedorservice.dto.CadastrarFornecedorDto;
import com.exemplo.fornecedorservice.exception.FornecedorNaoEncxontradoException;
import com.exemplo.fornecedorservice.model.Fornecedor;
import com.exemplo.fornecedorservice.model.Produto;
import com.exemplo.fornecedorservice.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Regra de negocio de Cliente. O controller nao fala direto com o repository,
 * fala com este service.
 */
@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final ProdutosClient client;

    public FornecedorService(FornecedorRepository fornecedorRepository, ProdutosClient client) {
        this.fornecedorRepository = fornecedorRepository;
        this.client = client;
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public Fornecedor cadastrar(CadastrarFornecedorDto dto) {
        return fornecedorRepository.save(new Fornecedor(dto.nome(), dto.cnpj()));
    }

    public List<Produto> obterProdutos(){
        return client.get();
    }
}
