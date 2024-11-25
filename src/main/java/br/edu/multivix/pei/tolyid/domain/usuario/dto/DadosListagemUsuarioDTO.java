package br.edu.multivix.pei.tolyid.domain.usuario.dto;

import java.util.List;

import br.edu.multivix.pei.tolyid.domain.acesso.Authority;
import br.edu.multivix.pei.tolyid.domain.usuario.Usuario;

public record DadosListagemUsuarioDTO(Long id, String nome, String email, String telefone, Boolean ativo, List<Authority> authorities) {
    public DadosListagemUsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getAtivo(), usuario.getAuthorities()
                                                                                                                       .stream()
                                                                                                                       .map(simpleGrantedAuthority -> Authority.valueOf(simpleGrantedAuthority.getAuthority()))
                                                                                                                       .toList());
    }
}
