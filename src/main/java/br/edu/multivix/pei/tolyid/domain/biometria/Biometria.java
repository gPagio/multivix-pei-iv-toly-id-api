package br.edu.multivix.pei.tolyid.domain.biometria;

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
@Table(name = "biometria")
@Entity(name = "Biometria")
public class Biometria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double comprimentoTotal;
    private Double comprimentoDaCabeca;
    private Double larguraDaCabeca;
    private String padraoEscudoCefalico;
    private Double comprimentoEscudoCefalico;
    private Double larguraEscudoCefalico;
    private Double larguraInterOrbital;
    private Double comprimentoDaOrelha;
    private Double comprimentoDaCauda;
    private Double larguraDaCauda;
    private Double comprimentoEscudoEscapular;
    private Double semicircunferenciaEscudoEscapular;
    private Double comprimentoEscudoPelvico;
    private Double semicircunferenciaEscudoPelvico;
    private Double larguraNaSegundaCinta;
    private Integer numeroDeCintas;
    private Double comprimentoMaoSemUnha;
    private Double comprimentoUnhaDaMao;
    private Double comprimentoPeSemUnha;
    private Double comprimentoUnhaDoPe;
    private Double comprimentoDoPenis;
    private Double larguraBasePenis;
    private Double comprimentoDoClitoris;

    @OneToOne(mappedBy = "biometria")
    private Captura captura;
}
