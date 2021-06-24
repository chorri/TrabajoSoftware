package com.gestordenotas.demo.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<AqueHoraResponse<T>> createResponse(){return new ResponseEntity<>(this, HttpStatus.OK);}
    public ResponseEntity<AqueHoraResponse<T>> createResponse(HttpStatus status) {
        return new ResponseEntity<>(this, status);
    }
}
