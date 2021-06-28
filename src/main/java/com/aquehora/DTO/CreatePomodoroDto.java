package com.aquehora.DTO;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreatePomodoroDto {
    private String name_pomodoro;
    private Integer duracion;
    private LocalDateTime fecha_creacion;
    @NotNull
    private String notaId;
}