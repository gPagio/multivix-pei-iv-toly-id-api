package br.edu.multivix.pei.tolyid.domain.parametrofisiologico;

import br.edu.multivix.pei.tolyid.domain.fichaanestesica.FichaAnestesica;
import br.edu.multivix.pei.tolyid.domain.parametrofisiologico.dto.DadosCadastroParametroFisiologicoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Table(name = "parametros_fisiologicos")
@Entity(name = "ParametroFisiologico")
public class ParametroFisiologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double frequenciaCardiaca;
    private Double frequenciaRespiratoria;
    private Double oximetria;
    private Double temperatura;

    @ManyToOne
    @JoinColumn(name = "ficha_anestesica_id")
    private FichaAnestesica fichaAnestesica;

    public ParametroFisiologico(DadosCadastroParametroFisiologicoDTO parametroFisiologicoDTO) {
        this.frequenciaCardiaca = parametroFisiologicoDTO.frequenciaCardiaca();
        this.frequenciaRespiratoria = parametroFisiologicoDTO.frequenciaRespiratoria();
        this.oximetria = parametroFisiologicoDTO.oximetria();
        this.temperatura = parametroFisiologicoDTO.temperatura();
    }

    public void setFichaAnestesica(FichaAnestesica fichaAnestesica) {
        this.fichaAnestesica = fichaAnestesica;
    }
}