package br.edu.multivix.pei.tolyid.domain.tatu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.multivix.pei.tolyid.domain.TolyIdGenericException;

@Service
public class TatuService {

    @Autowired
    private TatuRepository tatuRepository;

    public DadosListagemTatuDTO cadastrarTatu (DadosCadastroTatuDTO dados){
        if(tatuRepository.existsByIdentificacaoAnimal(dados.identificacaoAnimal().trim())) throw new TolyIdGenericException("Já existe um animal cadastrado com o identificador informado!");

        if(!dados.numeroMicrochip().equals(null)){
            if (tatuRepository.existsByNumeroMicrochip(dados.numeroMicrochip())) throw new TolyIdGenericException("Já existe um animal cadastrado com o número de microchip informado!");
        }

        var tatu = new Tatu(dados);
        tatuRepository.save(tatu);
        return new DadosListagemTatuDTO(tatu);
    }

}