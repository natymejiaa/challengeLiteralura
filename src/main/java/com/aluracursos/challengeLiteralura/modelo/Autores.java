package com.aluracursos.challengeLiteralura.modelo;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "datos_autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;

    @OneToMany(mappedBy = "autores", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;


    public Autores() {
    }

    public Autores(String nombre) {
        this.nombre = nombre;
    }

    public Autores(DatosAutores datosAutores) {
        this.nombre = datosAutores.nombre();
        this.fechaNacimiento = datosAutores.fechaNacimiento();
        this.fechaFallecimiento = datosAutores.fechaFallecimiento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor: " +
                "id=" + id +
                ", Nombre='" + nombre + '\n' +
                ", Fecha nacimiento=" + fechaNacimiento +
                ", Fecha Fallecimiento=" + fechaFallecimiento;
    }
}