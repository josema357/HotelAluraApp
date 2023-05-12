package com.josema.controlador;

import java.util.List;

import javax.persistence.EntityManager;

import com.josema.dao.HuespedDao;
import com.josema.modelo.Huesped;
import com.josema.utils.JPAUtils;

public class HuespedController {
	private HuespedDao huespedDao;
	private EntityManager em;
	
	public HuespedController() {
		this.em=JPAUtils.getEntityManager();
		this.huespedDao=new HuespedDao(em);
	}
	//Obtener por id
	public Huesped getById(Long id) {
		return huespedDao.getById(id);
	}
	//Obtener por dni
	public Huesped getByDni(String dni) {
		return huespedDao.getByDni(dni);
	}
	//Listar
	public List<Huesped> list(){
		return huespedDao.list();
	}
	//Guardar
	public void save(Huesped huesped) {
		em.getTransaction().begin();
		huespedDao.save(huesped);
		em.getTransaction().commit();
	}
	//Actualizar
	public void update(Huesped huesped) {
		em.getTransaction().begin();
		huespedDao.update(huesped);
		em.getTransaction().commit();
	}
	//Eliminar por id
	public void delete(Long id) {
		em.getTransaction().begin();
		huespedDao.delete(id);
		em.getTransaction().commit();
	}
	//Buscar
	public List<Huesped> search(String texto) {
		return huespedDao.search(texto);
	}
}

