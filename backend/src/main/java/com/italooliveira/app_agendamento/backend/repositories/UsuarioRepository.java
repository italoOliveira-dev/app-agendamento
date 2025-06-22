package com.italooliveira.app_agendamento.backend.repositories;

import com.italooliveira.app_agendamento.backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
