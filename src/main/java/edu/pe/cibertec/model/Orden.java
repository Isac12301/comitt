package edu.pe.cibertec.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Cliente ID")
    private int idCliente;
    
    @Column(name = "Fecha de Orden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

	public Orden() {
		super();
	}

	public Orden(int id, int idCliente, Date fechaOrden, Libro libro) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.fechaOrden = fechaOrden;
		this.libro = libro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Date getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
    
    
}