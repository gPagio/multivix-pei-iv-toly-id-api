package br.edu.multivix.pei.tolyid.domain.fichaanestesica.dto;

import java.time.LocalTime;
import java.util.List;

import br.edu.multivix.pei.tolyid.domain.parametrofisiologico.dto.DadosAtualizacaoParametroFisiologicoDTO;
import jakarta.validation.Valid;

public record DadosAtualizacaoFichaAnestesicaDTO(String tipoAnestesicoOuDose,
                                                String viaDeAdministracao,
                                                LocalTime aplicacao,
                                                LocalTime inducao,
                                                LocalTime retorno,

                                                @Valid
                                                List<DadosAtualizacaoParametroFisiologicoDTO> parametrosFisiologicos) { }