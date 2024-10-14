/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.adriandeveloper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.*;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ServletPruebas", urlPatterns = {"/ServletPruebas"})
public class ServletPruebas extends HttpServlet {

    @Resource(name="jdbc/Productos")
    private DataSource miPool;
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        PrintWriter salida = response.getWriter();
        
        response.setContentType("text/plain");
        
        Connection conexion = null;
        
        Statement miStatement = null;
        
        ResultSet miResultset = null;
        
        try{
            conexion=miPool.getConnection();
            String miSql="SELECT * FROM PRODUCTOS";
            miStatement = conexion.createStatement();
            miResultset = miStatement.executeQuery(miSql);
            while(miResultset.next()){
                String nombre = miResultset.getString(3);
                salida.println(nombre);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
    }

   

}
