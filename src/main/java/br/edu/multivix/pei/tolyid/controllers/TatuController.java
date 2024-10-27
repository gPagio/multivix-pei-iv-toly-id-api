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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/tatus")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Tatu", description = "Envolve todas as operações com tatus. Exige autenticação por JWT.")
public class TatuController {

    @Autowired
    private TatuService tatuService;

    @Autowired
    private TatuRepository tatuRepository;

    @PostMapping(path = "/cadastrar")
    @Transactional
    @Operation(summary = "Cadastra Tatu", description = "Cadastra um tatu no banco de dados.")
    public ResponseEntity cadastraTatu(@RequestBody @Valid DadosCadastroTatuDTO dados, UriComponentsBuilder uriComponentsBuilder){
        var dadosListagemTatuDTO = tatuService.cadastraTatu(dados);
        var uri = uriComponentsBuilder.path("/tatus/listar/{identificacaoAnimal}").buildAndExpand(dadosListagemTatuDTO.identificacaoAnimal()).toUri();
        return ResponseEntity.created(uri).body(dadosListagemTatuDTO);
    }

    @GetMapping(path = "/listar/{identificacaoAnimal}")
    @Operation(summary = "Lista Tatu por Identificação do Animal", description = "Exibe um tatu pela identificação do animal.")
    public ResponseEntity listaTatuPorIdentificacaoAnimal(@PathVariable String identificacaoAnimal){
        var dadosListagemTatuDTO = tatuService.listaTatuPorIdentificacaoAnimal(identificacaoAnimal);
        return ResponseEntity.ok(dadosListagemTatuDTO);
    }

    @GetMapping(path = "/listar")
    @Operation(summary = "Lista Todos os Tatus", description = "Lista por meio de paginação todos os tatus cadastrados no banco de dados.")
    @Parameter(in = ParameterIn.QUERY, description = "Número da página para exibir. Primeira página é 0.", name = "page", content = @Content(schema = @Schema(type = "integer", defaultValue = "0")))
    @Parameter(in = ParameterIn.QUERY, description = "Quantidade de itens exibidos. Valor padrão é 10.", name = "size", content = @Content(schema = @Schema(type = "integer", defaultValue = "10")))
    @Parameter(in = ParameterIn.QUERY, description = "Critério de ordenação dos itens. Campo padrão é identificacaoAnimal.", name = "sort", content = @Content(schema = @Schema(type = "string", defaultValue = "identificacaoAnimal")))
    public ResponseEntity listaTodosOsTatus(@Parameter(hidden = true) @PageableDefault(size = 10, sort = "identificacaoAnimal") Pageable paginacao){
        var page = tatuRepository.findAll(paginacao).map(DadosListagemTatuDTO::new);
        return ResponseEntity.ok(page);
    }
    
}
