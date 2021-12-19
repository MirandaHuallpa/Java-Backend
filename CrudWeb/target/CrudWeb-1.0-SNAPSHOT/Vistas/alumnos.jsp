<%-- 
    Document   : alumnos
    Created on : 11 dic. 2021, 18:43:57
    Author     : miranda
--%>

<%@page import = "modelo.AlumnosDAO"%>
<%@page import = "java.util.List"%>
<%@page import = "modelo.Alumnos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>  
        <script src="https://kit.fontawesome.com/98f136dd0a.js" crossorigin="anonymous"></script>
    </head>
    
    <body>
        <h1>Listado de Alumnos</h1>
        <div class="container">
            <div class="row">
                <a class="btn btn-primary col-4 m-4" href="AlumnosController?accion=nuevo">Agregar Alumno</a>
                
                <table class="table table-primary">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>E-mail</th>
                            <th class="text-center">Modificar</th>
                            <th class="text-center">Eliminar</th>
                        </tr>
                    </thead>
                    
                    <%
                    List<Alumnos> resultado = null;
                    AlumnosDAO alumno = new AlumnosDAO();
                    resultado = alumno.listarAlumnos();
                    
                    for(int i=0; i < resultado.size(); i++){
                       String ruta = "AlumnosController?accion=modificar&id="+resultado.get(i).getId();
                       String rutaE = "AlumnosController?accion=eliminar&id="+resultado.get(i).getId();
                    %>
                    
                    <tr>
                        <td><%=resultado.get(i).getId()%></td>
                        <td><%=resultado.get(i).getNombre()%></td>
                        <td><%=resultado.get(i).getApellido()%></td>
                        <td><%=resultado.get(i).getMail()%></td>
                        <td class="text-center"><a class="text-success" href=<%=ruta%>><i class="fas fa-user-check"></i></a> </td>
                        <td class="text-center"><a class="text-success" href=<%=rutaE%>><i class="far fa-calendar-times"></i></a> </td>                       
                    </tr>
                    <%
                        }
                    %>
                    
                </table>
            </div>
        </div>
        
    </body>
</html>
