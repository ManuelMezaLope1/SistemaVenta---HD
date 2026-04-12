package com.talentmad.app.usuario.servicio;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.talentmad.app.usuario.controlador.dto.UsuarioRegistroDto;
import com.talentmad.app.usuario.modelo.Usuario;
import com.talentmad.app.usuario.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
    @Autowired
    private UsuarioRepositorio repositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario guardar(UsuarioRegistroDto registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), 
				registroDTO.getApellido(),registroDTO.getEmail(),
				passwordEncoder.encode(registroDTO.getPassword()));
		return repositorio.save(usuario);
	}

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repositorio.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(),usuario.getPassword(), Collections.emptyList());
	}
}
