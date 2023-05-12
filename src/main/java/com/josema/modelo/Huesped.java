package com.josema.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="huespedes")
public class Huesped implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private Date fechaDeNacimiento;
	private String dni;
	private String telefono;
	
	@OneToMany(mappedBy="huesped",cascade=CascadeType.ALL)
	private List<Reserva> reservas = new ArrayList<>();
	
	public Huesped() {}

	public Huesped(String nombre, String apellido, Date fechaDeNacimiento, String dni, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dni = dni;
		this.telefono = telefono;
	}

	public String getId() {
		String formattedId=String.format("%07d", id);
		return formattedId;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	public Object[] toArray() {
		return new Object[] {
				this.getId(),
				this.getNombre(),
				this.getApellido(),
				this.getFechaDeNacimiento().toString(),
				this.getDni(),
				this.getTelefono(),
				this.reservas.size()+""
		};
	}
}
