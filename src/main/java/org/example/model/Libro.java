package org.example.model;

public class Libro {
    public int libro_id;
    private String titulo;
    private String genero;
    private int autor_id; //clave foranea

    public Libro() {
    }

    public Libro(int libro_id, String titulo, String genero, int autor_id) {
        this.libro_id = libro_id;
        this.titulo = titulo;
        this.genero = genero;
        this.autor_id = autor_id;
    }

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "libro_id=" + libro_id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", autor_id=" + autor_id +
                '}';
    }
}
