package br.edu.multivix.pei.tolyid.domain.captura.dto;

import br.edu.multivix.pei.tolyid.domain.amostra.dto.DadosAtualizacaoAmostraDTO;
import br.edu.multivix.pei.tolyid.domain.biometria.dto.DadosAtualizacaoBiometriaDTO;
import br.edu.multivix.pei.tolyid.domain.dadosgerais.dto.DadosAtualizacaoDadosGeraisDTO;
import br.edu.multivix.pei.tolyid.domain.fichaanestesica.dto.DadosAtualizacaoFichaAnestesicaDTO;

public record DadosAtualizacaoCapturaDTO(DadosAtualizacaoDadosGeraisDTO dadosGerais,
                                        DadosAtualizacaoFichaAnestesicaDTO fichaAnestesica,
                                        DadosAtualizacaoBiometriaDTO biometria,
                                        DadosAtualizacaoAmostraDTO amostra) { }