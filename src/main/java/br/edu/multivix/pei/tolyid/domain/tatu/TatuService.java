package br.edu.multivix.pei.tolyid.domain.tatu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.multivix.pei.tolyid.domain.TolyIdGenericException;
import br.edu.multivix.pei.tolyid.domain.tatu.dto.DadosCadastroTatuDTO;
import br.edu.multivix.pei.tolyid.domain.tatu.dto.DadosListagemTatuDTO;

@Service
public class TatuService {

    @Autowired
    private TatuRepository tatuRepository;

    public DadosListagemTatuDTO cadastraTatu (DadosCadastroTatuDTO dados){
        if(tatuRepository.existsByIdentificacaoAnimal(dados.identificacaoAnimal().trim())) throw new TolyIdGenericException("Já existe um animal cadastrado com o identificador informado!");

        if(!dados.numeroMicrochip().equals(null)){
            if (tatuRepository.existsByNumeroMicrochip(dados.numeroMicrochip())) throw new TolyIdGenericException("Já existe um animal cadastrado com o número de microchip informado!");
        }

        var tatu = new Tatu(dados);
        tatuRepository.save(tatu);
        return new DadosListagemTatuDTO(tatu);
    }

    public DadosListagemTatuDTO listaTatuPorIdentificacaoAnimal(String identificacaoAnimal) {
        Optional<Tatu> tatu = tatuRepository.findByIdentificacaoAnimal(identificacaoAnimal);
        if (tatu.isEmpty()) throw new TolyIdGenericException("Não existe nenhum tatu cadastrado com a identificação do animal informada!");

        return new DadosListagemTatuDTO(tatu.get());
    }

}
