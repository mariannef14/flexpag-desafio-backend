package com.flexpag.paymentscheduler.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flexpag.paymentscheduler.config.exceptions.AlterarPagamento;
import com.flexpag.paymentscheduler.config.exceptions.PagamentoNaoEncontrado;
import com.flexpag.paymentscheduler.model.Pagamento;
import com.flexpag.paymentscheduler.repository.PagamentoRepository;

@Service
public class PagamentoService {

    private PagamentoRepository pagamentoRepository;

    PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<Pagamento> buscarTodosAgendamentosPagamento() {
        return pagamentoRepository.findAll();
    }

    public Pagamento buscarAgendamentoPagamento(long id) throws PagamentoNaoEncontrado {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);

        if (pagamento.isPresent()) {            
            if(pagamento.get().getStatus() != "paid"){
                LocalDateTime data = LocalDateTime.now();      
  
                if(data.equals(pagamento.get().getDataHora()) || data.isAfter(pagamento.get().getDataHora())){
        
                    pagamento.get().setStatus("paid");
                    pagamentoRepository.save(pagamento.get());
                }
            }
                return pagamento.get();
        } else
            throw new PagamentoNaoEncontrado(id);
    }

    public Pagamento agendarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento alterarAgendamentoPagamento(long id, Pagamento pagamentoAtualizado) throws AlterarPagamento{
        Pagamento pagamento = buscarAgendamentoPagamento(id);

        if(pagamento.getStatus() == "pending") {
            pagamento.setDataHora(pagamentoAtualizado.getDataHora());
            return pagamentoRepository.save(pagamento);
        } else
            throw new AlterarPagamento();
    }

    public void deletarAgendamentoPagamento(long id) throws AlterarPagamento{
        Pagamento pagamento = buscarAgendamentoPagamento(id);

        if(pagamento.getStatus() == "pending")
            pagamentoRepository.delete(pagamento);
        else
            throw new AlterarPagamento();
    }
    
}