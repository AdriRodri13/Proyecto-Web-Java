<%@page import="com.adriandeveloper.servlet.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style>
        table {
            width: 50%;
            margin: auto;
            border-collapse: collapse;
        }
        td {
            padding: 10px;
        }
        input, select {
            width: 100%;
        }
        h2 {
            text-align: center;
        }
        button {
            margin-top: 20px;
            display: block;
            width: 100%;
        }
    </style>
</head>
<%
Productos p = (Productos)request.getAttribute("Producto");
%>
<body>
    <h2>Formulario de Actualizacion de producto</h2>
    <form action="ControladorProductos" method="get">
        <input type="hidden" name="instruccion" value="actualizarBBDD"/>
        <input type="hidden" name="cArt" value="<%=p.getcArt()%>"/>
        <table border="1">
            <tr>
                <td><label for="seccion">Sección:</label></td>
                <td><input type="text" id="seccion" name="seccion" value="<%= p.getSeccion() %>" required></td>
            </tr>
            <tr>
                <td><label for="nArt">Nombre del Artículo:</label></td>
                <td><input type="text" id="nArt" name="nArt" value="<%= p.getnArt() %>" required></td>
            </tr>
            <tr>
                <td><label for="precio">Precio:</label></td>
                <td><input type="number" id="precio" name="precio" step="0.01" value="<%= p.getPrecio() %>" required></td>
            </tr>
            <tr>
                <td><label for="fecha">Fecha:</label></td>
                <td><input type="date" id="fecha" name="fecha" value="<%= p.getFecha() %>" required></td>
            </tr>
            <tr>
                <td><label for="importado">¿Importado?</label></td>
                <td>
                    <select id="importado" name="importado" required>
                        <option value="Si">Sí</option>
                        <option value="No">No</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="pOrig">País de Origen:</label></td>
                <td><input type="text" id="pOrig" name="pOrig" value="<%= p.getpOrig() %>" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Enviar</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
