package br.edu.multivix.pei.tolyid.domain.biometria.dto;

public record DadosAtualizacaoBiometriaDTO(Double comprimentoTotal,
                                            Double comprimentoDaCabeca,
                                            Double larguraDaCabeca,
                                            String padraoEscudoCefalico,
                                            Double comprimentoEscudoCefalico,
                                            Double larguraEscudoCefalico,
                                            Double larguraInterOrbital,
                                            Double larguraInterLacrimal,
                                            Double comprimentoDaOrelha,
                                            Double comprimentoDaCauda,
                                            Double larguraDaCauda,
                                            Double comprimentoEscudoEscapular,
                                            Double semicircunferenciaEscudoEscapular,
                                            Double comprimentoEscudoPelvico,
                                            Double semicircunferenciaEscudoPelvico,
                                            Double larguraNaSegundaCinta,
                                            Integer numeroDeCintas,
                                            Double comprimentoMaoSemUnha,
                                            Double comprimentoUnhaDaMao,
                                            Double comprimentoPeSemUnha,
                                            Double comprimentoUnhaDoPe,
                                            Double comprimentoDoPenis,
                                            Double larguraBasePenis,
                                            Double comprimentoDoClitoris) { }