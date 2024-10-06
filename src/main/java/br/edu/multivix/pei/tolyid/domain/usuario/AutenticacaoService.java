package br.edu.multivix.pei.tolyid.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmailAndAtivoTrue(email);
    }

    public static Usuario getUsuarioLogado() {
        return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}