# Java-Backend
Programa Codo a Codo

<h2>Crud Consola</h2>
CLASE 29
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


<h2>Crud Web</h2>

Creación de proyecto Web,según un padrón de diseño de Software que se llama MVC (Modelo Vista Controlador).
Separa la información en distintas capas: en la vista tendremos el diseño y la presentación, lo que se mostrará.
Por otro lado tenemos el Modelo, que es la estructura de datos y la logica.
Por último, tendremos un Controlador (Enrutador) que coordinará la acciones entre la vista y el modelo.
En el modelo se armarán todas las clases que voy a necesitar, por otro lado armaré las vistas que serian las páginas que voy a usar.
Y el controlar hará la función de conectar los datos, pasándolos de un lado al otro.

Cuando se crea un proyecto nuevo, ya les viene armado para programar con este patrón.

Pasos a seguir:
<ol>
  <li> New Proyect -> Java with Maven -> Web Application -> CrudWeb<br>
  Package características de Maven.
  </li>
  
  <li>Usar Maven sin usar NetBeans: 
    Ingreso a "Maven" ->download -> "apache-maven-3.3" -> Comando "mvm -v" para saber si esta instalada.
    Maven vive y existe dentro de la carpeta donde esta, para poder usarla fuera se tiene que configurar las variables de entorno del sistema.
    <br> En Windows: Propiedades del sistema -> Variables de entorno -> Agrego Maven a Path.
    Esto hace que sea público para todo el sistema.
    Crear proyecto Maven por consola : >>>mvm archetype:generate -> 1 -> version 3 -> nombre del proyecto.
  </li>
  
  <li>
    Creo 
  </li>
</ol>




