package br.edu.multivix.pei.tolyid.domain.captura;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
