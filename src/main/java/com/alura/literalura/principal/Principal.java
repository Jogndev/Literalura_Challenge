package com.alura.literalura.principal;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.DatosBusqueda;
import com.alura.literalura.model.DatosLibro;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConsumoApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ObjectMapper objectMapper = new ObjectMapper();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void ejecutarApp() throws JsonMappingException, JsonProcessingException {
        int salir = 1;
        int opcionMenu;

        while (salir != 0) {
            opcionMenu = mostrarMenu();

            switch (opcionMenu) {
                case 0:
                    System.out.println("Saliendo...");
                    salir = 0;
                    break;
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    mostrarLibrosRegistrados();
                    break;
                case 3:
                    mostrarAutoresRegistrados();
                    break;
                case 4:
                    mostrarAutoresVivosSegunRango();
                    break;
                case 5:
                    mostrarLibrosSegunIdioma();
                    break;
                default:
                    System.out.println("Vaya, algo parece no funcionar");
                    break;
            }
        }
    }

    private int mostrarMenu() {
        int menu = 0;
        while (true) {
            System.out.println(
                    """
                                        Elija la opción a traves de su numero:
                                        1 - Buscar libro por titulo
                                        2 - Listar libros registrados
                                        3 - Listar autores registrados
                                        4 - Listar autores vivos en un determinado año
                                        5 - Listar libros por idioma
                                        0 - Salir
                                        """
            );
            try {
                menu = scanner.nextInt();
                if (menu >= 0 && menu <= 5) {
                    break;
                } else {
                    System.out.println("\nOpción incorrecta");
                }
            } catch (Exception e) {
                System.out.println("\nLa opción es invalida");
                scanner.next();
            }
        }
        return menu;
    }

    private void mostrarLibrosSegunIdioma() {
        System.out.println("""
                Escriba las iniciales del idioma a buscar:
                            en - ingles
                            es - español
                            fr - frances
                            fi - finlandes
                            pt - portugues
                """);
        String idioma = scanner.next().toLowerCase();
        var libros = libroRepository.libroSegunIdioma(idioma);
        if (libros.isEmpty()) {
            System.out.println("No hay libros en ese idioma registrados en la base de datos");
        } else {
            libros.stream().forEach(l -> l.setAuthors(autorRepository.mostrarAutorSegunIdLibro(l.getId())));
            System.out.println(libros);
        }
    }

    private void mostrarLibrosRegistrados() {
        var libros = libroRepository.mostrarLibros();
        libros.stream().forEach(l -> l.setAuthors(autorRepository.mostrarAutorSegunIdLibro(l.getId())));
        System.out.println(libros);
    }

    private void buscarLibroPorTitulo() throws JsonMappingException, JsonProcessingException {
        System.out.println("Ingrese el titulo del libro a buscar");
        String titulo = scanner.next();

        String url = "https://gutendex.com/books/?search=" + titulo.toLowerCase().replace(" ", "%20");
        String json = ConsumoApi.obtenerDatos(url);

        DatosBusqueda data = objectMapper.readValue(json, DatosBusqueda.class);

        if (data.numeroDeResultados() == 0) {
            System.out.println("No se ha encontrado un libro con ese título");
        } else {
            List<DatosLibro> datosLibro = data.resultados();

            for (DatosLibro libro : datosLibro) {
                var existente = libroRepository.encontrarLibroExistiendo(libro.id());

                if (existente.isEmpty()) {
                    Libro libroGuardable = new Libro(libro);
                    List<Autor> autorGuardable = libro.autores().stream().map(a -> new Autor(a)).collect(Collectors.toList());

                    libroGuardable.setAuthors(autorGuardable);
                    autorGuardable.forEach(a -> a.setLibro(libroGuardable));

                    System.out.println("El resultado de la búsqueda es: \n" + libroGuardable);
                    libroRepository.save(libroGuardable);
                    autorRepository.saveAll(autorGuardable);
                } else {
                    System.out.println("El libro fue buscado y está registrado");
                }
            }
        }
    }

    private void mostrarAutoresVivosSegunRango() {
        try {
            System.out.println("Ingrese el año: ");
            int ano = scanner.nextInt();
            var autores = autorRepository.autoresVivosSegunRango(ano);
            if (autores.isEmpty()) {
                System.out.println("No se encontraron autores vivos durante ese año en la base de datos");
            } else {
                System.out.println(autores);
            }
        } catch (Exception e) {
            System.out.println("La fecha ingresada no es válida");
        }
    }

    private void mostrarAutoresRegistrados() {
        var autores = autorRepository.mostrarAutores();
        System.out.println(autores);
    }
}
