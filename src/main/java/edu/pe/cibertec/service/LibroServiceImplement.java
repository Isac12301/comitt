package edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.cibertec.model.Libro;
import edu.pe.cibertec.repository.LibroRepository;

@Service
public class LibroServiceImplement implements ILibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Optional<Libro> buscarLibro(int codigo) {
        return libroRepository.findById(codigo);
    }

    @Override
    public void eliminarLibro(int codigo) {
        libroRepository.deleteById(codigo);
    }
}
