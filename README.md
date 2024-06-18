# Literalura_Challenge
Challenge del programa Oracle ONE que consiste en crear una aplicación de Consola que consuma la Api Gutendex y así obtener datos sobre libros

<h1>Literalura</h1>
Literalura es una aplicación para la gestión de libros y autores. Permite realizar búsquedas, listar libros y autores, así como filtrar autores vivos en un determinado año y listar libros por idioma.
<br/>
<h2>Características</h2
<br/>
<ul>
<li>Buscar libro por título: Permite buscar libros por su título.</li>
<li>Listar libros registrados: Muestra todos los libros registrados en la base de datos.</li>
<li>Listar autores registrados: Muestra todos los autores registrados en la base de datos.</li>
<li>Listar autores vivos en un determinado año: Permite listar autores que estaban vivos en un año específico.</li>
<li>Listar libros por idioma: Muestra libros filtrados por su idioma.</li>
<li>Base de datos: Utiliza Hibernate para la interacción con la base de datos.</li>
</ul>
<h2>Instalación</h2>
<ol>
<li>Clona el repositorio:
<br/>
git clone https://github.com/tu-usuario/literalura.git</li>
<li>
Navega al directorio del proyecto:
  <br/>
  cd literalura
</li>
<li>
Configura la base de datos en src/main/resources/application.properties:
  <br/>
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_base_de_datos
  <br/>
spring.datasource.username=tu_usuario
  <br/>
spring.datasource.password=tu_contraseña
  <br/>
spring.jpa.hibernate.ddl-auto=update
  </li>
  <br/>
  <li>
Compila y ejecuta la aplicación:
<br/>
./mvnw spring-boot:run
</li>
</ol>

<h2>Uso</h2>
Después de iniciar la aplicación, se te presentará un menú en la consola con las siguientes opciones:
<br/>
Elija la opción a través de su número:<br/>
1 - Buscar libro por título<br/>
2 - Listar libros registrados<br/>
3 - Listar autores registrados<br/>
4 - Listar autores vivos en un determinado año<br/>
5 - Listar libros por idioma<br/>
0 - Salir<br/>
<ul>
<li>Buscar libro por título<br/>
Introduce 1 y luego escribe el título del libro que deseas buscar.<br/>
</li>
<li>Listar libros registrados<br/>
Introduce 2 para ver todos los libros registrados en la base de datos.<br/>
</li>
<li>Listar autores registrados<br/>
Introduce 3 para ver todos los autores registrados en la base de datos.<br/>
</li>
<li>Listar autores vivos en un determinado año<br/>
Introduce 4 y luego escribe el año para listar todos los autores que estaban vivos en ese año.<br/>
</li>
<li>Listar libros por idioma<br/>
Introduce 5 y luego escribe el idioma para listar todos los libros en ese idioma.<br/>
  </li>
</ul>
<h2>Problemas Conocidos</h2><br/>
Error de columna no existente: Asegúrate de que los nombres de columnas en las consultas coincidan con los nombres definidos en la base de datos. Ejemplo de error: no existe la columna «libro_idlibro».
<h2>Contribuciones</h2><br/>
Las contribuciones son bienvenidas. Puedes abrir un issue o un pull request con tus sugerencias y mejoras.
