package br.edu.multivix.pei.tolyid.domain.amostra.dto;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroAmostraDTO(  @NotNull(message = "É obrigatório informar se foram coletadas amostras de sangue!")
                                        Boolean sangue,
    
                                        @NotNull(message = "É obrigatório informar se foram coletadas amostras de fezes!")
                                        Boolean fezes,
                                        
                                        @NotNull(message = "É obrigatório informar se foram coletadas amostras de pelo!")
                                        Boolean pelo,
                                        
                                        @NotNull(message = "É obrigatório informar se foram coletadas amostras de ectoparasitos!")
                                        Boolean ectoparasitos,
                                        
                                        @NotNull(message = "É obrigatório informar se foram coletadas amostras de swab!")
                                        Boolean swab,
                                        
                                        @NotNull(message = "É obrigatório informar se foram coletadas amostras de local!")
                                        Boolean local,
                                        
                                        String outros) { }
