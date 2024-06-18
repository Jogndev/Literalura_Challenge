# Literalura_Challenge
Challenge del programa Oracle ONE que consiste en crear una aplicación de Consola que consuma la Api Gutendex y así obtener datos sobre libros

Literalura
Literalura es una aplicación para la gestión de libros y autores. Permite realizar búsquedas, listar libros y autores, así como filtrar autores vivos en un determinado año y listar libros por idioma.

Características
Buscar libro por título: Permite buscar libros por su título.
Listar libros registrados: Muestra todos los libros registrados en la base de datos.
Listar autores registrados: Muestra todos los autores registrados en la base de datos.
Listar autores vivos en un determinado año: Permite listar autores que estaban vivos en un año específico.
Listar libros por idioma: Muestra libros filtrados por su idioma.
Base de datos: Utiliza Hibernate para la interacción con la base de datos.
Instalación
Clona el repositorio:

bash
Copiar código
git clone https://github.com/tu-usuario/literalura.git
Navega al directorio del proyecto:

bash
Copiar código
cd literalura
Configura la base de datos en src/main/resources/application.properties:

properties
Copiar código
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
Compila y ejecuta la aplicación:

bash
Copiar código
./mvnw spring-boot:run
Uso
Después de iniciar la aplicación, se te presentará un menú en la consola con las siguientes opciones:

less
Copiar código
Elija la opción a través de su número:
1 - Buscar libro por título
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en un determinado año
5 - Listar libros por idioma
0 - Salir
Buscar libro por título
Introduce 1 y luego escribe el título del libro que deseas buscar.

Listar libros registrados
Introduce 2 para ver todos los libros registrados en la base de datos.

Listar autores registrados
Introduce 3 para ver todos los autores registrados en la base de datos.

Listar autores vivos en un determinado año
Introduce 4 y luego escribe el año para listar todos los autores que estaban vivos en ese año.

Listar libros por idioma
Introduce 5 y luego escribe el idioma para listar todos los libros en ese idioma.

Problemas Conocidos
Error de columna no existente: Asegúrate de que los nombres de columnas en las consultas coincidan con los nombres definidos en la base de datos. Ejemplo de error: no existe la columna «libro_idlibro».
Contribuciones
Las contribuciones son bienvenidas. Puedes abrir un issue o un pull request con tus sugerencias y mejoras.
