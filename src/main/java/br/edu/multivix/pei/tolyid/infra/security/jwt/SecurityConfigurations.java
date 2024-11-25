package br.edu.multivix.pei.tolyid.infra.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.edu.multivix.pei.tolyid.domain.acesso.Authority;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req -> {
                    req.requestMatchers(HttpMethod.POST,"/login/**").permitAll();
                    req.requestMatchers(HttpMethod.OPTIONS).permitAll();
                    req.requestMatchers("/hello", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll();
                    req.requestMatchers("/usuarios").hasAnyAuthority(Authority.ADMIN.toString());
                    req.requestMatchers(HttpMethod.POST).hasAnyAuthority(Authority.CADASTRAR.toString());
                    req.requestMatchers(HttpMethod.PUT).hasAnyAuthority(Authority.ATUALIZAR.toString());
                    req.requestMatchers(HttpMethod.PATCH).hasAnyAuthority(Authority.ATUALIZAR.toString());
                    req.requestMatchers(HttpMethod.GET).hasAnyAuthority(Authority.LISTAR.toString());
                    req.requestMatchers(HttpMethod.DELETE).hasAnyAuthority(Authority.DELETAR.toString());
                    req.anyRequest().authenticated();
                })
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
