package com.gestordenotas.demo.DTO;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class NotaRequest {
    @NotNull
    private String userId;
}
