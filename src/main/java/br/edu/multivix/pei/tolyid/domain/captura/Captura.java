package br.edu.multivix.pei.tolyid.domain.captura;

import br.edu.multivix.pei.tolyid.domain.amostra.Amostra;
import br.edu.multivix.pei.tolyid.domain.biometria.Biometria;
import br.edu.multivix.pei.tolyid.domain.captura.dto.DadosCadastroCapturaDTO;
import br.edu.multivix.pei.tolyid.domain.dadosgerais.DadosGerais;
import br.edu.multivix.pei.tolyid.domain.fichaanestesica.FichaAnestesica;
import br.edu.multivix.pei.tolyid.domain.tatu.Tatu;
import br.edu.multivix.pei.tolyid.domain.usuario.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "capturas")
@Entity(name = "Captura")
public class Captura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinColumn(name = "tatu_id")
    private Tatu tatu;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_gerais_id", referencedColumnName = "id")
    private DadosGerais dadosGerais;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ficha_anestesica_id", referencedColumnName = "id")
    private FichaAnestesica fichaAnestesica;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "biometria_id", referencedColumnName = "id")
    private Biometria biometria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amostra_id", referencedColumnName = "id")
    private Amostra amostra;

    public Captura (Usuario usuario,
                    Tatu tatu,
                    DadosCadastroCapturaDTO dados){
        this.usuario = usuario;
        this.tatu = tatu;
        this.dadosGerais = new DadosGerais(dados.dadosGerais());
        this.fichaAnestesica = new FichaAnestesica(dados.fichaAnestesica());
        this.biometria = new Biometria(dados.biometria());
        this.amostra = new Amostra(dados.amostra());
    }
}
