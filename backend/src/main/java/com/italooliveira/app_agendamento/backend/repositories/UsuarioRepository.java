package com.italooliveira.app_agendamento.backend.repositories;

import com.italooliveira.app_agendamento.backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(final String email);

    Optional<Usuario> findByCpf(final String cpf);
}
