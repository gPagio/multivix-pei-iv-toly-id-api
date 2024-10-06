package br.edu.multivix.pei.tolyid.domain.captura;

import br.edu.multivix.pei.tolyid.domain.amostra.DadosListagemAmostraDTO;
import br.edu.multivix.pei.tolyid.domain.biometria.DadosListagemBiometriaDTO;
import br.edu.multivix.pei.tolyid.domain.dadosgerais.DadosListagemDadosGeraisDTO;
import br.edu.multivix.pei.tolyid.domain.fichaanestesica.DadosListagemFichaAnestesicaDTO;
import br.edu.multivix.pei.tolyid.domain.tatu.DadosListagemTatuDTO;
import br.edu.multivix.pei.tolyid.domain.usuario.DadosListagemUsuarioDTO;

public record DadosListagemCapturaDTO(Long id,
                                    DadosListagemUsuarioDTO usuario,
                                    DadosListagemTatuDTO tatu,
                                    DadosListagemDadosGeraisDTO dadosGerais,
                                    DadosListagemFichaAnestesicaDTO fichaAnestesica,
                                    DadosListagemBiometriaDTO biometria,
                                    DadosListagemAmostraDTO amostra) {
    public DadosListagemCapturaDTO(Captura captura){
        this(captura.getId(),
        new DadosListagemUsuarioDTO(captura.getUsuario()),
        new DadosListagemTatuDTO(captura.getTatu()),
        new DadosListagemDadosGeraisDTO(captura.getDadosGerais()),
        new DadosListagemFichaAnestesicaDTO(captura.getFichaAnestesica()),
        new DadosListagemBiometriaDTO(captura.getBiometria()),
        new DadosListagemAmostraDTO(captura.getAmostra()));
    }
}
