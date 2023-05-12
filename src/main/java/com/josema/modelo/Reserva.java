package com.josema.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="reservas")
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private double valor;
	private String formaPago;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "huesped", referencedColumnName = "dni")
	private Huesped huesped;
	
	public Reserva() {}

	public Reserva(Date fechaEntrada, Date fechaSalida, double valor, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public String getId() {
		String formattedId=String.format("%07d", id);
		return formattedId;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Huesped getHuesped() {
		return huesped;
	}

	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	
	public Object[] toArray() {
		return new Object[] {
				this.getId(),
				this.fechaEntrada.toString(),
				this.fechaSalida.toString(),
				Double.toString(this.valor),
				this.getFormaPago()
		};
	}
	
}
