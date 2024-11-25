package br.edu.multivix.pei.tolyid.domain.acesso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface AcessoRepository extends JpaRepository<Acesso, Long>{

    @Modifying
    @Transactional
    void deleteByUsuarioId(Long idUsuario);

}
