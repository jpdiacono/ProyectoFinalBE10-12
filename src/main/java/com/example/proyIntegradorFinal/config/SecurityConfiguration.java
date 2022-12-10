package com.example.proyIntegradorFinal.config;

import com.example.proyIntegradorFinal.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@AllArgsConstructor
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UsuarioService usuarioDetailService;
    private final BCryptPasswordEncoder passEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/hello")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        var provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passEncoder);
        provider.setUserDetailsService(usuarioDetailService);
        return provider;


    }
}
