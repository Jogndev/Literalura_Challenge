package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutor", nullable = false, unique = true)
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "AnoNacimiento")
    private int birth_year;
    @Column(name = "AnoFallecimiento")
    private int death_year;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "idLibro")
    private Libro libro;

    public Autor() {}

    public Autor(DatosAutor datosAutor) {
        this.name = datosAutor.nombre();
        this.birth_year = datosAutor.anonacimiento();
        this.death_year = datosAutor.anofallecimiento();
    }

    public Long getId_author() {
        return id;
    }

    public void setId_author(Long id_author) {
        this.id = id_author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Año de nacimiento: " + birth_year + ", Año de fallecimiento: " + death_year + "\n******";
    }
}
