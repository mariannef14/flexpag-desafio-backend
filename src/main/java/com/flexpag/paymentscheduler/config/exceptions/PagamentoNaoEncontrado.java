package com.flexpag.paymentscheduler.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PagamentoNaoEncontrado extends RuntimeException{
    
    public PagamentoNaoEncontrado(long id){
        super("O pagamento " + id + " não foi encontrado");
    }
    
}