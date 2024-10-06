package br.edu.multivix.pei.tolyid.domain.usuario.dto;

import br.edu.multivix.pei.tolyid.domain.usuario.Usuario;

public record DadosListagemUsuarioDTO(Long id, String nome, String email, String telefone) {
    public DadosListagemUsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }
}
