package br.edu.multivix.pei.tolyid.domain.fichaanestesica.dto;

import java.time.LocalTime;
import java.util.List;

import br.edu.multivix.pei.tolyid.domain.parametrofisiologico.dto.DadosCadastroParametroFisiologicoDTO;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFichaAnestesicaDTO(  @NotNull(message = "O tipo de anestésico ou dose deve ser informado para completar a ficha anestésica de uma captura!")
                                                String tipoAnestesicoOuDose,

                                                @NotNull(message = "A via de administração deve ser informada para completar a ficha anestésica de uma captura!")
                                                String viaDeAdministracao,

                                                @NotNull(message = "O tempo de aplicação deve ser informado para completar a ficha anestésica de uma captura!")
                                                LocalTime aplicacao,

                                                @NotNull(message = "O tempo de indução deve ser informado para completar a ficha anestésica de uma captura!")
                                                LocalTime inducao,

                                                @NotNull(message = "O tempo de retorno deve ser informado para completar a ficha anestésica de uma captura!")
                                                LocalTime retorno,

                                                @NotNull(message = "É necessário a inclusão de pelo menos um parâmetro fisiológico para completar a ficha anestésica de uma captura!")
                                                List<DadosCadastroParametroFisiologicoDTO> parametrosFisiologicos) { }
