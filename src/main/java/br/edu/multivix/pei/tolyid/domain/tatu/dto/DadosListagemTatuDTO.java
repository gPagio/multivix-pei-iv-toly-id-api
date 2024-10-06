package br.edu.multivix.pei.tolyid.domain.tatu.dto;

import br.edu.multivix.pei.tolyid.domain.tatu.Tatu;

public record DadosListagemTatuDTO (Long id, String identificacaoAnimal, Integer numeroMicrochip) {

    public DadosListagemTatuDTO(Tatu tatu){
        this(tatu.getId(), tatu.getIdentificacaoAnimal(), tatu.getNumeroMicrochip());
    }
}
