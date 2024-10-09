package edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import edu.pe.cibertec.model.Libro;

public interface ILibroService {
    public List<Libro> listarLibros();
    public Libro guardarLibro(Libro libro);
    public Optional<Libro> buscarLibro(int codigod);
    public void eliminarLibro(int codigo);
}