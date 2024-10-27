package br.edu.multivix.pei.tolyid.domain.parametrofisiologico.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoParametroFisiologicoDTO(@NotNull(message = "O id do parâmetro fisiológico é obrigatório para a atualização dos mesmos!")
                                                      Long id,
                                                      Double frequenciaCardiaca,
                                                      Double frequenciaRespiratoria,
                                                      Double oximetria,
                                                      Double temperatura) { }
