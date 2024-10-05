package br.edu.multivix.pei.tolyid.domain.tatu;

public record DadosListagemTatuDTO (Long id, String identificacaoAnimal, Integer numeroMicrochip) {

    public DadosListagemTatuDTO(Tatu tatu){
        this(tatu.getId(), tatu.getIdentificacaoAnimal(), tatu.getNumeroMicrochip());
    }
}
