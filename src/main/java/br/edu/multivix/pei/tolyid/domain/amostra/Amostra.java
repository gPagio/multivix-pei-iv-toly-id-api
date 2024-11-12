package br.edu.multivix.pei.tolyid.domain.amostra;

import br.edu.multivix.pei.tolyid.domain.amostra.dto.DadosAtualizacaoAmostraDTO;
import br.edu.multivix.pei.tolyid.domain.amostra.dto.DadosCadastroAmostraDTO;
import br.edu.multivix.pei.tolyid.domain.captura.Captura;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Table(name = "amostras")
@Entity(name = "Amostra")
public class Amostra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean sangue;
    private Boolean fezes;
    private Boolean pelo;
    private Boolean ectoparasitos;
    private Boolean swab;
    private Boolean local;
    private String outros;

    @OneToOne(mappedBy = "amostra")
    private Captura captura;

    public Amostra(DadosCadastroAmostraDTO amostraDTO) {
        this.sangue = amostraDTO.sangue();
        this.fezes = amostraDTO.fezes();
        this.pelo = amostraDTO.pelo();
        this.ectoparasitos = amostraDTO.ectoparasitos();
        this.swab = amostraDTO.swab();
        this.local = amostraDTO.local();
        if (amostraDTO.outros() != null) this.outros = amostraDTO.outros().trim();
    }

    public void atualizaInformacoes(DadosAtualizacaoAmostraDTO amostraDTO) {
        if (amostraDTO.sangue() != null) this.sangue = amostraDTO.sangue();
        if (amostraDTO.fezes() != null) this.fezes = amostraDTO.fezes();
        if (amostraDTO.pelo() != null) this.pelo = amostraDTO.pelo();
        if (amostraDTO.ectoparasitos() != null) this.ectoparasitos = amostraDTO.ectoparasitos();
        if (amostraDTO.swab() != null) this.swab = amostraDTO.swab();
        if (amostraDTO.local() != null) this.local = amostraDTO.local();
        if (amostraDTO.outros() != null) this.outros = amostraDTO.outros().trim();
    }
}
