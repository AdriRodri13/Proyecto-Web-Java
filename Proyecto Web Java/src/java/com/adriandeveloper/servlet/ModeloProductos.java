/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adriandeveloper.servlet;

import java.util.*;
import java.util.Date;
import javax.sql.DataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ModeloProductos {

    private DataSource datos;

    public ModeloProductos(DataSource datos) {
        this.datos = datos;
    }

    public List<Productos> getProductos() throws Exception {
        List<Productos> productos = new ArrayList<>();

        // La consulta SQL
        String sql = "SELECT * FROM PRODUCTOS";

        // try-with-resources garantiza que los recursos se cierran automáticamente
        try (Connection miConexion = datos.getConnection(); PreparedStatement miStatement = miConexion.prepareStatement(sql); ResultSet miResultSet = miStatement.executeQuery()) {

            // Recorrer el ResultSet y añadir los productos a la lista
            while (miResultSet.next()) {
                Productos producto = new Productos(
                        miResultSet.getString(1), // 1: código del artículo
                        miResultSet.getString(2), // 2: sección
                        miResultSet.getString(3), // 3: nombre del artículo
                        miResultSet.getDouble(4), // 4: precio
                        miResultSet.getString(5), // 5: fecha
                        miResultSet.getString(6),// 6: importado
                        miResultSet.getString(7) // 7: país de origen
                );
                productos.add(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de excepciones personalizado si es necesario
        }

        return productos;
    }
    
    public Productos getProducto(String cArt) throws Exception{
        String sql = "SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = ?";
        
        try(Connection conexion = datos.getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql)){
            consulta.setString(1, cArt);
            ResultSet rs = consulta.executeQuery();
            if(rs.next()){
                Productos producto = new Productos(
                        cArt, // 1: código del artículo
                        rs.getString(2), // 2: sección
                        rs.getString(3), // 3: nombre del artículo
                        rs.getDouble(4), // 4: precio
                        rs.getString(5), // 5: fecha
                        rs.getString(6),// 6: importado
                        rs.getString(7) // 7: país de origen
                );
                return producto;
            }
        }catch(SQLException ex){
            // Log the error
            Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, "Error en la inserción de datos", ex);

            // Detener la aplicación lanzando una excepción no chequeada
            throw new RuntimeException("Error en la inserción de datos", ex);
        }
        throw new Exception("No hemos encontrado el producto con el codigo" + cArt);
    }

    public void insertarProducto(Productos p) {
        String sql = "INSERT INTO productos (CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSDEORIGEN) VALUES (?,?,?,?,?,?,?)";

        try (Connection conexion = datos.getConnection(); PreparedStatement consulta = conexion.prepareStatement(sql)) {
            consulta.setString(1, p.getcArt());
            consulta.setString(2, p.getSeccion());
            consulta.setString(3, p.getnArt());
            consulta.setDouble(4, p.getPrecio());
            consulta.setString(5, p.getFecha());
            consulta.setString(6, p.getImportado());
            consulta.setString(7, p.getpOrig());
            consulta.execute();
        } catch (SQLException ex) {
            // Log the error
            Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, "Error en la inserción de datos", ex);

            // Detener la aplicación lanzando una excepción no chequeada
            throw new RuntimeException("Error en la inserción de datos", ex);
        }
    }
    
    public void actualizarProducto(Productos p){
        String sql ="UPDATE PRODUCTOS SET SECCIÓN=?,NOMBREARTÍCULO=?,PRECIO=?,"
                + "FECHA=?,IMPORTADO=?,PAÍSDEORIGEN=? WHERE CÓDIGOARTÍCULO=?";
        
        try(Connection conexion = datos.getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql)){
            consulta.setString(1, p.getSeccion());
            consulta.setString(2, p.getnArt());
            consulta.setDouble(3, p.getPrecio());
            consulta.setString(4, p.getFecha());
            consulta.setString(5, p.getImportado());
            consulta.setString(6, p.getpOrig());
            consulta.setString(7, p.getcArt());
            consulta.execute();
        }catch(SQLException ex){
            // Log the error
            Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, "Error en la inserción de datos", ex);

            // Detener la aplicación lanzando una excepción no chequeada
            throw new RuntimeException("Error en la inserción de datos", ex);
        }
    }

    public void eliminarProducto(String cArt) {
        
        String sql = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = ?";
        
        try(Connection conexion = datos.getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql)){
            consulta.setString(1,cArt);
            consulta.execute();
        }catch(SQLException ex){
            // Log the error
            Logger.getLogger(ModeloProductos.class.getName()).log(Level.SEVERE, "Error en la inserción de datos", ex);

            // Detener la aplicación lanzando una excepción no chequeada
            throw new RuntimeException("Error en la inserción de datos", ex);
        }
    }

}
