package com.aluracursos.challengeLiteralura.repositorio;

import com.aluracursos.challengeLiteralura.modelo.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAutorRepository extends JpaRepository<Autores, Long> {


    Autores findByNombreAndFechaNacimientoAndFechaFallecimiento(String nombre, Integer fechaNacimiento,
                                                                Integer fechaFallecimiento);
}
