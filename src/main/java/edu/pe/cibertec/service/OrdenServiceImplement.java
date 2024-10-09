package edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.cibertec.model.Libro;
import edu.pe.cibertec.model.Orden;
import edu.pe.cibertec.repository.LibroRepository;
import edu.pe.cibertec.repository.OrdenRepository;

@Service
public class OrdenServiceImplement implements IOrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private LibroRepository libroRepository; // Repositorio para los libros

    // Método para listar todas las órdenes
    @Override
    public List<Orden> listarOrdenes() {
        return ordenRepository.findAll();
    }

    // Método para guardar una orden
    @Override
    public Orden guardarOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    // Método para buscar una orden por ID
    @Override
    public Optional<Orden> buscarOrden(int id) { // Cambié 'codigo' a 'id' para ser más claro
        return ordenRepository.findById(id);
    }

    // Método para eliminar una orden por ID
    @Override
    public void eliminarOrden(int id) { // Cambié 'codigo' a 'id' para ser más claro
        ordenRepository.deleteById(id);
    }

    // Método para listar todos los libros
    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll(); // Este método recupera todos los libros desde la base de datos
    }
}