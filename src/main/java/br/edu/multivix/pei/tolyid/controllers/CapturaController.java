package br.edu.multivix.pei.tolyid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.multivix.pei.tolyid.domain.captura.CapturaRepository;
import br.edu.multivix.pei.tolyid.domain.captura.CapturaService;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosCadastroCapturaDTO;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosListagemCapturaDTO;
import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/capturas")
public class CapturaController {

    @Autowired
    private CapturaService capturaService;

    @Autowired
    private CapturaRepository capturaRepository;

    @PostMapping(path = "/cadastrar/{idTatu}")
    @Transactional
    public ResponseEntity cadastraCaptura (@PathVariable Long idTatu, @RequestBody @Valid DadosCadastroCapturaDTO dados, UriComponentsBuilder uriComponentsBuilder){
        var dadosListagemCaptura = capturaService.cadastraCaptura(idTatu, dados);
        var uri = uriComponentsBuilder.path("/capturas/listar/{id}").buildAndExpand(dadosListagemCaptura.id()).toUri();
        return ResponseEntity.created(uri).body(dadosListagemCaptura);
    }

    @GetMapping(path = "/listar/{id}")
    public ResponseEntity listaCapturaPorId(@PathVariable Long id){
        var dadosListagemTatuDTO = capturaService.listaCapturaPorId(id);
        return ResponseEntity.ok(dadosListagemTatuDTO);
    }


    @GetMapping(path = "/listar")
    public ResponseEntity listaTodasAsCapturas(@PageableDefault(size = 10, sort = "id") Pageable paginacao){
        var page = capturaRepository.findAll(paginacao).map(DadosListagemCapturaDTO::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping(path = "/deletar/{id}")
    public ResponseEntity deletaCapturaPorId(@PathVariable Long id){
        capturaService.deletaCapturaPorId(id);
        return ResponseEntity.noContent().build();
    }

}
