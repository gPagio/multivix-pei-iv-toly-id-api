package br.edu.multivix.pei.tolyid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.multivix.pei.tolyid.domain.captura.CapturaRepository;
import br.edu.multivix.pei.tolyid.domain.captura.CapturaService;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosAtualizacaoCapturaDTO;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosCadastroCapturaDTO;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosListagemCapturaDTO;
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
@RequestMapping("/capturas")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Captura", description = "Envolve todas as operações com capturas. Exige autenticação por JWT.")
public class CapturaController {

    @Autowired
    private CapturaService capturaService;

    @Autowired
    private CapturaRepository capturaRepository;

    @PostMapping(path = "/cadastrar/{idTatu}")
    @Transactional
    @Operation(summary = "Cadastra Captura", description = "Cadastra uma captura no banco de dados.")
    public ResponseEntity cadastraCaptura (@PathVariable Long idTatu, @RequestBody @Valid DadosCadastroCapturaDTO dados, UriComponentsBuilder uriComponentsBuilder){
        var dadosListagemCapturaDTO = capturaService.cadastraCaptura(idTatu, dados);
        var uri = uriComponentsBuilder.path("/capturas/listar/{id}").buildAndExpand(dadosListagemCapturaDTO.id()).toUri();
        return ResponseEntity.created(uri).body(dadosListagemCapturaDTO);
    }

    @GetMapping(path = "/listar/{id}")
    @Operation(summary = "Lista Captura por Id", description = "Exibe uma captura pelo id.")
    public ResponseEntity listaCapturaPorId(@PathVariable Long id){
        var dadosListagemCapturaDTO = capturaService.listaCapturaPorId(id);
        return ResponseEntity.ok(dadosListagemCapturaDTO);
    }

    @GetMapping(path = "/listar")
    @Operation(summary = "Lista Todas as Capturas", description = "Lista por meio de paginação todas as capturas cadastradas no banco de dados.")
    @Parameter(in = ParameterIn.QUERY, description = "Número da página para exibir. Primeira página é 0.", name = "page", content = @Content(schema = @Schema(type = "integer", defaultValue = "0")))
    @Parameter(in = ParameterIn.QUERY, description = "Quantidade de itens exibidos. Valor padrão é 10.", name = "size", content = @Content(schema = @Schema(type = "integer", defaultValue = "10")))
    @Parameter(in = ParameterIn.QUERY, description = "Critério de ordenação dos itens. Campo padrão é id.", name = "sort", content = @Content(schema = @Schema(type = "string", defaultValue = "id")))
    public ResponseEntity listaTodasAsCapturas(@Parameter(hidden = true) @PageableDefault(size = 10, sort = "id") Pageable paginacao){
        var page = capturaRepository.findAll(paginacao).map(DadosListagemCapturaDTO::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping(path = "/deletar/{id}")
    @Transactional
    @Operation(summary = "Deleta Captura", description = "Deleta captura pelo id.")
    public ResponseEntity deletaCapturaPorId(@PathVariable Long id){
        capturaService.deletaCapturaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(path = "/atualizar/{id}")
    @Transactional
    @Operation(summary = "Atualiza Captura", description = "Atualiza os campos de uma captura. Permite que apenas os campos necessários sejam atualizados, basta informar apenas o necessário.")
    public ResponseEntity atualizaCapturaPorId(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoCapturaDTO dados){
        var dadosListagemCapturaDTO = capturaService.atualizaCapturaPorId(id, dados);
        return ResponseEntity.ok(dadosListagemCapturaDTO);
    }

}
