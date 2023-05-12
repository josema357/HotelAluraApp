package com.josema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.josema.modelo.Reserva;

public class ReservaDao {
	private EntityManager em;
	
	public ReservaDao(EntityManager em) {
		this.em=em;
	}
	
	//Obtener reserva por id
	public Reserva getById(Long id) {
		return em.find(Reserva.class, id);
	}
	//Listar las reservas
	public List<Reserva> list(){
		String jpql="SELECT r FROM Reserva r";
		TypedQuery<Reserva> query= em.createQuery(jpql,Reserva.class);
		return query.getResultList();
	}
	//Guardar registro
	public void save(Reserva reserva){
		em.persist(reserva);
	}
	//Actulizar registro
	public void update(Reserva reserva){
		em.merge(reserva);
	}
	//Eliminar reserva por id
	public void deleteById(Long id) {
		String jpql="DELETE FROM Reserva r WHERE r.id=:id";
		em.createQuery(jpql).setParameter("id", id).executeUpdate();
	}
	//Buscar registros por dni del huesped
	public List<Reserva> search(String texto){
		final String jpql="SELECT r FROM Reserva r WHERE r.huesped.dni LIKE CONCAT('%', :texto, '%')";
		return em.createQuery(jpql,Reserva.class).setParameter("texto", texto).getResultList();
	}
	//Buscar reservas sin huesped registrado
	public List<Reserva> searchNull(){
		String jpql="SELECT r FROM Reserva r WHERE r.huesped IS NULL";
		return em.createQuery(jpql,Reserva.class).getResultList();
	}
}
