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
    En Web Pages -> New Folder -> nombre: "Vistas"
    Dentro de la carpeta "Vistas" creo tres archivos: New -> JSP -> alumnos.jsp, nuevo.jsp, modificar.jsp.
    Van a tener porciones de código en Java, usando <% %>. Lo que este afuera es código HTML.
  </li>
  <li>
    Creo 3 nuevos paquetes en Source Package -> New -> New Java Package: config, modelo y controlador.
    En Config crearé una clase Java Class -> Conexion.java.
    En Modelo creo tres clases: Alumnos.java, AlumnosDAO.java (Data Access Object)
    En el package crear sevrlet: AlumnosController.
    MIN 46:52
  </li>
  <li>
    Dentro del package en controlador, añado un servlet llamado AlumnosController.
    Que lo que hara es rediridirlo a otra pagina como en las Vistas que creamos anteriormente.
  </li>
</ol>

En config -> Conexion.java escribir el siguiente codigo:

```
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author miranda
 */
public class Conexion {
    
    public String driver = "com.mysql.jdbc.Driver";
    
    
    public Connection getConnection(){
        
        Connection conexion = null;
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudweb","root","");
        }
        catch (ClassNotFoundException|SQLException e){
            System.out.println(e.toString());
        }
        return conexion;
    }
    
}
```

En modelos -> Alumnos.java escribir el siguiente código:

```
public class Alumnos {
    private int id;
    private String nombre;
    private String apellido;
    private String mail;
    
    public Alumnos (int id, String nombre, String apellido, String mail){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
```

En Proyect Files -> pom.xml añado la dependencia de MySQL con la versión que más desragas tenga, 8.0.27

```
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.27</version>
</dependency>
```
<h3>Clase 32 </h3>
En el Source Package -> modelo -> Alumnos.java
Creo la clase con los 4 que la componen (id,nombre,apelllido,mail) que va a tener también el méstodo constructor.
Esto sirve para que cada vez que creemos un metodo de la clase alumnos, lo creemos si o si, con estos componentes.
Como las propiedades de la clase alumnos son privadas, tenemos que crear los getset, para poder a esas propiedades.
Click derecho -> insert code -> getters y setters

AlumnosDao:
Va a instanciar un nuevo objeto en la clase alumno pero a su vez, va a crear una conexión con la base de datos.
Va a crear todos los métodos para que pueda utilizar esa conexión a la base de datos con los métodos que ya conocemos y
del proyecto anterior, que seria, "listarAlumnos()", "mostrarAlumno()", 

```
import com.mysql.cj.xdevapi.PreparableStatement;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author miranda
 */
public class AlumnosDAO {
    
    Connection conexion;
    
    public AlumnosDAO() {
        Conexion con = new Conexion();
        conexion = con.getConnection();
    }
    
    public List<Alumnos> listarAlumnos() {
        PreparedStatement ps;
        ResultSet rs;
        List<Alumnos> lista = new ArrayList();
        
        try{
            ps = conexion.prepareStatement("SELECT * FROM alumnos");
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                Alumnos alumnnos = new Alumnos(id,nombre,apellido,mail);
            }
            return lista; 
        }
        catch(SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public Alumnos mostrarAlumno(int _id) {
        PreparedStatement ps;
        ResultSet rs;
        Alumnos alumno = null;
        
        try {
            ps = conexion.prepareStatement("SELECT * FROM alumnos WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                alumno = new Alumnos(id,nombre,apellido,mail);
            }
            return alumno;
        }
        catch (SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    public boolean insertarAlumno(Alumnos alumno){
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("INSERT INTO alumnos(nombre,apellido,mail) VALUES (?,?,?)");
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getMail());
            ps.execute();
            return true;
        }
        catch (SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean actualizarAlumno(Alumnos alumno){
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("UPDATE alumnos SET nombre = ?,apellido=?,mail=?");
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getMail());
            ps.setInt(4, alumno.getId());
            ps.execute();
            return true;  
        }
        catch (SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean eliminarAlumno(int _id){
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("DELETE FROM alumno WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            return true;  
        }
        catch (SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
}
```

