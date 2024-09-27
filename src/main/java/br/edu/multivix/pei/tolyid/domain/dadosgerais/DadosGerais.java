package br.edu.multivix.pei.tolyid.domain.dadosgerais;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

}
