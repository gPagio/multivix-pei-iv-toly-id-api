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
        var listaTodasCapturas = tatuRepository.getReferenceById(idTatu).getCapturas();

        if (listaTodasCapturas.size() > 0) {
            var larguraBasePenisCadastrada = listaTodasCapturas.get(0).getBiometria().getLarguraBasePenis();
            var comprimentoDoPenisCadastrado = listaTodasCapturas.get(0).getBiometria().getComprimentoDoPenis();
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
