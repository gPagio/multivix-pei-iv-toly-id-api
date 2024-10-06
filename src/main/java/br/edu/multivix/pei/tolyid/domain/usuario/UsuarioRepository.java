package br.edu.multivix.pei.tolyid.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    UserDetails findByEmailAndAtivoTrue(String email);

}
