package com.alura.literalura.repository;

import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query(value = "SELECT id_Libro FROM libros WHERE id_libro = ?1", nativeQuery = true)
    Optional<Long> encontrarLibroExistiendo(Long id);

    @Query(value = "SELECT * FROM libros", nativeQuery = true)
    List<Libro> mostrarLibros();

    @Query(value = "SELECT * FROM libros WHERE idioma = ?1", nativeQuery = true)
    List<Libro> libroSegunIdioma(String idioma);
}
