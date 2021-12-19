<%-- 
    Document   : nuevo
    Created on : 11 dic. 2021, 18:46:14
    Author     : miranda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>  
    </head>
    
    <body>
        <div class="container" >
            <h1 class="text-center" >Añadir Alumno</h1>
            <div class="row" >
                <form class="p-5" action="AlumnosController?accion=insert" method="post"  >
                    <div class="mb-3">  
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" >
                    </div>
                    <div class="mb-3">  
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" >
                    </div>
                    <div class="mb-3">  
                        <label for="mail" class="form-label">E-Mail</label>
                        <input type="text" class="form-control" id="mail" name="mail" >
                    </div>                   
                    <button type="submit" class="btn btn-primary">Añadir</button>
                </form>
                
            </div>
                        
        </div>
        
    </body>
</html>
