package com.gestordenotas.demo.DTO;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NotaRequest {
    @NotNull
    @ApiModelProperty(notes="Id de Usuario",example ="1",required = true,position = 0)
    private String userId;
}
