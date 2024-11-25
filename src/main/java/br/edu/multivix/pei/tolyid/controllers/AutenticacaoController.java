package br.edu.multivix.pei.tolyid.controllers;

import br.edu.multivix.pei.tolyid.domain.usuario.Usuario;
import br.edu.multivix.pei.tolyid.infra.security.autenticacao.dto.DadosAutenticacaoDTO;
import br.edu.multivix.pei.tolyid.infra.security.jwt.TokenService;
import br.edu.multivix.pei.tolyid.infra.security.jwt.dto.DadosTokenJWT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Autenticação", description = "Controlador usado para gerar o token de autenticação. Não exige autenticação.")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @SuppressWarnings("rawtypes")
    @PostMapping(path = "/token")
    @Transactional
    @Operation(summary = "Gera Token JWT", description = "Gera um Token JWT com email e senha informados.")
    public ResponseEntity geraTokenJWT(@RequestBody @Valid DadosAutenticacaoDTO dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.geraTokenJWT((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}