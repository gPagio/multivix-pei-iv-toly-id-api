package br.edu.multivix.pei.tolyid.domain.parametrofisiologico.dto;

import br.edu.multivix.pei.tolyid.domain.parametrofisiologico.ParametroFisiologico;

public record DadosListagemParametroFisiologicoDTO(Long id,
                                                Double frequenciaCardiaca,
                                                Double frequenciaRespiratoria,
                                                Double oximetria,
                                                Double temperatura) {

    public DadosListagemParametroFisiologicoDTO(ParametroFisiologico parametroFisiologico) {
        this(parametroFisiologico.getId(),
             parametroFisiologico.getFrequenciaCardiaca(),
             parametroFisiologico.getFrequenciaRespiratoria(),
             parametroFisiologico.getOximetria(),
             parametroFisiologico.getTemperatura());
    } 
}
