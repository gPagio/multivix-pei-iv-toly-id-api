package br.edu.multivix.pei.tolyid.domain.biometria;

import br.edu.multivix.pei.tolyid.domain.biometria.dto.DadosAtualizacaoBiometriaDTO;
import br.edu.multivix.pei.tolyid.domain.biometria.dto.DadosCadastroBiometriaDTO;
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
@Table(name = "biometrias")
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
    private Double larguraInterLacrimal;
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

    public Biometria(DadosCadastroBiometriaDTO biometriaDTO) {
        this.comprimentoTotal = biometriaDTO.comprimentoTotal();
        this.comprimentoDaCabeca = biometriaDTO.comprimentoDaCabeca();
        this.larguraDaCabeca = biometriaDTO.larguraDaCabeca();
        this.padraoEscudoCefalico = biometriaDTO.padraoEscudoCefalico().trim();
        this.comprimentoEscudoCefalico = biometriaDTO.comprimentoEscudoCefalico();
        this.larguraEscudoCefalico = biometriaDTO.larguraEscudoCefalico();
        this.larguraInterOrbital = biometriaDTO.larguraInterOrbital();
        this.larguraInterLacrimal = biometriaDTO.larguraInterLacrimal();
        this.comprimentoDaOrelha = biometriaDTO.comprimentoDaOrelha();
        this.comprimentoDaCauda = biometriaDTO.comprimentoDaCauda();
        this.larguraDaCauda = biometriaDTO.larguraDaCauda();
        this.comprimentoEscudoEscapular = biometriaDTO.comprimentoEscudoEscapular();
        this.semicircunferenciaEscudoEscapular = biometriaDTO.semicircunferenciaEscudoEscapular();
        this.comprimentoEscudoPelvico = biometriaDTO.comprimentoEscudoPelvico();
        this.semicircunferenciaEscudoPelvico = biometriaDTO.semicircunferenciaEscudoPelvico();
        this.larguraNaSegundaCinta = biometriaDTO.larguraNaSegundaCinta();
        this.numeroDeCintas = biometriaDTO.numeroDeCintas();
        this.comprimentoMaoSemUnha = biometriaDTO.comprimentoMaoSemUnha();
        this.comprimentoUnhaDaMao = biometriaDTO.comprimentoUnhaDaMao();
        this.comprimentoPeSemUnha = biometriaDTO.comprimentoPeSemUnha();
        this.comprimentoUnhaDoPe = biometriaDTO.comprimentoUnhaDoPe();
        this.comprimentoDoPenis = biometriaDTO.comprimentoDoPenis();
        this.larguraBasePenis = biometriaDTO.larguraBasePenis();
        this.comprimentoDoClitoris = biometriaDTO.comprimentoDoClitoris();
    }

    public void atualizaInformacoes(DadosAtualizacaoBiometriaDTO biometriaDTO) {
        if (biometriaDTO.comprimentoTotal() != null) this.comprimentoTotal = biometriaDTO.comprimentoTotal();
        if (biometriaDTO.comprimentoDaCabeca() != null) this.comprimentoDaCabeca = biometriaDTO.comprimentoDaCabeca();
        if (biometriaDTO.larguraDaCabeca() != null) this.larguraDaCabeca = biometriaDTO.larguraDaCabeca();
        if (biometriaDTO.padraoEscudoCefalico() != null) this.padraoEscudoCefalico = biometriaDTO.padraoEscudoCefalico().trim();
        if (biometriaDTO.comprimentoEscudoCefalico() != null) this.comprimentoEscudoCefalico = biometriaDTO.comprimentoEscudoCefalico();
        if (biometriaDTO.larguraEscudoCefalico() != null) this.larguraEscudoCefalico = biometriaDTO.larguraEscudoCefalico();
        if (biometriaDTO.larguraInterOrbital() != null) this.larguraInterOrbital = biometriaDTO.larguraInterOrbital();
        if (biometriaDTO.larguraInterLacrimal() != null) this.larguraInterLacrimal = biometriaDTO.larguraInterLacrimal();
        if (biometriaDTO.comprimentoDaOrelha() != null) this.comprimentoDaOrelha = biometriaDTO.comprimentoDaOrelha();
        if (biometriaDTO.comprimentoDaCauda() != null) this.comprimentoDaCauda = biometriaDTO.comprimentoDaCauda();
        if (biometriaDTO.larguraDaCauda() != null) this.larguraDaCauda = biometriaDTO.larguraDaCauda();
        if (biometriaDTO.comprimentoEscudoEscapular() != null) this.comprimentoEscudoEscapular = biometriaDTO.comprimentoEscudoEscapular();
        if (biometriaDTO.semicircunferenciaEscudoEscapular() != null) this.semicircunferenciaEscudoEscapular = biometriaDTO.semicircunferenciaEscudoEscapular();
        if (biometriaDTO.comprimentoEscudoPelvico() != null) this.comprimentoEscudoPelvico = biometriaDTO.comprimentoEscudoPelvico();
        if (biometriaDTO.semicircunferenciaEscudoPelvico() != null) this.semicircunferenciaEscudoPelvico = biometriaDTO.semicircunferenciaEscudoPelvico();
        if (biometriaDTO.larguraNaSegundaCinta() != null) this.larguraNaSegundaCinta = biometriaDTO.larguraNaSegundaCinta();
        if (biometriaDTO.numeroDeCintas() != null) this.numeroDeCintas = biometriaDTO.numeroDeCintas();
        if (biometriaDTO.comprimentoMaoSemUnha() != null) this.comprimentoMaoSemUnha = biometriaDTO.comprimentoMaoSemUnha();
        if (biometriaDTO.comprimentoUnhaDaMao() != null) this.comprimentoUnhaDaMao = biometriaDTO.comprimentoUnhaDaMao();
        if (biometriaDTO.comprimentoPeSemUnha() != null) this.comprimentoPeSemUnha = biometriaDTO.comprimentoPeSemUnha();
        if (biometriaDTO.comprimentoUnhaDoPe() != null) this.comprimentoUnhaDoPe = biometriaDTO.comprimentoUnhaDoPe();
        if (biometriaDTO.comprimentoDoPenis() != null) this.comprimentoDoPenis = biometriaDTO.comprimentoDoPenis();
        if (biometriaDTO.larguraBasePenis() != null) this.larguraBasePenis = biometriaDTO.larguraBasePenis();
        if (biometriaDTO.comprimentoDoClitoris() != null) this.comprimentoDoClitoris = biometriaDTO.comprimentoDoClitoris();
    }
}
