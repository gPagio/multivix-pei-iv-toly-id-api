package br.edu.multivix.pei.tolyid.domain.parametrofisiologico;

public record DadosListagemParametroFisiologicoDTO(Long id,
                                                Double frequenciaCardiaca,
                                                Double frequenciaRespiratoria,
                                                Double oximetria,
                                                Double temperatura) { }
