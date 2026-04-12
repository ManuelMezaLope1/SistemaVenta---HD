package com.talentmad.app.usuario.servicio;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.talentmad.app.usuario.controlador.dto.UsuarioRegistroDto;
import com.talentmad.app.usuario.modelo.Usuario;

public interface UsuarioServicio extends UserDetailsService{
    public Usuario guardar(UsuarioRegistroDto registroDto);
}
