package br.edu.multivix.pei.tolyid.domain.usuario.dto;

import java.util.List;

import br.edu.multivix.pei.tolyid.domain.acesso.Authority;

public record DadosAtualizacaoUsuarioDTO(String senha,
                                        String telefone,
                                        Boolean ativo,
                                        List<Authority> authorities) {

}
