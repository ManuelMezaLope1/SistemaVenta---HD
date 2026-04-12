package com.talentmad.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import com.talentmad.app.usuario.modelo.Usuario;
import com.talentmad.app.usuario.repositorio.UsuarioRepositorio;

@SpringBootApplication
public class AppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

	@Autowired
	private UsuarioRepositorio repositorio;
	private final PasswordEncoder passwordEncoder;

	public AppApplication(UsuarioRepositorio repositorio,
                           PasswordEncoder passwordEncoder) {
        this.repositorio = repositorio;
        this.passwordEncoder = passwordEncoder;
    }

	@Override
	public void run(String... args) throws Exception{
		/*Usuario admin=new Usuario();

		admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin123")); // contraseña hasheada

			

		repositorio.save(admin);*/
	}
}
