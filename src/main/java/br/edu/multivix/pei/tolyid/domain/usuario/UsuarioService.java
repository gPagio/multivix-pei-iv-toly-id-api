package br.edu.multivix.pei.tolyid.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.multivix.pei.tolyid.domain.TolyIdGenericException;
import br.edu.multivix.pei.tolyid.domain.usuario.dto.DadosCadastroUsuarioDTO;
import br.edu.multivix.pei.tolyid.domain.usuario.dto.DadosListagemUsuarioDTO;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DadosListagemUsuarioDTO cadastraUsuario(DadosCadastroUsuarioDTO dados) {
        if (usuarioRepository.existsByEmail(dados.email().trim())) throw new TolyIdGenericException("Email indisponível.");

        Usuario usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        return new DadosListagemUsuarioDTO(usuario);
    }

}
