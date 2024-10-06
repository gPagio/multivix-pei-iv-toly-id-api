package br.edu.multivix.pei.tolyid.domain.fichaanestesica;

import java.time.LocalTime;
import java.util.List;

import br.edu.multivix.pei.tolyid.domain.parametrofisiologico.DadosListagemParametroFisiologicoDTO;

public record DadosListagemFichaAnestesicaDTO(Long id,
                                            String tipoAnestesicoOuDose,
                                            String viaDeAdministracao,
                                            LocalTime aplicacao,
                                            LocalTime inducao,
                                            LocalTime retorno,
                                            List<DadosListagemParametroFisiologicoDTO> parametrosFisiologicos) { }
