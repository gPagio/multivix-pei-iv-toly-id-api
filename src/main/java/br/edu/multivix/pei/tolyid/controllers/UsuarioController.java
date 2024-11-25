package br.edu.multivix.pei.tolyid.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.multivix.pei.tolyid.domain.usuario.UsuarioService;
import br.edu.multivix.pei.tolyid.domain.usuario.dto.DadosAtualizacaoUsuarioDTO;
import br.edu.multivix.pei.tolyid.domain.usuario.dto.DadosCadastroUsuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Usuario", description = "Envolve todas as operações com usuários. Exige autenticação por JWT.")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping(path = "/cadastrar")
    @Transactional
    @Operation(summary = "Cadastra Usuario", description = "Cadastra um usuario no banco de dados.")
    public ResponseEntity cadastraUsuario(@RequestBody @Valid DadosCadastroUsuarioDTO dados, UriComponentsBuilder uriComponentsBuilder){
        var dadosListagemUsuarioDTO = usuarioService.cadastraUsuario(dados);
        var uri = uriComponentsBuilder.path("/usuarios/listar/{id}").buildAndExpand(dadosListagemUsuarioDTO.id()).toUri();
        return ResponseEntity.created(uri).body(dadosListagemUsuarioDTO);
    }

    @GetMapping(path = "/listar/{idUsuario}")
    @Operation(summary = "Lista Usuário por Id", description = "Exibe um usuário por id.")
    public ResponseEntity listaUsuarioPorId(@PathVariable Long idUsuario){
        var dadosListagemUsuarioDTO = usuarioService.listaUsuarioPorId(idUsuario);
        return ResponseEntity.ok(dadosListagemUsuarioDTO);
    }

    @PatchMapping(path = "/atualizar/{idUsuario}")
    @Transactional
    @Operation(summary = "Atualiza Usuário", description = "Atualiza os campos de um usuário. Permite que apenas os campos necessários sejam atualizados, basta informar apenas o necessário.")
    public ResponseEntity atualizaUsuarioPorId (@PathVariable Long idUsuario, @RequestBody @Valid DadosAtualizacaoUsuarioDTO dados){
        var dadosListagemUsuarioDTO = usuarioService.atualizaUsuarioPorId(idUsuario, dados);
        return ResponseEntity.ok(dadosListagemUsuarioDTO);
    }
}
