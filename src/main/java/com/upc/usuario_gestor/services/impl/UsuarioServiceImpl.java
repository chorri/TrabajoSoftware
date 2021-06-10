package com.upc.usuario_gestor.services.impl;

import com.upc.usuario_gestor.DTO.CreateUsuarioDto;
import com.upc.usuario_gestor.DTO.UsuarioDto;
import com.upc.usuario_gestor.entities.Usuario;
import com.upc.usuario_gestor.exceptions.InternalServerErrorException;
import com.upc.usuario_gestor.exceptions.NotFoundException;
import com.upc.usuario_gestor.exceptions.UsuarioGestorExceptions;
import com.upc.usuario_gestor.repositories.UsuarioRepository;
import com.upc.usuario_gestor.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService
{
    @Autowired  //Inyeccion de Dependencias, con esto podemos usar los Repository
    private UsuarioRepository usuarioRepository;
    private static final ModelMapper modelMapper=new ModelMapper();


    @Override
    public UsuarioDto getUsuarioById(Long usuarioId) throws UsuarioGestorExceptions {
        return modelMapper.map(getUsuarioEntity(usuarioId),UsuarioDto.class);
    }

    @Override
    public List<UsuarioDto> getUsuarios() throws UsuarioGestorExceptions {
        List<Usuario> usuariosEntity=usuarioRepository.findAll();
        return usuariosEntity.stream().map(usuario->modelMapper.map(usuario,UsuarioDto.class)).collect(Collectors.toList());
    }
    @Override
    public UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws UsuarioGestorExceptions {
        Usuario usuario=new Usuario();
        usuario.setNombre(createUsuarioDto.getName());
        usuario.setCorreo(createUsuarioDto.getCorreo());
        usuario.setContrasena(createUsuarioDto.getPassword());

        try{
            //usuario=usuarioRepository.save(usuario);
            usuario= (Usuario) usuarioRepository.save(usuario);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return  modelMapper.map(getUsuarioEntity(usuario.getId()),UsuarioDto.class);
    }

    @Override
    public int setupdateUserPassword(String contrasena, Long usuarioId) throws UsuarioGestorExceptions {

        return usuarioRepository.setUpdatePassword(contrasena,usuarioId);
    }

    @Override
    public int setUpdateUserCorreo(String correo, Long usuarioId) throws UsuarioGestorExceptions {
        return usuarioRepository.setUpdateUserCorreo(correo,usuarioId);
    }

    @Override
    public UsuarioDto LoginAcess(String usuario, String contrasena) throws UsuarioGestorExceptions
    {
        return modelMapper.map(usuarioRepository.findByNombreEqualsAndContrasenaEquals(usuario,contrasena), UsuarioDto.class);
    }

    @Override
    public void deleteUser(Long userid) throws UsuarioGestorExceptions
    {
        usuarioRepository.deleteUser(userid);
    }

    public Usuario getUsuarioEntity(Long usuarioId) throws UsuarioGestorExceptions
    {
        return usuarioRepository.findById(usuarioId).orElseThrow(()->new NotFoundException("NOTFOUND-4040","USUARIO-NOTFOUND-404"));
    }
    public Usuario getUsuarioEntityName(String name) throws UsuarioGestorExceptions
    {
        return usuarioRepository.findByNombre(name).orElseThrow(()->new NotFoundException("NOTFOUND-4040","USUARIO-NOTFOUND-404"));
    }
    public Usuario getUsuarioID(String name) throws UsuarioGestorExceptions
    {
        return usuarioRepository.findByNombre(name).orElseThrow(()->new NotFoundException("NOTFOUND-4040","USUARIO-NOTFOUND-404"));
    }
}
