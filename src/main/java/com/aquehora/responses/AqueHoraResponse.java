package com.aquehora.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AqueHoraResponse <T>
{
    private String status;
    private String code;
    private String message;
    private T data;
    public AqueHoraResponse(String status,String code,String message)
    {
        this.status=status;
        this.code=code;
        this.message=message;
    }

}
