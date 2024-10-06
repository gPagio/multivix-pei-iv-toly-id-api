package br.edu.multivix.pei.tolyid.domain.dadosgerais.dto;

import java.time.LocalDateTime;

import br.edu.multivix.pei.tolyid.domain.dadosgerais.DadosGerais;

public record DadosListagemDadosGeraisDTO(Long id,
                                        String localDeCaptura,
                                        String equipeResponsavel,
                                        String instituicao,
                                        Double pesoDoTatu,
                                        LocalDateTime dataCaptura,
                                        String contatoDoResponsavel,
                                        String observacoes) {
    public DadosListagemDadosGeraisDTO(DadosGerais dadosGerais){
        this(dadosGerais.getId(),
             dadosGerais.getLocalDeCaptura(),
             dadosGerais.getEquipeResponsavel(),
             dadosGerais.getInstituicao(),
             dadosGerais.getPesoDoTatu(),
             dadosGerais.getDataCaptura(),
             dadosGerais.getContatoDoResponsavel(),
             dadosGerais.getObservacoes());
    }
}
