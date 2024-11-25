package br.edu.multivix.pei.tolyid.domain.usuario.dto;

import java.util.List;

import br.edu.multivix.pei.tolyid.domain.acesso.Authority;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuarioDTO(
    @NotNull(message = "Nome do usuário é obrigatório.")
    String nome,
    
    @NotNull(message = "Email é obrigatório.")
    @Email(message = "Email deve seguir o formato email@email.com")
    String email,
    
    @NotNull(message = "Senha é obrigatória.")
    String senha,
    
    String telefone,
    
    List<Authority> authorities) {

}
