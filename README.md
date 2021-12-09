# Java-Backend
Programa Codo a Codo

<h2>Crud Consola</h2>

Creación de proyecto en Apache NetBeans con Java with Maven y Java Application.

Maven es un gestor de proyectos, que nos permite generar proyectos donde se pueda bajar o nombrar las <b>dependencias</b> que se usarán.
En éste proyecto se usará MySQL conector para conectarnos a la base de datos, así como también MariaDB.
Con Maven nos podemos olvidar de las compatibilidades de librerías.

<ul>
  <li>En el proyecto -> Proyect Files -> pom.xml <br>
      Creo la etiqueta dependencias y agrego de la página "Maven repository", el código de Maven.</li>
  <li>En Source Package -> New Class -> "Auto.java" creo una clase Auto. </li>
  <li>En Auto.java importo: <br>
    import java.sql.Connection;<br>
    import java.sql.DriverManager;<br>
    import java.sql.SQLException;<br>
    import java.sql.*;<br>
</ul>



