package com.josema.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.josema.modelo.Usuario;

public class UsuarioDao {
	private EntityManager em;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UsuarioDao(EntityManager em) {
		this.em = em;
		this.passwordEncoder=new BCryptPasswordEncoder();
	}
	//Guardar usuario
	public void save(Usuario usuario){
		String contraHash=passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(contraHash);
		em.persist(usuario);
	}
	//Obtener usuario por su nombre
	public Usuario getUserByName(String name) {
		String jpql="SELECT u FROM Usuario u WHERE u.nombre=:nombre";
		try {
			return em.createQuery(jpql,Usuario.class).setParameter("nombre", name).getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
		
	}
	
}
