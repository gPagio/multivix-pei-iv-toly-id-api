package br.edu.multivix.pei.tolyid.domain.captura;

import br.edu.multivix.pei.tolyid.domain.amostra.DadosListagemAmostraDTO;
import br.edu.multivix.pei.tolyid.domain.biometria.DadosListagemBiometriaDTO;
import br.edu.multivix.pei.tolyid.domain.dadosgerais.DadosListagemDadosGeraisDTO;
import br.edu.multivix.pei.tolyid.domain.fichaanestesica.DadosListagemFichaAnestesicaDTO;
import br.edu.multivix.pei.tolyid.domain.tatu.DadosListagemTatuDTO;

public record DadosListagemCapturaDTO(DadosListagemTatuDTO dadosListagemTatuDTO,
                                    DadosListagemDadosGeraisDTO dadosGerais,
                                    DadosListagemFichaAnestesicaDTO fichaAnestesica,
                                    DadosListagemBiometriaDTO biometria,
                                    DadosListagemAmostraDTO amostra) { }
