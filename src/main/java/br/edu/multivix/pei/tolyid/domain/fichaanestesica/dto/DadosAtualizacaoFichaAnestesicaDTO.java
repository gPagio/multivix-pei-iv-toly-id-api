package br.edu.multivix.pei.tolyid.domain.fichaanestesica.dto;

import java.time.LocalTime;
import java.util.List;

import br.edu.multivix.pei.tolyid.domain.parametrofisiologico.dto.DadosAtualizacaoParametroFisiologicoDTO;

public record DadosAtualizacaoFichaAnestesicaDTO(String tipoAnestesicoOuDose,
                                                String viaDeAdministracao,
                                                LocalTime aplicacao,
                                                LocalTime inducao,
                                                LocalTime retorno,
                                                List<DadosAtualizacaoParametroFisiologicoDTO> parametrosFisiologicos) { }