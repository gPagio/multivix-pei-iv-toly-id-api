package br.edu.multivix.pei.tolyid.domain.captura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.multivix.pei.tolyid.domain.TolyIdGenericException;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosAtualizacaoCapturaDTO;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosCadastroCapturaDTO;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosListagemCapturaDTO;
import br.edu.multivix.pei.tolyid.domain.captura.validacoes.atualizacao.ValidadorAtualizacaoCaptura;
import br.edu.multivix.pei.tolyid.domain.captura.validacoes.cadastro.ValidadorCadastroCaptura;
import br.edu.multivix.pei.tolyid.domain.tatu.TatuRepository;
import br.edu.multivix.pei.tolyid.domain.usuario.UsuarioRepository;
import br.edu.multivix.pei.tolyid.domain.usuario.autenticacao.AutenticacaoService;

@Service
public class CapturaService {

    @Autowired
    private TatuRepository tatuRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CapturaRepository capturaRepository;

    @Autowired
    private List<ValidadorCadastroCaptura> validadoresCadastro;

    @Autowired
    private List<ValidadorAtualizacaoCaptura> validadoresAtualizacao;

    public DadosListagemCapturaDTO cadastraCaptura(Long idTatu, DadosCadastroCapturaDTO dados) {
        if (!tatuRepository.existsById(idTatu)) throw new TolyIdGenericException("Nenhum tatu encontrado com o id informado!");

        validadoresCadastro.forEach(validacao -> validacao.validar(idTatu, dados));

        var usuarioLogado = AutenticacaoService.getUsuarioLogado();
        var usuario = usuarioRepository.getReferenceById(usuarioLogado.getId());
        var tatu = tatuRepository.getReferenceById(idTatu);
        var captura = new Captura(usuario, tatu, dados);
        capturaRepository.save(captura);
        return new DadosListagemCapturaDTO(captura);
    }

    public DadosListagemCapturaDTO listaCapturaPorId(Long idCaptura) {
        if (!capturaRepository.existsById(idCaptura)) throw new TolyIdGenericException("Não existe nenhuma captura com o id informado!");
        var captura = capturaRepository.getReferenceById(idCaptura);
        return new DadosListagemCapturaDTO(captura);
    }

    public void deletaCapturaPorId(Long idCaptura) {
        if (!capturaRepository.existsById(idCaptura)) throw new TolyIdGenericException("Não existe nenhuma captura com o id informado!");
        capturaRepository.deleteById(idCaptura);
    }

    public DadosListagemCapturaDTO atualizaCapturaPorId(Long idCaptura, DadosAtualizacaoCapturaDTO dados) {
        if (!capturaRepository.existsById(idCaptura)) throw new TolyIdGenericException("Não existe nenhuma captura com o id informado!");

        validadoresAtualizacao.forEach(validacao -> validacao.validar(idCaptura, dados));

        var captura = capturaRepository.getReferenceById(idCaptura);
        captura.atualizaInformacoes(dados);

        return new DadosListagemCapturaDTO(captura);
    }
}