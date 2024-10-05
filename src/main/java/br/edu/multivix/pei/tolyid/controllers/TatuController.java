package br.edu.multivix.pei.tolyid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.multivix.pei.tolyid.domain.tatu.DadosCadastroTatuDTO;
import br.edu.multivix.pei.tolyid.domain.tatu.TatuService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tatus")
public class TatuController {

    @Autowired
    private TatuService tatuService;

    @SuppressWarnings("rawtypes")
    @PostMapping(path = "/cadastrar")
    @Transactional
    public ResponseEntity cadastraTatu(@RequestBody @Valid DadosCadastroTatuDTO dados){
        var dadosListagemTatuDTO = tatuService.cadastraTatu(dados);
        return ResponseEntity.ok(dadosListagemTatuDTO);
    }
    
}
