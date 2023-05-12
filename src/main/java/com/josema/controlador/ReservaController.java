package com.josema.controlador;

import java.util.List;

import javax.persistence.EntityManager;

import com.josema.dao.ReservaDao;
import com.josema.modelo.Reserva;
import com.josema.utils.JPAUtils;

public class ReservaController {
	private ReservaDao reservaDao;
	private EntityManager em;
	
	public ReservaController() {
		this.em=JPAUtils.getEntityManager();
		this.reservaDao=new ReservaDao(em);
	}
	//Obtener por id
	public Reserva getById(Long id) {
		return reservaDao.getById(id);
	}
	//Listar
	public List<Reserva> list(){
		return reservaDao.list();
	}
	//Guardar
	public void save(Reserva reserva) {
		em.getTransaction().begin();
		reservaDao.save(reserva);
		em.getTransaction().commit();
	}
	//Actualizar
	public void update(Reserva reserva) {
		em.getTransaction().begin();
		reservaDao.update(reserva);
		em.getTransaction().commit();
	}
	//Eliminar por id
	public void deleteById(Long id) {
		em.getTransaction().begin();
		reservaDao.deleteById(id);
		em.getTransaction().commit();
	}
	//Buscar
	public List<Reserva> search(String texto) {
		return reservaDao.search(texto);
	}
	//Buscar nulos
	public List<Reserva> searchNull(){
		return reservaDao.searchNull();
	}
}
