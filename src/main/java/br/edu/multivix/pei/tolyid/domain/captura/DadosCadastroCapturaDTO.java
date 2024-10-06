package br.edu.multivix.pei.tolyid.domain.captura;

import br.edu.multivix.pei.tolyid.domain.amostra.DadosCadastroAmostraDTO;
import br.edu.multivix.pei.tolyid.domain.biometria.DadosCadastroBiometriaDTO;
import br.edu.multivix.pei.tolyid.domain.dadosgerais.DadosCadastroDadosGeraisDTO;
import br.edu.multivix.pei.tolyid.domain.fichaanestesica.DadosCadastroFichaAnestesicaDTO;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCapturaDTO(  @NotNull(message = "É obrigatório o preenchimento dos dados gerais para o cadastro de uma captura!")
                                        DadosCadastroDadosGeraisDTO dadosGerais,

                                        @NotNull(message = "É obrigatório o preenchimento da ficha anestésica para o adastro de uma captura!")
                                        DadosCadastroFichaAnestesicaDTO fichaAnestesica,

                                        @NotNull(message = "É obrigatório o preenchimento da biometria para o cadastro de uma captura!")
                                        DadosCadastroBiometriaDTO biometria,

                                        @NotNull(message = "É obrigatório o preenchimento da amostra para o cadastro de uma captura!")
                                        DadosCadastroAmostraDTO amostra) { }
