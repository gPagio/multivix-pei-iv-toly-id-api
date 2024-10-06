package br.edu.multivix.pei.tolyid.controllers;

import br.edu.multivix.pei.tolyid.domain.usuario.Usuario;
import br.edu.multivix.pei.tolyid.domain.usuario.autenticacao.dto.DadosAutenticacaoDTO;
import br.edu.multivix.pei.tolyid.infra.security.DadosTokenJWT;
import br.edu.multivix.pei.tolyid.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @SuppressWarnings("rawtypes")
    @PostMapping(path = "/token")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}