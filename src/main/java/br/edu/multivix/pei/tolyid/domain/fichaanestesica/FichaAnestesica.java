package br.edu.multivix.pei.tolyid.domain.fichaanestesica;

import java.time.LocalTime;
import java.util.List;

import br.edu.multivix.pei.tolyid.domain.captura.Captura;
import br.edu.multivix.pei.tolyid.domain.fichaanestesica.dto.DadosCadastroFichaAnestesicaDTO;
import br.edu.multivix.pei.tolyid.domain.parametrofisiologico.ParametroFisiologico;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "fichas_anestesicas")
@Entity(name = "FichaAnestesica")
public class FichaAnestesica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoAnestesicoOuDose;
    private String viaDeAdministracao;
    private LocalTime aplicacao;
    private LocalTime inducao;
    private LocalTime retorno;

    @OneToMany(mappedBy = "fichaAnestesica", fetch = FetchType.LAZY)
    private List<ParametroFisiologico> parametrosFisiologicos;

    @OneToOne(mappedBy = "fichaAnestesica")
    private Captura captura;

    public FichaAnestesica(DadosCadastroFichaAnestesicaDTO fichaAnestesicaDTO) {
        this.tipoAnestesicoOuDose = fichaAnestesicaDTO.tipoAnestesicoOuDose().trim();
        this.viaDeAdministracao = fichaAnestesicaDTO.viaDeAdministracao().trim();
        this.aplicacao = fichaAnestesicaDTO.aplicacao();
        this.inducao = fichaAnestesicaDTO.inducao();
        this.retorno = fichaAnestesicaDTO.retorno();
        this.parametrosFisiologicos = fichaAnestesicaDTO.parametrosFisiologicos().stream().map(p -> new ParametroFisiologico(p)).toList();
    }
}
