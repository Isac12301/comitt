package edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import edu.pe.cibertec.model.Libro;
import edu.pe.cibertec.model.Orden;

public interface IOrdenService {
	 // Métodos para gestionar las órdenes
    public List<Orden> listarOrdenes();
    public Orden guardarOrden(Orden orden);
    public Optional<Orden> buscarOrden(int codigo);
    public void eliminarOrden(int codigo);
    
    // Método para listar los libros
    public List<Libro> listarLibros(); // Nuevo método para listar libros
}