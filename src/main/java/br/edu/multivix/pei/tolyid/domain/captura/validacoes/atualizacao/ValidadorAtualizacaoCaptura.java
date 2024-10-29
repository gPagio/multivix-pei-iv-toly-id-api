package br.edu.multivix.pei.tolyid.domain.captura.validacoes.atualizacao;

import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosAtualizacaoCapturaDTO;

public interface ValidadorAtualizacaoCaptura {

    void validar (Long idCaptura, DadosAtualizacaoCapturaDTO dados);

}
