package br.edu.multivix.pei.tolyid.domain.dadosgerais;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroDadosGeraisDTO(  @NotNull(message = "O local de captura deve ser informado para completar os dados gerais de uma captura!")
                                            String localDeCaptura,

                                            @NotNull(message = "A equipe responsável deve ser informada para completar os dados gerais de uma captura!")
                                            String equipeResponsavel,

                                            @NotNull(message = "A instituição deve ser informada para completar os dados gerais de uma captura!")
                                            String instituicao,

                                            @NotNull(message = "O peso do animal deve ser informado para completar os dados gerais de uma captura!")
                                            Double pesoDoTatu,

                                            @NotNull(message = "A data de captura deve ser informada para completar os dados gerais de uma captura!")
                                            LocalDateTime dataCaptura,

                                            @NotNull(message = "O contato do responsável deve ser informado para completar os dados gerais de uma captura!")
                                            String contatoDoResponsavel,

                                            String observacoes) { }
