package br.edu.multivix.pei.tolyid.domain.amostra.dto;

public record DadosAtualizacaoAmostraDTO(Boolean sangue,
                                        Boolean fezes,
                                        Boolean pelo,
                                        Boolean ectoparasitos,
                                        Boolean swab,
                                        Boolean local,
                                        String outros) {}