package com.flexpag.paymentscheduler.config.exceptions;

public class AlterarPagamento extends RuntimeException{
    
    public AlterarPagamento(){
        super("O pagamento já foi realizado e por isso não é possível alterá-lo ou excluí-lo");
    }
    
}