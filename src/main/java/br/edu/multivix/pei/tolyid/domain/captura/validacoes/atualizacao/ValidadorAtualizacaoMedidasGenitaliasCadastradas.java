package br.edu.multivix.pei.tolyid.domain.captura.validacoes.atualizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.multivix.pei.tolyid.domain.TolyIdGenericException;
import br.edu.multivix.pei.tolyid.domain.captura.CapturaRepository;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosAtualizacaoCapturaDTO;

@Component
public class ValidadorAtualizacaoMedidasGenitaliasCadastradas implements ValidadorAtualizacaoCaptura{

    @Autowired
    private CapturaRepository capturaRepository;

    @Override
    public void validar(Long idCaptura, DadosAtualizacaoCapturaDTO dados) {
        var listaTodasCapturas = capturaRepository.getReferenceById(idCaptura).getTatu().getCapturas();

        if (listaTodasCapturas.size() > 0) {
            var larguraBasePenisCadastrada = listaTodasCapturas.get(0).getBiometria().getLarguraBasePenis();
            var comprimentoDoPenisCadastrado = listaTodasCapturas.get(0).getBiometria().getComprimentoDoPenis();

            if (dados.biometria() != null){
                if (((larguraBasePenisCadastrada != null) || (comprimentoDoPenisCadastrado != null)) && dados.biometria().comprimentoDoClitoris() != null){
                    throw new TolyIdGenericException("Este tatu é macho e não deve possuir comprimento do clitóris!");
                }
                
                var comprimentoDoClitorisCadastrado = listaTodasCapturas.get(0).getBiometria().getComprimentoDoClitoris();
                if (((dados.biometria().larguraBasePenis() != null) || (dados.biometria().comprimentoDoPenis() != null)) && comprimentoDoClitorisCadastrado != null){
                    throw new TolyIdGenericException("Este tatu é fêmea e não deve possuir comprimento ou largura da base do pênis!");
                }
            }
        }
    }

}
