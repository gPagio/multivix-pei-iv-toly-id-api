package br.edu.multivix.pei.tolyid.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.multivix.pei.tolyid.domain.TolyIdGenericException;
import br.edu.multivix.pei.tolyid.domain.acesso.AcessoRepository;
import br.edu.multivix.pei.tolyid.domain.usuario.dto.DadosAtualizacaoUsuarioDTO;
import br.edu.multivix.pei.tolyid.domain.usuario.dto.DadosCadastroUsuarioDTO;
import br.edu.multivix.pei.tolyid.domain.usuario.dto.DadosListagemUsuarioDTO;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AcessoRepository acessoRepository;

    public DadosListagemUsuarioDTO cadastraUsuario(DadosCadastroUsuarioDTO dados) {
        if (usuarioRepository.existsByEmail(dados.email().trim())) throw new TolyIdGenericException("Email já cadastrado.");

        Usuario usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        return new DadosListagemUsuarioDTO(usuario);
    }

    public DadosListagemUsuarioDTO listaUsuarioPorId(Long idUsuario) {
        if (!usuarioRepository.existsById(idUsuario)) throw new EntityNotFoundException();
        var usuario = usuarioRepository.getReferenceById(idUsuario);

        return new DadosListagemUsuarioDTO(usuario);
    }

    public DadosListagemUsuarioDTO atualizaUsuarioPorId(Long idUsuario, DadosAtualizacaoUsuarioDTO dados) {
        if (!usuarioRepository.existsById(idUsuario)) throw new EntityNotFoundException();

        var usuario = usuarioRepository.getReferenceById(idUsuario);
        acessoRepository.deleteByUsuarioId(usuario.getId());
        usuario.atualizaInformacoes(dados);
        
        usuarioRepository.save(usuario);
        return new DadosListagemUsuarioDTO(usuario);
    }
}
