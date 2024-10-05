package br.edu.multivix.pei.tolyid.domain.tatu;

import java.util.List;

import br.edu.multivix.pei.tolyid.domain.captura.Captura;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Table(name = "tatus")
@Entity(name = "Tatu")
public class Tatu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificacaoAnimal;
    private Integer numeroMicrochip;

    @OneToMany(mappedBy = "tatu", fetch = FetchType.LAZY)
    private List<Captura> capturas;

    public Tatu (DadosCadastroTatuDTO dados){
        this.identificacaoAnimal = dados.identificacaoAnimal().trim();
        this.numeroMicrochip = dados.numeroMicrochip();
    }
}
