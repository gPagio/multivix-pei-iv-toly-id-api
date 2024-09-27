package br.edu.multivix.pei.tolyid.domain.fichaanestesica;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class FichaAnestesica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
