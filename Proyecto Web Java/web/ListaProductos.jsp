
<%@page import="java.net.URLEncoder"%>
<%@page import = "java.util.*, com.adriandeveloper.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                display: flex;
                flex-direction: row;
                align-items: start;
                gap: 20px;
            }
        </style>
    </head>
    <%List<Productos> productos = (List<Productos>) request.getAttribute("LISTAPRODUCTOS");%>
    <body>

        <table border="1">

            <tr>
                <th>Codigo</th>
                <th>Seccion</th>
                <th>Nombre</th>
                <th>Fecha</th>
                <th>Precio</th>
                <th>Importado</th>
                <th>Pais de origen</th>
                <th>Accion</th>
            </tr>

            <%for (Productos tempProd : productos) {%>

            <%
                // Supongamos que tienes un objeto tempProd disponible
                String baseUrl = "ControladorProductos";
                String instruccion = "cargar";
                String instruccion2 = "eliminar";
                String cArticulo = tempProd.getcArt(); // Obtener el nombre del artículo
                
                // Construir la URL completa con parámetros
                String linkTemp = String.format("%s?instruccion=%s&CArticulo=%s", baseUrl, instruccion, URLEncoder.encode(cArticulo, "UTF-8"));
                String linkElim = String.format("%s?instruccion=%s&CArticulo=%s", baseUrl, instruccion2, URLEncoder.encode(cArticulo,"UTF-8"));
            %>
            <tr>

                <td><%=tempProd.getcArt()%></td>
                <td><%=tempProd.getSeccion()%></td>
                <td><%=tempProd.getnArt()%></td>
                <td><%=tempProd.getFecha()%></td>
                <td><%=tempProd.getPrecio()%></td>
                <td><%=tempProd.getImportado()%></td>
                <td><%=tempProd.getpOrig()%></td>
                <td><a href="<%= linkTemp %>">Actualizar</a>&nbsp;&nbsp;&nbsp;<a href="<%= linkElim %>">Eliminar</a></td>


            </tr>

            <%}%>

        </table>

        <div id="contenedorBoton">
            <input type="button" value="Insertar Registro" onclick="window.location.href = 'InsertarProducto.jsp'"/>
        </div>

    </body>
</html>
