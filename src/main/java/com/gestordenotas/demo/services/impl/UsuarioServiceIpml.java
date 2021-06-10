package com.gestordenotas.demo.services.impl;

import com.gestordenotas.demo.DTO.CreateUsuarioDto;
import com.gestordenotas.demo.DTO.UsuarioDto;
import com.gestordenotas.demo.entities.Usuario;
import com.gestordenotas.demo.exceptions.AqueHoraExceptions;
import com.gestordenotas.demo.exceptions.InternalServerErrorException;
import com.gestordenotas.demo.exceptions.NotFoundException;
import com.gestordenotas.demo.repositories.UsuarioRepository;
import com.gestordenotas.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceIpml implements UsuarioService
{
    @Autowired  //Inyeccion de Dependencias, con esto podemos usar los Repository
    private UsuarioRepository usuarioRepository;
    private static final ModelMapper modelMapper= new ModelMapper() {};


    @Override
    public UsuarioDto getUsuarioById(Long usuarioId) throws AqueHoraExceptions {
        return modelMapper.map(getUsuarioEntity(usuarioId),UsuarioDto.class);
    }

    @Override
    public List<UsuarioDto> getUsuarios() throws AqueHoraExceptions {
        List<Usuario> usuariosEntity=usuarioRepository.findAll();
        return usuariosEntity.stream().map(usuario->modelMapper.map(usuario,UsuarioDto.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws AqueHoraExceptions {
        Usuario usuario=new Usuario();
        usuario.setNombre(createUsuarioDto.getName());
        usuario.setCorreo(createUsuarioDto.getCorreo());
        usuario.setContrasena(createUsuarioDto.getContrasena());
        try{
            usuario=usuarioRepository.save(usuario);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return  modelMapper.map(getUsuarioEntity(usuario.getId()),UsuarioDto.class);
    }

    @Override
    public int setupdateUser(String contrasena, Long usuarioId) throws AqueHoraExceptions {

        return usuarioRepository.setUpdateUser(contrasena,usuarioId);
    }

    @Override
    public int setUpdateUserCorreo(String correo, Long usuarioId) throws AqueHoraExceptions {
        return usuarioRepository.setUpdateUserCorreo(correo,usuarioId);
    }

    @Override
    public UsuarioDto LoginAcess(String usuario, String contrasena) throws AqueHoraExceptions
    {
        usuarioRepository.findByNombreEqualsAndContrasenaEquals(usuario,contrasena);
        return modelMapper.map(getUsuarioEntityName(usuario),UsuarioDto.class);
    }

    public Usuario getUsuarioEntity(Long usuarioId) throws AqueHoraExceptions
    {
        return usuarioRepository.findById(usuarioId).orElseThrow(()->new NotFoundException("NOTFOUND-4040","USUARIO-NOTFOUND-404"));
    }

    public Usuario getUsuarioEntityName(String name) throws AqueHoraExceptions
    {
        return usuarioRepository.findByNombre(name).orElseThrow(()->new NotFoundException("NOTFOUND-4040","USUARIO-NOTFOUND-404"));
    }
}
