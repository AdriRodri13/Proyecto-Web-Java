/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.adriandeveloper.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 *
 * @author Admin
 */
@WebServlet(name = "ControladorProductos", urlPatterns = {"/ControladorProductos"})
public class ControladorProductos extends HttpServlet {
    
    private ModeloProductos modeloProductos;
    
    @Resource(name="jdbc/Productos")
    private DataSource pool;

    @Override
    public void init() throws ServletException {
        super.init();
        modeloProductos = new ModeloProductos(pool);
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        List<Productos> productos;
        try {
            //obtener la lista de productos
            productos = modeloProductos.getProductos();
            //Agregar la lista al request
            request.setAttribute("LISTAPRODUCTOS", productos);
            //Enviar ese request a la vista
            RequestDispatcher rd = request.getRequestDispatcher("/ListaProductos.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       
    }

    

}
