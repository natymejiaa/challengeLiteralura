package com.aluracursos.challengeLiteralura.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Idiomas idiomas;
    private Integer numeroDescargas;
    @ManyToOne
    private Autores autores;

    public Libro() {
    }

    public Libro(DatosLibros libro) {
        this.id = libro.id();
        this.titulo = libro.titulo();
        this.idiomas = Idiomas.fromString(libro.idiomas().stream().limit(1).findFirst().orElse(""));
        this.numeroDescargas = libro.numeroDescargas();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Idiomas getIdioma() {
        return idiomas;
    }

    public void setIdioma(Idiomas idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public Autores getAutor() {
        return autores;
    }

    public void setAutor(Autores autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Libro: " +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idioma=" + idiomas +
                ", número descargas=" + numeroDescargas +
                ", autor=" + autores;
    }
}

