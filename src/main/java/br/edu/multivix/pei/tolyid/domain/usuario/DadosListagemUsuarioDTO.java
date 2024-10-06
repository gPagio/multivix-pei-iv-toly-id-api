package br.edu.multivix.pei.tolyid.domain.usuario;

public record DadosListagemUsuarioDTO(Long id, String nome, String email, String telefone) {
    public DadosListagemUsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }
}
