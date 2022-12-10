package com.example.proyIntegradorFinal.config;

import com.example.proyIntegradorFinal.model.Rol;
import com.example.proyIntegradorFinal.model.Usuario;
import com.example.proyIntegradorFinal.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class HardCode implements ApplicationRunner {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        var usuarioUser = new Usuario(null,"Juan","juanpa@gmail.com", new BCryptPasswordEncoder().encode("7777"), Rol.USER);

        usuarioRepository.save(usuarioUser);

        var usuarioAdmin = new Usuario(null,"Pablo","pablo@gmail.com", new BCryptPasswordEncoder().encode("7778"), Rol.ADMIN);

        usuarioRepository.save(usuarioAdmin);



    }
}
