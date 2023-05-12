package com.josema.controlador;

import javax.persistence.EntityManager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.josema.dao.UsuarioDao;
import com.josema.modelo.Usuario;
import com.josema.utils.JPAUtils;

public class UsuarioController {
	private UsuarioDao usuarioDao;
	private EntityManager em;
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioController() {
		this.em=JPAUtils.getEntityManager();
		this.usuarioDao=new UsuarioDao(em);
		this.passwordEncoder=new BCryptPasswordEncoder();
	}
	
	//Guardar
	public void save(Usuario usuario) {
		em.getTransaction().begin();
		usuarioDao.save(usuario);
		em.getTransaction().commit();
	}
	//Iniciar de Sesion
	public boolean iniciarSesion(String nombre, String pass) {
		Usuario usuario = usuarioDao.getUserByName(nombre);
		if(usuario!=null && passwordEncoder.matches(pass, usuario.getPassword())) {
			return true;
		}{
			return false;
		}
	}
}
