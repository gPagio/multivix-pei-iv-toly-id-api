package br.edu.multivix.pei.tolyid.domain.amostra;

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
@Table(name = "amostra")
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
}
