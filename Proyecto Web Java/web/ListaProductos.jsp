<%-- 
    Document   : ListaProductos
    Created on : 15 oct 2024, 18:11:48
    Author     : Admin
--%>
<%@page import = "java.util.*, com.adriandeveloper.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        
        //Obtener productos del controlador
        
        List<Productos> productos = (List<Productos>) request.getAttribute("LISTAPRODUCTOS");
        
    %>
    <body>
        
        <%= productos %>
        
    </body>
</html>
