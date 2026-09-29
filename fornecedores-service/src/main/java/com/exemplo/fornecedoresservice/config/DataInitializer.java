package com.exemplo.fornecedorservice.config;

import com.exemplo.fornecedorservice.model.Fornecedor;
import com.exemplo.fornecedorservice.repository.FornecedorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Popula o banco H2 em memoria com fornecedores de teste assim que a aplicacao sobe.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final FornecedorRepository fornecedorRepository;

    public DataInitializer(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public void run(String... args) {
        fornecedorRepository.save(new Fornecedor("Tech Solutions Ltda", "11.222.333/0001-81"));
        fornecedorRepository.save(new Fornecedor("Distribuidora Alpha S.A.", "22.333.444/0001-05"));
        fornecedorRepository.save(new Fornecedor("Comercial Beta ME", "33.444.555/0001-27"));
        fornecedorRepository.save(new Fornecedor("Indústria Gamma Eireli", "44.555.666/0001-43"));
        fornecedorRepository.save(new Fornecedor("Serviços Delta Ltda", "55.666.777/0001-69"));
    }
}
