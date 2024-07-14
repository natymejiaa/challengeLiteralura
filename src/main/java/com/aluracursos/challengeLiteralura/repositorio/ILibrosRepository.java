package com.aluracursos.challengeLiteralura.repositorio;

import com.aluracursos.challengeLiteralura.modelo.Autores;
import com.aluracursos.challengeLiteralura.modelo.Idiomas;
import com.aluracursos.challengeLiteralura.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ILibrosRepository extends JpaRepository<Libro, Long> {


    @Query("SELECT l FROM Libro l JOIN l.autores a WHERE l.titulo LIKE %:nombre%")
    Optional<Libro> buscarLibroPorNombre(@Param("nombre") String nombre);


    @Query("SELECT a FROM Libro l JOIN l.autores a WHERE a.nombre LIKE %:nombre%")
    Optional<Autores> buscarAutorPorNombre(@Param("nombre") String nombre);


    @Query("SELECT l FROM Autores a JOIN a.libros l")
    List<Libro> buscarTodosLosLibros();


    @Query("SELECT a FROM Autores a WHERE a.fechaFallecimiento > :fecha")
    List<Autores> buscarAutoresVivos(@Param("fecha") Integer fecha);


    @Query("SELECT l FROM Autores a JOIN a.libros l WHERE l.idiomas = :idioma")
    List<Libro> buscarLibrosPorIdioma(@Param("idioma") Idiomas idiomas);


    @Query("SELECT a FROM Autores a WHERE a.fechaNacimiento = :fecha")
    List<Autores> listarAutoresPorNacimiento(@Param("fecha") Integer fecha);


    @Query("SELECT a FROM Autores a WHERE a.fechaFallecimiento = :fecha")
    List<Autores> listarAutoresPorFallecimiento(@Param("fecha") Integer fecha);


    @Query("SELECT l FROM Autores a JOIN a.libros l ORDER BY l.numeroDescargas DESC")
    List<Libro> top10Libros();
}
