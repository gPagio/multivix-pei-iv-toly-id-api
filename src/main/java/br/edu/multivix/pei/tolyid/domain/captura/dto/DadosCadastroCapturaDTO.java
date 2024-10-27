package br.edu.multivix.pei.tolyid.domain.captura.dto;

import br.edu.multivix.pei.tolyid.domain.amostra.dto.DadosCadastroAmostraDTO;
import br.edu.multivix.pei.tolyid.domain.biometria.dto.DadosCadastroBiometriaDTO;
import br.edu.multivix.pei.tolyid.domain.dadosgerais.dto.DadosCadastroDadosGeraisDTO;
import br.edu.multivix.pei.tolyid.domain.fichaanestesica.dto.DadosCadastroFichaAnestesicaDTO;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotNull;

@Hidden
public record DadosCadastroCapturaDTO(  @NotNull(message = "É obrigatório o preenchimento dos dados gerais para o cadastro de uma captura!")
                                        DadosCadastroDadosGeraisDTO dadosGerais,

                                        @NotNull(message = "É obrigatório o preenchimento da ficha anestésica para o adastro de uma captura!")
                                        DadosCadastroFichaAnestesicaDTO fichaAnestesica,

                                        @NotNull(message = "É obrigatório o preenchimento da biometria para o cadastro de uma captura!")
                                        DadosCadastroBiometriaDTO biometria,

                                        @NotNull(message = "É obrigatório o preenchimento da amostra para o cadastro de uma captura!")
                                        DadosCadastroAmostraDTO amostra) { }
