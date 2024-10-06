package br.edu.multivix.pei.tolyid.domain.captura.dto;

import br.edu.multivix.pei.tolyid.domain.amostra.dto.DadosListagemAmostraDTO;
import br.edu.multivix.pei.tolyid.domain.biometria.dto.DadosListagemBiometriaDTO;
import br.edu.multivix.pei.tolyid.domain.captura.Captura;
import br.edu.multivix.pei.tolyid.domain.dadosgerais.dto.DadosListagemDadosGeraisDTO;
import br.edu.multivix.pei.tolyid.domain.fichaanestesica.dto.DadosListagemFichaAnestesicaDTO;
import br.edu.multivix.pei.tolyid.domain.tatu.dto.DadosListagemTatuDTO;
import br.edu.multivix.pei.tolyid.domain.usuario.dto.DadosListagemUsuarioDTO;

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
