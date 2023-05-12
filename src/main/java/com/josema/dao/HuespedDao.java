package com.josema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.josema.modelo.Huesped;

public class HuespedDao {
	private EntityManager em;
	
	public HuespedDao(EntityManager em) {
		this.em=em;
	}
	
	//Obtener huesped por id
	public Huesped getById(Long id) {
		return em.find(Huesped.class, id);
	}
	//Obtener huesped por dni
	public Huesped getByDni(String dni) {
		String jpql="SELECT h FROM Huesped h WHERE h.dni= :dni";
		return em.createQuery(jpql,Huesped.class).setParameter("dni", dni).getSingleResult();
	}
	//Listar los huespedes
	public List<Huesped> list(){
		String jpql="SELECT h FROM Huesped h";
		TypedQuery<Huesped> query= em.createQuery(jpql,Huesped.class);
		return query.getResultList();
	}
	//Guardar registro
	public void save(Huesped huesped){
		String dni=huesped.getDni();
		String jpql="SELECT COUNT(h) FROM Huesped h WHERE h.dni = :dni";
		Long count= em.createQuery(jpql,Long.class).setParameter("dni", dni).getSingleResult();
		if(count==0) {
			em.persist(huesped);
		}
	}
	//Actulizar registro
	public void update(Huesped huesped){
		em.merge(huesped);
	}
	//Eliminar huesped por id
	public void delete(Long id) {
		Huesped huesped=em.find(Huesped.class, id);
		if(huesped!=null) {
			em.remove(huesped);
		}
	}
	//Buscar registros por dni
	public List<Huesped> search(String texto){
		final String jpql="SELECT h FROM Huesped h WHERE h.dni LIKE CONCAT('%', :texto, '%')";
		return em.createQuery(jpql,Huesped.class).setParameter("texto", texto).getResultList();
	}
}
