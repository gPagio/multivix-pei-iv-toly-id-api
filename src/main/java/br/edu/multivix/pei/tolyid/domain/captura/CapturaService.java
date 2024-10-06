package br.edu.multivix.pei.tolyid.domain.captura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.multivix.pei.tolyid.domain.TolyIdGenericException;
import br.edu.multivix.pei.tolyid.domain.tatu.TatuRepository;
import br.edu.multivix.pei.tolyid.domain.usuario.AutenticacaoService;

@Service
public class CapturaService {

    @Autowired
    private TatuRepository tatuRepository;

    @Autowired
    private CapturaRepository capturaRepository;

    public DadosListagemCapturaDTO cadastraCaptura(Long idTatu, DadosCadastroCapturaDTO dados) {
        if (!tatuRepository.existsById(idTatu)) throw new TolyIdGenericException("Nenhum tatu encontrado com o id informado!");

        var usuario = AutenticacaoService.getUsuarioLogado();
        var tatu = tatuRepository.findById(idTatu).get();
        var captura = new Captura(usuario, tatu, dados);
        capturaRepository.save(captura);
        return new DadosListagemCapturaDTO(captura);
    }

}
