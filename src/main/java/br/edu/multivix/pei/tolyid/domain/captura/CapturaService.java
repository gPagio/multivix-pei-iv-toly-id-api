package br.edu.multivix.pei.tolyid.domain.captura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.multivix.pei.tolyid.domain.TolyIdGenericException;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosAtualizacaoCapturaDTO;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosCadastroCapturaDTO;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosListagemCapturaDTO;
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

    public DadosListagemCapturaDTO cadastraCaptura(Long idTatu, DadosCadastroCapturaDTO dados) {
        if (!tatuRepository.existsById(idTatu)) throw new TolyIdGenericException("Nenhum tatu encontrado com o id informado!");

        var usuarioLogado = AutenticacaoService.getUsuarioLogado();
        var usuario = usuarioRepository.findById(usuarioLogado.getId()).get();
        var tatu = tatuRepository.findById(idTatu).get();
        var captura = new Captura(usuario, tatu, dados);
        capturaRepository.save(captura);
        return new DadosListagemCapturaDTO(captura);
    }

    public DadosListagemCapturaDTO listaCapturaPorId(Long id) {
        if (!capturaRepository.existsById(id)) throw new TolyIdGenericException("Não existe nenhuma captura com o id informado!");
        var captura = capturaRepository.findById(id).get();
        return new DadosListagemCapturaDTO(captura);
    }

    public void deletaCapturaPorId(Long id) {
        if (!capturaRepository.existsById(id)) throw new TolyIdGenericException("Não existe nenhuma captura com o id informado!");
        capturaRepository.deleteById(id);
    }

    public DadosListagemCapturaDTO atualizaCapturaPorId(Long id, DadosAtualizacaoCapturaDTO dados) {
        if (!capturaRepository.existsById(id)) throw new TolyIdGenericException("Não existe nenhuma captura com o id informado!");

        var captura = capturaRepository.getReferenceById(id);
        captura.atualizaInformacoes(dados);

        return new DadosListagemCapturaDTO(captura);
    }
}