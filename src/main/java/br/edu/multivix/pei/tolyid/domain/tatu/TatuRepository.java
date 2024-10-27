package br.edu.multivix.pei.tolyid.domain.tatu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TatuRepository extends JpaRepository<Tatu, Long>{
    Boolean existsByIdentificacaoAnimal(String identificacao);

    Boolean existsByNumeroMicrochip(Integer numeroMicrochip);

    Tatu getReferenceByIdentificacaoAnimal(String identificacaoAnimal);
}
