package com.aquehora.pomodoroservice.controller;

import com.aquehora.pomodoroservice.dto.ConfigPomodoro;
import com.aquehora.pomodoroservice.dto.Reporte;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//END POINTS
@Api
@RestController
public class PomController {

    @ApiOperation(value = "Obtener el reporte pomodoro dado la Id de la nota asociada")
    @GetMapping(value="/reporte/{notaId}")
    public ResponseEntity<Reporte> ObtenerPorId(){

        Reporte rep = new Reporte();
        rep.setNotaId("12478");
        rep.setNombreNota("Avanzar Ingeniería de Software");
        rep.setVecesBreak(4);
        rep.setVecesWork(5);
        rep.setTiempoBreak(19.95);
        rep.setTiempoWork(20.40);
        return new ResponseEntity<>(rep, HttpStatus.OK);
    }

    @ApiOperation(value = "Insertar datos de configuracion para la ejecución del pomodoro")
    @PostMapping(value="/Reporte")
    public ResponseEntity<Reporte> IngresarPomodoro(@RequestBody ConfigPomodoro cp){

        Reporte rep = new Reporte();

        return new ResponseEntity<>(rep , HttpStatus.OK);
    }


}
