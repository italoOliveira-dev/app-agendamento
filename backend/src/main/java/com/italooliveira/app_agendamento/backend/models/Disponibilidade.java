package com.italooliveira.app_agendamento.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_disponibilidades")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DayOfWeek diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Integer intervaloEntreAgendamentos;
    private boolean disponivel;
    private boolean repeteSemanal;
    private LocalDate validadeInicio;
    private LocalDate validadeFim;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
