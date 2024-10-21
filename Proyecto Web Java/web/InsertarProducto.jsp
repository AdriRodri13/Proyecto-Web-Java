<%-- 
    Document   : InsertarProducto
    Created on : 16 oct 2024, 22:25:52
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Artículo</title>
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
<body>
    <h2>Formulario de Registro de Artículo</h2>
    <form action="ControladorProductos" method="get">
        <input type="hidden" name="instruccion" value="insertarBBDD"/>
        <table border="1">
            <tr>
                <td><label for="cArt">Código de Artículo:</label></td>
                <td><input type="text" id="cArt" name="cArt" required></td>
            </tr>
            <tr>
                <td><label for="seccion">Sección:</label></td>
                <td><input type="text" id="seccion" name="seccion" required></td>
            </tr>
            <tr>
                <td><label for="nArt">Nombre del Artículo:</label></td>
                <td><input type="text" id="nArt" name="nArt" required></td>
            </tr>
            <tr>
                <td><label for="precio">Precio:</label></td>
                <td><input type="number" id="precio" name="precio" step="0.01" required></td>
            </tr>
            <tr>
                <td><label for="fecha">Fecha:</label></td>
                <td><input type="date" id="fecha" name="fecha" required></td>
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
                <td><input type="text" id="pOrig" name="pOrig" required></td>
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

