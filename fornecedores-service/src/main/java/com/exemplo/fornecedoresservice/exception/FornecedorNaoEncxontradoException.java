package com.exemplo.fornecedorservice.exception;

public class FornecedorNaoEncxontradoException extends RuntimeException {
    public FornecedorNaoEncxontradoException(){
        super("Fornecedor não encontrado");
    }
}
