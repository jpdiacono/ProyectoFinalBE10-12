package com.example.proyIntegradorFinal.repository;

import com.example.proyIntegradorFinal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByEmail(String email);
}
