package br.edu.multivix.pei.tolyid.domain.parametrofisiologico;

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
