package br.edu.multivix.pei.tolyid.domain.captura.validacoes.cadastro;

import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosCadastroCapturaDTO;

public interface ValidadorCadastroCaptura {

    void validar(Long idTatu, DadosCadastroCapturaDTO dados);

}
