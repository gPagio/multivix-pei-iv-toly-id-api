package br.edu.multivix.pei.tolyid.domain.fichaanestesica;

import java.time.LocalTime;
import java.util.List;

import br.edu.multivix.pei.tolyid.domain.parametrofisiologico.DadosListagemParametroFisiologicoDTO;

public record DadosListagemFichaAnestesicaDTO(Long id,
                                            String tipoAnestesicoOuDose,
                                            String viaDeAdministracao,
                                            LocalTime aplicacao,
                                            LocalTime inducao,
                                            LocalTime retorno,
                                            List<DadosListagemParametroFisiologicoDTO> parametrosFisiologicos) {
    public DadosListagemFichaAnestesicaDTO(FichaAnestesica fichaAnestesica){
        this(fichaAnestesica.getId(),
             fichaAnestesica.getTipoAnestesicoOuDose(),
             fichaAnestesica.getViaDeAdministracao(),
             fichaAnestesica.getAplicacao(),
             fichaAnestesica.getInducao(),
             fichaAnestesica.getRetorno(),
             fichaAnestesica.getParametrosFisiologicos().stream().map(p -> new DadosListagemParametroFisiologicoDTO(p)).toList());
    }
}
