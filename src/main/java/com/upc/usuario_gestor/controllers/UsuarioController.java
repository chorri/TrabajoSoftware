package com.upc.usuario_gestor.controllers;


import com.upc.usuario_gestor.DTO.CreateUsuarioDto;
import com.upc.usuario_gestor.DTO.NotaDTO;
import com.upc.usuario_gestor.DTO.UsuarioDto;
import com.upc.usuario_gestor.entities.Usuario;
import com.upc.usuario_gestor.exceptions.UsuarioGestorExceptions;
import com.upc.usuario_gestor.responses.UsuarioGestorResponse;
import com.upc.usuario_gestor.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/WhatTimeUsuario")
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/{usuarioId}")
    public UsuarioGestorResponse<UsuarioDto> getUsuarioById(@PathVariable Long usuarioId)
            throws UsuarioGestorExceptions {
       return new UsuarioGestorResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getUsuarioById(usuarioId));
        //return usuarioService.getUsuarioById(usuarioId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/allusuarios")
    public UsuarioGestorResponse<List<UsuarioDto>> getUsuarios()
            throws UsuarioGestorExceptions{
        return new UsuarioGestorResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getUsuarios());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios")
    public UsuarioGestorResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto)
            throws UsuarioGestorExceptions{
        return new UsuarioGestorResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.createUsuario(createUsuarioDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/upduser")
    public int updateUsuarioPassword(@RequestBody String contrasena, Long usuarioId){
        try {
            return usuarioService.setupdateUserPassword(contrasena, usuarioId);
        } catch (UsuarioGestorExceptions UsuarioGestorExceptions) {
            UsuarioGestorExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updusercorreo")
    public int updateUsuarioCorreo(@RequestBody String correo, Long usuarioId){
        try {
            return usuarioService.setUpdateUserCorreo(correo, usuarioId);
        } catch (UsuarioGestorExceptions UsuarioGestorExceptions) {
            UsuarioGestorExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/LoginUser")
    public UsuarioGestorResponse<UsuarioDto> LoginAcces(String nombre, String contrasena)
            throws UsuarioGestorExceptions{
        return new UsuarioGestorResponse<>("Succes Login",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.LoginAcess(nombre,contrasena));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/NotasUser")
    public UsuarioGestorResponse<List<NotaDTO>> getNotas(String userId)
            throws UsuarioGestorExceptions{
        return new UsuarioGestorResponse<>("Succes Login",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getNotasByUser(userId));

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteuser")
    public void deleteUser(Long userId)
    {
        try {
            usuarioService.deleteUser(userId);
        } catch (UsuarioGestorExceptions UsuarioGestorExceptions) {
            UsuarioGestorExceptions.printStackTrace();
        }
    }
}
