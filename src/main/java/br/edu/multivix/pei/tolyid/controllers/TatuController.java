package br.edu.multivix.pei.tolyid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.multivix.pei.tolyid.domain.tatu.TatuRepository;
import br.edu.multivix.pei.tolyid.domain.tatu.TatuService;
import br.edu.multivix.pei.tolyid.domain.tatu.dto.DadosCadastroTatuDTO;
import br.edu.multivix.pei.tolyid.domain.tatu.dto.DadosListagemTatuDTO;
import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/tatus")
public class TatuController {

    @Autowired
    private TatuService tatuService;

    @Autowired
    private TatuRepository tatuRepository;

    @PostMapping(path = "/cadastrar")
    @Transactional
    public ResponseEntity cadastraTatu(@RequestBody @Valid DadosCadastroTatuDTO dados, UriComponentsBuilder uriComponentsBuilder){
        var dadosListagemTatuDTO = tatuService.cadastraTatu(dados);
        var uri = uriComponentsBuilder.path("/tatus/listar/{identificacaoAnimal}").buildAndExpand(dadosListagemTatuDTO.identificacaoAnimal()).toUri();
        return ResponseEntity.created(uri).body(dadosListagemTatuDTO);
    }

    @GetMapping(path = "/listar/{identificacaoAnimal}")
    public ResponseEntity listaTatuPorIdentificacaoAnimal(@PathVariable String identificacaoAnimal){
        var dadosListagemTatuDTO = tatuService.listaTatuPorIdentificacaoAnimal(identificacaoAnimal);
        return ResponseEntity.ok(dadosListagemTatuDTO);
    }

    @GetMapping(path = "/listar")
    public ResponseEntity listaTodosOsTatus(@PageableDefault(size = 10, sort = "identificacaoAnimal") Pageable paginacao){
        var page = tatuRepository.findAll(paginacao).map(DadosListagemTatuDTO::new);
        return ResponseEntity.ok(page);
    }
    
}
