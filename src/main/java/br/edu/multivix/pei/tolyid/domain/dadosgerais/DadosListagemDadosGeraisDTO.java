package br.edu.multivix.pei.tolyid.domain.dadosgerais;

import java.time.LocalDateTime;

public record DadosListagemDadosGeraisDTO(Long id,
                                        String localDeCaptura,
                                        String equipeResponsavel,
                                        String instituicao,
                                        Double pesoDoTatu,
                                        LocalDateTime dataCaptura,
                                        String contatoDoResponsavel,
                                        String observacoes) { }
