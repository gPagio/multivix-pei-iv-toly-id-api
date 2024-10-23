package br.edu.multivix.pei.tolyid.domain.dadosgerais.dto;

import java.time.LocalDateTime;

public record DadosAtualizacaoDadosGeraisDTO(String localDeCaptura,
                                            String equipeResponsavel,
                                            String instituicao,
                                            Double pesoDoTatu,
                                            LocalDateTime dataCaptura,
                                            String contatoDoResponsavel,
                                            String observacoes) { }