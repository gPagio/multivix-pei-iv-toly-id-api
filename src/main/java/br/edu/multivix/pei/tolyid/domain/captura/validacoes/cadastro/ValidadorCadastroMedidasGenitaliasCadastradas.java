package br.edu.multivix.pei.tolyid.domain.captura.validacoes.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.multivix.pei.tolyid.domain.TolyIdGenericException;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosCadastroCapturaDTO;
import br.edu.multivix.pei.tolyid.domain.tatu.TatuRepository;

@Component
public class ValidadorCadastroMedidasGenitaliasCadastradas implements ValidadorCadastroCaptura{

    @Autowired
    private TatuRepository tatuRepository;

    @Override
    public void validar(Long idTatu, DadosCadastroCapturaDTO dados) {

        var sexoTatu = tatuRepository.getReferenceById(idTatu).getSexo();

        if ("M".equals(sexoTatu.toString())){
            var comprimentoDoClitorisJson = dados.biometria().comprimentoDoClitoris();
            if (comprimentoDoClitorisJson != null) {
                throw new TolyIdGenericException("Este tatu é macho e não deve possuir comprimento do clitóris!");
            }
        }
        
        if ("F".equals(sexoTatu.toString())){
            var larguraBasePenisJson = dados.biometria().larguraBasePenis();
            var comprimentoDoPenisJson = dados.biometria().comprimentoDoPenis();
            if (larguraBasePenisJson != null || comprimentoDoPenisJson != null) {
                throw new TolyIdGenericException("Este tatu é fêmea e não deve possuir comprimento ou largura da base do pênis!");
            }
        }
    }
}
