package com.talentmad.app.usuario.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.talentmad.app.usuario.controlador.dto.UsuarioRegistroDto;
import com.talentmad.app.usuario.servicio.UsuarioServicio;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroUsuarioControlador {
    @Autowired
    private UsuarioServicio servicio;

    public RegistroUsuarioControlador(UsuarioServicio servicio){
        super();
        this.servicio=servicio;
    }

    @GetMapping({"/inicio","","/"})
    public String mostrarInicio() {
        return "index";
    }
    

    @ModelAttribute("usuario")
    public UsuarioRegistroDto retornarNuevoUsuarioRegistroDto() {
        return new UsuarioRegistroDto();
    }
    
    @GetMapping("/login")
    public String mostrarFormularioDeLogin() {
        return "login";
    }

    @GetMapping("/registro")
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String guardarRegistro(@ModelAttribute("usuario") UsuarioRegistroDto registroDto) {
        servicio.guardar(registroDto);
        return "redirect:/registro?exito";
    }
}
