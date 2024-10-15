/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adriandeveloper.servlet;

import java.util.*;
import java.util.Date;
import javax.sql.DataSource;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class ModeloProductos {
    
    
    private DataSource datos;

    public ModeloProductos(DataSource datos) {
        this.datos = datos;
    }
    
     public List<Productos> getProductos() throws Exception{
        List<Productos> productos = new ArrayList<>();

        // La consulta SQL
        String sql = "SELECT * FROM PRODUCTOS";

        // try-with-resources garantiza que los recursos se cierran automáticamente
        try (Connection miConexion = datos.getConnection();
             PreparedStatement miStatement = miConexion.prepareStatement(sql);
             ResultSet miResultSet = miStatement.executeQuery()) {

            // Recorrer el ResultSet y añadir los productos a la lista
            while (miResultSet.next()) {
                Productos producto = new Productos(
                    miResultSet.getString(1),    // 1: código del artículo
                    miResultSet.getString(2),  // 2: sección
                    miResultSet.getString(3),    // 3: nombre del artículo
                    miResultSet.getDouble(4),   // 4: precio
                    miResultSet.getDate(5),      // 5: fecha
                    miResultSet.getString(6),// 6: importado
                    miResultSet.getString(7)    // 7: país de origen
                );
                productos.add(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de excepciones personalizado si es necesario
        }

        return productos;
    }
    
}