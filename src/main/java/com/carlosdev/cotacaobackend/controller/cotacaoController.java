package com.carlosdev.cotacaobackend.controller;
import com.carlosdev.cotacaobackend.service.CotacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cotacao")
public class cotacaoController {

    @Autowired
    CotacaoService cotacaoService;

    @GetMapping("/{moeda}")
    public ResponseEntity<?> getCotacao(@PathVariable(value = "moeda")String moeda, @RequestParam(value = "dt_inicial") String dataInicial, @RequestParam(value = "dt_final") String dataFinal ) {
        String cotacoes = cotacaoService.getCotacaoPorPeriodo(moeda, dataInicial, dataFinal);
        if (cotacoes != null) {
            return new ResponseEntity<>( cotacoes, HttpStatus.OK );
        }

        return new ResponseEntity<>( "Servico Indisponível", HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
