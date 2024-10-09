package edu.pe.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libros")
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Libroid;

    @Column(name ="Titulo" )
    private String titulo;
    
    @Column(name ="Nombre Autor" )
    private String autor;
    
    @Column(name ="Apellido Autor" )
    private String apellido;
    
    @Column(name ="Categoria" )
    private String categoria;
    
    private Double Precio;

	public Libro() {
		super();
	}

	public Libro(String titulo, String autor, String apellido, String categoria, Double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.apellido = apellido;
		this.categoria = categoria;
		Precio = precio;
	}

	public Libro(int libroid, String titulo, String autor, String apellido, String categoria, Double precio) {
		super();
		Libroid = libroid;
		this.titulo = titulo;
		this.autor = autor;
		this.apellido = apellido;
		this.categoria = categoria;
		Precio = precio;
	}

	public int getLibroid() {
		return Libroid;
	}

	public void setLibroid(int libroid) {
		Libroid = libroid;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

   
}