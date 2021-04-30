package com.aquehora.exceptions;

import com.aquehora.DTO.ErrorDto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AqueHoraExceptions extends  Exception
{
    private final String code; //codigo error
    private final int responseCode; //Codigo respuesta
    private final List<ErrorDto> errorList=new ArrayList<>();
    public AqueHoraExceptions(String code, int responseCode, String message)
    {
        super(message);
        this.code=code;
        this.responseCode=responseCode;

    }
    public AqueHoraExceptions(String code, int responseCode, String message,List<ErrorDto> errorList)
    {
        super(message);
        this.code=code;
        this.responseCode=responseCode;
        this.errorList.addAll(errorList);

    }

}
