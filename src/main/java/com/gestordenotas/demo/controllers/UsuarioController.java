package com.gestordenotas.demo.controllers;

import com.gestordenotas.demo.DTO.CreateUsuarioDto;
import com.gestordenotas.demo.DTO.UsuarioDto;
import com.gestordenotas.demo.entities.Usuario;
import com.gestordenotas.demo.exceptions.AqueHoraExceptions;
import com.gestordenotas.demo.responses.AqueHoraResponse;
import com.gestordenotas.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/gestordenotas/demo")
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/{usuarioId}")
    public AqueHoraResponse<UsuarioDto> getUsuarioById(@PathVariable Long usuarioId)
            throws AqueHoraExceptions{
        return new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getUsuarioById(usuarioId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/allusuarios")
    public AqueHoraResponse<List<UsuarioDto>> getUsuarios()
            throws AqueHoraExceptions{
        return new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getUsuarios());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios")
    public AqueHoraResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto)
            throws AqueHoraExceptions{
        return new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.createUsuario(createUsuarioDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/upduser")
    public int updateUsuario(@RequestBody String contrasena, Long usuarioId){
        try {
            return usuarioService.setupdateUser(contrasena, usuarioId);
        } catch (AqueHoraExceptions aqueHoraExceptions) {
            aqueHoraExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updusercorreo")
    public int updateUsuarioCorreo(@RequestBody String correo, Long usuarioId){
        try {
            return usuarioService.setUpdateUserCorreo(correo, usuarioId);
        } catch (AqueHoraExceptions aqueHoraExceptions) {
            aqueHoraExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/LoginUser")
    public AqueHoraResponse<UsuarioDto> LoginAcces(String nombre,String contrasena)
            throws AqueHoraExceptions{
        return new AqueHoraResponse<>("Succes Login",String.valueOf(HttpStatus.OK),"OK",usuarioService.LoginAcess(nombre,contrasena));
    }

}