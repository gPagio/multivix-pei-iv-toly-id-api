package br.edu.multivix.pei.tolyid.domain.usuario;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.multivix.pei.tolyid.domain.captura.Captura;
import br.edu.multivix.pei.tolyid.domain.usuario.acesso.Acesso;
import br.edu.multivix.pei.tolyid.domain.usuario.acesso.Authority;
import br.edu.multivix.pei.tolyid.domain.usuario.dto.DadosCadastroUsuarioDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Table(name = "usuarios")
@Entity(name = "Usuario")
public class Usuario implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Boolean ativo;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Acesso> acessos;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST , CascadeType.REFRESH})
    private List<Captura> capturas;

    public Usuario(DadosCadastroUsuarioDTO dados){
        this.nome = dados.nome().trim();
        this.email = dados.email().trim();
        this.senha = passwordEncoder().encode(dados.senha());
        if (dados.telefone() != null) this.telefone = dados.telefone().trim();
        this.ativo = Boolean.TRUE;
        if (dados.authorities() != null) this.acessos = dados.authorities().stream().map(a -> new Acesso(this, a)).toList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var acessosUsuarioLogado = acessos.stream()
                                            .map(acessos -> new SimpleGrantedAuthority(acessos.getAuthority().toString()))
                                            .toList();

        if (acessosUsuarioLogado.stream().anyMatch(authority -> authority.getAuthority().equals(Authority.ADMIN.toString()))){
            return List.of(new SimpleGrantedAuthority(Authority.ADMIN.toString()),
                           new SimpleGrantedAuthority(Authority.CADASTRAR.toString()),
                           new SimpleGrantedAuthority(Authority.ATUALIZAR.toString()),
                           new SimpleGrantedAuthority(Authority.LISTAR.toString()),
                           new SimpleGrantedAuthority(Authority.DELETAR.toString()));
        } else {
            return acessosUsuarioLogado;
        }
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public String getPassword() {
        return getSenha();
    }

    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
