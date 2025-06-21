package com.italooliveira.app_agendamento.backend.models;

import com.italooliveira.app_agendamento.backend.models.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha;
    private String foto;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    private Set<Disponibilidade> disponibilidades = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private List<Servico> servicos;

    @OneToMany(mappedBy = "usuario")
    private List<Agendamento> agendamentos;
}
