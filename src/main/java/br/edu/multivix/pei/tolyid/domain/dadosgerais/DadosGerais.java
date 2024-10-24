package br.edu.multivix.pei.tolyid.domain.dadosgerais;

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

import java.time.LocalDateTime;

import br.edu.multivix.pei.tolyid.domain.captura.Captura;
import br.edu.multivix.pei.tolyid.domain.dadosgerais.dto.DadosAtualizacaoDadosGeraisDTO;
import br.edu.multivix.pei.tolyid.domain.dadosgerais.dto.DadosCadastroDadosGeraisDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Table(name = "dados_gerais")
@Entity(name = "DadosGerais")
public class DadosGerais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localDeCaptura;
    private String equipeResponsavel;
    private String instituicao;
    private Double pesoDoTatu;
    private LocalDateTime dataCaptura;
    private String contatoDoResponsavel;
    private String observacoes;

    @OneToOne(mappedBy = "dadosGerais")
    private Captura captura;

    public DadosGerais(DadosCadastroDadosGeraisDTO dadosGeraisDTO) {
        this.localDeCaptura = dadosGeraisDTO.localDeCaptura().trim();
        this.equipeResponsavel = dadosGeraisDTO.equipeResponsavel().trim();
        this.instituicao = dadosGeraisDTO.instituicao().trim();
        this.pesoDoTatu = dadosGeraisDTO.pesoDoTatu();
        this.dataCaptura = dadosGeraisDTO.dataCaptura();
        this.contatoDoResponsavel = dadosGeraisDTO.contatoDoResponsavel().trim();
        this.observacoes = dadosGeraisDTO.observacoes().trim();
    }

    public void atualizaInformacoes(DadosAtualizacaoDadosGeraisDTO dadosGeraisDTO) {
        if (dadosGeraisDTO.localDeCaptura() != null) this.localDeCaptura = dadosGeraisDTO.localDeCaptura().trim();
        if (dadosGeraisDTO.equipeResponsavel() != null) this.equipeResponsavel = dadosGeraisDTO.equipeResponsavel().trim();
        if (dadosGeraisDTO.instituicao() != null) this.instituicao = dadosGeraisDTO.instituicao().trim();
        if (dadosGeraisDTO.pesoDoTatu() != null) this.pesoDoTatu = dadosGeraisDTO.pesoDoTatu();
        if (dadosGeraisDTO.dataCaptura() != null) this.dataCaptura = dadosGeraisDTO.dataCaptura();
        if (dadosGeraisDTO.contatoDoResponsavel() != null) this.contatoDoResponsavel = dadosGeraisDTO.contatoDoResponsavel().trim();
        if (dadosGeraisDTO.observacoes() != null) this.observacoes = dadosGeraisDTO.observacoes().trim();
    }

}
