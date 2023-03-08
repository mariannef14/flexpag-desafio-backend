package com.flexpag.paymentscheduler.controller;

import java.util.List;

import com.flexpag.paymentscheduler.model.Pagamento;
import com.flexpag.paymentscheduler.service.PagamentoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    PagamentoService pagamentoService;

    PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Pagamento>> buscarTodosAgendamentos() {
        return ResponseEntity.ok(pagamentoService.buscarTodosAgendamentosPagamento());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPagamento(@PathVariable long id){
        return ResponseEntity.ok(pagamentoService.buscarAgendamentoPagamento(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Pagamento> agendarPagamento(@RequestBody Pagamento pagamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.agendarPagamento(pagamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> alterarAgendamentoPagamento(@PathVariable long id, @RequestBody Pagamento pagamentoAtualizado){
        return ResponseEntity.ok(pagamentoService.alterarAgendamentoPagamento(id, pagamentoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAgendamentoPagamento(@PathVariable long id){
        pagamentoService.deletarAgendamentoPagamento(id);

        return ResponseEntity.noContent().build();
    }

}