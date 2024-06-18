package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query(value = "SELECT * FROM autores WHERE libro_id_Libro = ?1", nativeQuery = true)
    List<Autor> mostrarAutorSegunIdLibro(Long id);

    @Query(value = "SELECT * FROM autores", nativeQuery = true)
    List<Autor> mostrarAutores();

    @Query(value = "SELECT * FROM autores WHERE ano_nacimiento < ?1 AND ano_fallecimiento > ?1", nativeQuery = true)
    List<Autor> autoresVivosSegunRango(int ano);

}
