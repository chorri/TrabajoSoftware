package com.aquehora.pomodoroservice.controller;

import com.aquehora.pomodoroservice.dto.ConfigPomodoro;
import com.aquehora.pomodoroservice.dto.Reporte;
import com.aquehora.pomodoroservice.entity.ReporteEntity;
import com.aquehora.pomodoroservice.service.PomService;
import com.aquehora.pomodoroservice.util.EntityDtoConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final PomService ps;
    private final EntityDtoConverter conv;

    @Autowired
    public PomController(PomService ps, EntityDtoConverter conv){
        this.ps=ps;
        this.conv=conv;
    }

    @ApiOperation(value = "Obtener el reporte pomodoro dado la Id de la nota asociada")
    @GetMapping(value="/reporte/{notaId}")
    public ResponseEntity<Reporte> ObtenerPorId(){
        ReporteEntity rep = ps.ObtenerReportePorId("4578454121");
        Reporte repDTO = conv.convertEntityToDto(rep);
        return new ResponseEntity<>(repDTO, HttpStatus.OK);
    }

    @GetMapping(value="/report")
    public ResponseEntity<Reporte> Prueba(){
        Reporte rep = new Reporte();
        rep.setNotaId("47489");
        rep.setNombreNota("Hacer la actividad");
        return new ResponseEntity<>(rep, HttpStatus.OK);
    }



    @ApiOperation(value = "Insertar datos de configuracion para la ejecución del pomodoro")
    @PostMapping(value="/Reporte")
    public ResponseEntity<Reporte> IngresarPomodoro(@RequestBody ConfigPomodoro cp){

        ReporteEntity rep = ps.GenerarReporte(cp);
        Reporte repDTO = conv.convertEntityToDto(rep);
        return new ResponseEntity<>(repDTO , HttpStatus.OK);
    }


}
