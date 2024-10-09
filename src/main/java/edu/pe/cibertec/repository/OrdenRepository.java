package edu.pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pe.cibertec.model.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {

}
