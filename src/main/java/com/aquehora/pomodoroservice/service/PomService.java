package com.aquehora.pomodoroservice.service;

import com.aquehora.pomodoroservice.dto.ConfigPomodoro;
import com.aquehora.pomodoroservice.dto.Reporte;
import com.aquehora.pomodoroservice.entity.ReporteEntity;
import org.springframework.stereotype.Service;

@Service
public class PomService {
    //hace un procesamiento para generar un reporte en base de la configuracion de los pomodoros
    public ReporteEntity GenerarReporte(ConfigPomodoro cp){
        ReporteEntity rep = new ReporteEntity();
        rep.setNotaId(cp.getIdNota());
        rep.setNombreNota(cp.getNombreNota());
        //Estos campos se llenaran en base a la informacion de los pomodoros
        rep.setVecesWork(7);
        rep.setVecesBreak(5);
        rep.setTiempoWork(7.45);
        rep.setTiempoBreak(4.14);
        //Hacemos uso del repositorio para almacenar el reporte en la base de datos
        return rep;
    }
    public ReporteEntity ObtenerReportePorId(String NotaId){
        //Hacemos uso del repositorio para recuperar el reporte dado la notaId de la Base de datos
        ReporteEntity rep = new ReporteEntity();
        rep.setNotaId("12478");
        rep.setNombreNota("Avanzar Ingeniería de Software");
        rep.setVecesBreak(4);
        rep.setVecesWork(5);
        rep.setTiempoBreak(19.95);
        rep.setTiempoWork(20.40);
        return rep;

    }

}
