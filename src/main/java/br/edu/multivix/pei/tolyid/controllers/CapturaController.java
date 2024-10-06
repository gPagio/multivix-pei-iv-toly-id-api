package br.edu.multivix.pei.tolyid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.multivix.pei.tolyid.domain.captura.CapturaService;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosCadastroCapturaDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/capturas")
public class CapturaController {

    @Autowired
    private CapturaService capturaService;

    @SuppressWarnings("rawtypes")
    @PostMapping(path = "/cadastrar/{idTatu}")
    @Transactional
    public ResponseEntity cadastraCaptura (@PathVariable Long idTatu, @RequestBody @Valid DadosCadastroCapturaDTO dados){
        var dadosListagemCaptura = capturaService.cadastraCaptura(idTatu, dados);
        return ResponseEntity.ok(dadosListagemCaptura);
    }

}
