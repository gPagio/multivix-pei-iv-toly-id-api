package br.edu.multivix.pei.tolyid.domain.amostra;

public record DadosListagemAmostraDTO(Long id,
                                    Boolean sangue,
                                    Boolean fezes,
                                    Boolean pelo,
                                    Boolean ectoparasitos,
                                    Boolean swab,
                                    Boolean local,
                                    String outros) {

    public DadosListagemAmostraDTO(Amostra amostra) {
        this(amostra.getId(),
             amostra.getSangue(),
             amostra.getFezes(),
             amostra.getPelo(),
             amostra.getEctoparasitos(),
             amostra.getSwab(),
             amostra.getLocal(),
             amostra.getOutros());
    } 
}
