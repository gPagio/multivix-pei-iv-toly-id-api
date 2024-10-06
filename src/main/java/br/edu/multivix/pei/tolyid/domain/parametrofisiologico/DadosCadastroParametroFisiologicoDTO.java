package br.edu.multivix.pei.tolyid.domain.parametrofisiologico;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroParametroFisiologicoDTO( @NotNull(message = "A frequência cardíaca deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                                    Double frequenciaCardiaca,

                                                    @NotNull(message = "A frequência respiratória deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                                    Double frequenciaRespiratoria,

                                                    @NotNull(message = "A oxímetria deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                                    Double oximetria,

                                                    @NotNull(message = "A temperatura deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                                    Double temperatura) { }
