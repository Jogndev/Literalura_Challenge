package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @Column(name = "idLibro", nullable = false, unique = true)
    private Long id;
    @Column(name="titulo")
    private String title;
    @OneToMany(mappedBy = "libro", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Autor> authors;
    @Column(name = "idioma")
    private String language;
    @Column(name = "descargas")
    private Double download_count;

    public Libro() {}

    public Libro(DatosLibro datosLibro) {
        this.id = datosLibro.id();
        this.title = datosLibro.titulo();
        this.language = datosLibro.idiomas().toString();
        this.download_count = (double) datosLibro.descargas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        authors.forEach(a -> a.setLibro(this));
        this.authors = authors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(List<String> languages) {
        this.language = languages.toString();
    }

    public Double getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Double download_count) {
        this.download_count = download_count;
    }

    @Override
    public String toString() {
        return "\nTitulo: " + title + "\nAutores: " + authors + "\nIdioma: " + language + "\nDescargas: " + download_count + "\n******";
    }
}
