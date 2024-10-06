package br.edu.multivix.pei.tolyid.domain.amostra;

public record DadosListagemAmostraDTO(Long id,
                                    Boolean sangue,
                                    Boolean fezes,
                                    Boolean pelo,
                                    Boolean ectoparasitos,
                                    Boolean swab,
                                    Boolean local,
                                    String outros) { }
