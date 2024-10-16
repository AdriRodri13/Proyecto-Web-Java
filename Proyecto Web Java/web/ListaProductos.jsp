
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
            </tr>
            
            <%for(Productos tempProd : productos){%>
            
            <tr>
                
                <td><%=tempProd.getnArt()%></td>
                <td><%=tempProd.getSeccion()%></td>
                <td><%=tempProd.getcArt()%></td>
                <td><%=tempProd.getFecha()%></td>
                <td><%=tempProd.getPrecio()%></td>
                <td><%=tempProd.getImportado()%></td>
                <td><%=tempProd.getpOrig()%></td>
                
                
            </tr>
            
            <%}%>
            
        </table>
            
        <div id="contenedorBoton">
            <input type="button" value="Insertar Registro" onclick="window.location.href='InsertarProducto.jsp'"/>
        </div>
        
    </body>
</html>
