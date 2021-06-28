package com.upc.usuario_gestor.controllers;


import com.upc.usuario_gestor.DTO.CreateUsuarioDto;
import com.upc.usuario_gestor.DTO.NotaDTO;
import com.upc.usuario_gestor.DTO.UsuarioDto;
import com.upc.usuario_gestor.entities.Usuario;
import com.upc.usuario_gestor.exceptions.UsuarioGestorExceptions;
import com.upc.usuario_gestor.repositories.UsuarioRepository;
import com.upc.usuario_gestor.responses.UsuarioGestorResponse;
import com.upc.usuario_gestor.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Aquehora")
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve la información de un Usuario, atraves de su identificador.")
    @GetMapping("/usuarios/{usuarioId}")
    public UsuarioGestorResponse<UsuarioDto> getUsuarioById(@PathVariable Long usuarioId)
            throws UsuarioGestorExceptions {
        if(usuarioRepository.existsById(usuarioId))
        {
            return new UsuarioGestorResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                    usuarioService.getUsuarioById(usuarioId));
        }else
            {
                return new UsuarioGestorResponse<>("Fallo al Obtener Usuario",String.valueOf(HttpStatus.BAD_REQUEST),"Usuario no existente");
            }

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve la lista de todos los usuarios registrados.")
    @GetMapping("/getUsuarios")
    public UsuarioGestorResponse<List<UsuarioDto>> getUsuarios()
            throws UsuarioGestorExceptions{
        return new UsuarioGestorResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getUsuarios());
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Recibe un CreateUsuario y retorno un successfull como verificador de que la cuenta fue creado con éxito")
    @PostMapping("/usuarios")
    public UsuarioGestorResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto)
            throws UsuarioGestorExceptions{
        if(usuarioRepository.existsUsuarioByCorreo(createUsuarioDto.getCorreo()))
        {
            return new UsuarioGestorResponse<>("Fallo al crear Usuario",String.valueOf(HttpStatus.BAD_REQUEST),"El correo ya esta registrado");
        }else {
            return new UsuarioGestorResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                    usuarioService.createUsuario(createUsuarioDto));
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza los valores de la contraseña de un Usuario.")
    @PutMapping("/updateUser")
    public int updateUsuarioPassword(@RequestBody String contrasena, Long usuarioId){
        try {
            if(usuarioRepository.existsById(usuarioId)){
            return usuarioService.setupdateUserPassword(contrasena, usuarioId);
            }
        } catch (UsuarioGestorExceptions UsuarioGestorExceptions) {
            UsuarioGestorExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza los valores del correo de un Usuario.")
    @PutMapping("/updateCorreo")
    public int updateUsuarioCorreo(@RequestBody String correo, Long usuarioId){
        try {
            if(usuarioRepository.existsById(usuarioId)){
            return usuarioService.setUpdateUserCorreo(correo, usuarioId);}
        } catch (UsuarioGestorExceptions UsuarioGestorExceptions) {
            UsuarioGestorExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Verifica si el usuario ya existe en la base de datos y retorna un succesfull si es asi.")
    @GetMapping("/LoginUser")
    public UsuarioGestorResponse<UsuarioDto> LoginAcces(String nombre, String contrasena)
            throws UsuarioGestorExceptions{
        if(usuarioRepository.existsUsuarioByNombreAndContrasena(nombre,contrasena))
        {
        return new UsuarioGestorResponse<>("Succes Login",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.LoginAcess(nombre,contrasena));}
        else
            {
                return new UsuarioGestorResponse<>("Fallo al Iniciar Sesión",String.valueOf(HttpStatus.BAD_REQUEST),"Usuario o Contraseña erroneos vuelva a intentar");
            }
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Obtiene la lista de notas que posee un Usuario.")
    @GetMapping("/NotasUser")
    public UsuarioGestorResponse<List<NotaDTO>> getNotas(String userId)
            throws UsuarioGestorExceptions{
        if(usuarioRepository.existsById(Long.valueOf(userId))){
        return new UsuarioGestorResponse<>("Success se obtuvo las notas del Usuario",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getNotasByUser(userId));
        }else
        {
            return new UsuarioGestorResponse<>("Fallo al obtener notas",String.valueOf(HttpStatus.NOT_FOUND),"Usuario no existe");
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Elimina a un Usuario de la base de datos.")
    @DeleteMapping("/deleteUser")
    public void deleteUser(Long userId)
    {
        try {
            if(usuarioRepository.existsById(userId)){
            usuarioService.deleteUser(userId);
            }
        } catch (UsuarioGestorExceptions UsuarioGestorExceptions) {
            UsuarioGestorExceptions.printStackTrace();
        }
    }

}
