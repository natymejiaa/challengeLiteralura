package com.aluracursos.challengeLiteralura.modelo;

public enum Idiomas {
    ES("es"),
    FR("fr"),
    EN("en"),
    PT("pt"),
    OTRO("otro");

    private final String idioma;


    Idiomas(String idioma) {
        this.idioma = idioma;
    }


    public String getIdioma() {
        return this.idioma;
    }


    public static Idiomas fromString(String text) {
        for (Idiomas idiomas : Idiomas.values()) {
            if (idiomas.idioma.equalsIgnoreCase(text)) {
                return idiomas;
            }
        }
        throw new IllegalArgumentException("No hay coincidencias con el texto " + text);
    }
}
