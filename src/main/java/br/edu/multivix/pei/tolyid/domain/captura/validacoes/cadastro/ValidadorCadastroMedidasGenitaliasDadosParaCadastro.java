package br.edu.multivix.pei.tolyid.domain.captura.validacoes.cadastro;

import org.springframework.stereotype.Component;

import br.edu.multivix.pei.tolyid.domain.TolyIdGenericException;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosCadastroCapturaDTO;

@Component
public class ValidadorCadastroMedidasGenitaliasDadosParaCadastro implements ValidadorCadastroCaptura{

    @Override
    public void validar(Long idTatu, DadosCadastroCapturaDTO dados) {
        if ((dados.biometria().larguraBasePenis() != null || dados.biometria().comprimentoDoPenis() != null) && dados.biometria().comprimentoDoClitoris() != null) {
            throw new TolyIdGenericException("Um tatu não pode ter medidas de genitálias de sexos diferentes ao mesmo tempo!");
        }

        if (dados.biometria().larguraBasePenis() == null && dados.biometria().comprimentoDoPenis() == null && dados.biometria().comprimentoDoClitoris() == null) {
            throw new TolyIdGenericException("Um tatu não pode ficar sem as medidas de sua genitália!");
        }

        if ((dados.biometria().larguraBasePenis() == null || dados.biometria().comprimentoDoPenis() != null) && dados.biometria().comprimentoDoClitoris() == null) {
            throw new TolyIdGenericException("Um tatu macho não pode ter a medida da largura da base do pênis vazia!");
        }

        if ((dados.biometria().larguraBasePenis() != null || dados.biometria().comprimentoDoPenis() == null) && dados.biometria().comprimentoDoClitoris() == null) {
            throw new TolyIdGenericException("Um tatu macho não pode ter a medida do comprimento do pênis vazia!");
        }
    }

}
