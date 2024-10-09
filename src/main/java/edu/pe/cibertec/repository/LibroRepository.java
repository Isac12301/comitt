package edu.pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pe.cibertec.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
