package com.exemplo.fornecedorservice.client;

import com.exemplo.fornecedorservice.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "produtos-service", path = "/produtos")
public interface ProdutosClient {
    @RequestMapping(method = RequestMethod.GET)
    public List<Produto> get();
}