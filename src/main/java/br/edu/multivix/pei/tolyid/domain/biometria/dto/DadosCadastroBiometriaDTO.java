package br.edu.multivix.pei.tolyid.domain.biometria.dto;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroBiometriaDTO(@NotNull(message = "O comprimento total deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoTotal,

                                        @NotNull(message = "O comprimento da cabeça deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoDaCabeca,

                                        @NotNull(message = "A largura da cabeça deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double larguraDaCabeca,
                                        
                                        @NotNull(message = "O padrão do escudo cefálico deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        String padraoEscudoCefalico,
                                        
                                        @NotNull(message = "O comprimento do escudo cefálico deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoEscudoCefalico,
                                        
                                        @NotNull(message = "A largura do escudo cefálico deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double larguraEscudoCefalico,
                                        
                                        @NotNull(message = "A largura inter-orbital deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double larguraInterOrbital,
                                        
                                        @NotNull(message = "A largura inter-lacrimal deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double larguraInterLacrimal,

                                        @NotNull(message = "O comprimento da orelha deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoDaOrelha,
                                        
                                        @NotNull(message = "O comprimento da cauda deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoDaCauda,
                                        
                                        @NotNull(message = "A largura da cauda deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double larguraDaCauda,
                                        
                                        @NotNull(message = "O comprimento do escudo escapular deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoEscudoEscapular,
                                        
                                        @NotNull(message = "A semicircunferencia do escudo escapular deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double semicircunferenciaEscudoEscapular,
                                        
                                        @NotNull(message = "O comprimento do escudo pélvico deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoEscudoPelvico,
                                        
                                        @NotNull(message = "A semicircunferencia do escudo pélvico deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double semicircunferenciaEscudoPelvico,
                                        
                                        @NotNull(message = "A largura na segunda cinta deve ser informada para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double larguraNaSegundaCinta,
                                        
                                        @NotNull(message = "O número de cintas deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Integer numeroDeCintas,
                                        
                                        @NotNull(message = "O comprimento da mão sem unha deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoMaoSemUnha,
                                        
                                        @NotNull(message = "O comprimento da unha da mão deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoUnhaDaMao,
                                        
                                        @NotNull(message = "O comprimento do pé sem unha deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoPeSemUnha,
                                        
                                        @NotNull(message = "O comprimento da unha do pé deve ser informado para completar os parâmetros fisiológicos de uma ficha anestésica!")
                                        Double comprimentoUnhaDoPe,
                                        
                                        Double comprimentoDoPenis,
                                        
                                        Double larguraBasePenis,
                                        
                                        Double comprimentoDoClitoris) { }
