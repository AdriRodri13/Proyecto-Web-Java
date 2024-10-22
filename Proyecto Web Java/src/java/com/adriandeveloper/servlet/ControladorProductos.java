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

    @Resource(name = "jdbc/Productos")
    private DataSource pool;

    @Override
    public void init() throws ServletException {
        super.init();
        modeloProductos = new ModeloProductos(pool);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String comando = request.getParameter("instruccion");
        if(comando == null){
            comando = "listar";
        }
        switch (comando) {
            case "insertarBBDD" ->
                insertarProducto(request, response);
            case "cargar" ->
                cargarProducto(request,response);
            case "actualizarBBDD" ->
                actualizarProducto(request,response);
            case "eliminar" ->
                eliminarProducto(request,response);
            default ->
                listarProductos(request, response);
        }

        listarProductos(request, response);

    }

    private void insertarProducto(HttpServletRequest request, HttpServletResponse response) {
        // Obtener parámetros del formulario
        String codArticulo = request.getParameter("cArt");
        String seccion = request.getParameter("seccion");
        String nombreArticulo = request.getParameter("nArt");
        String precio = request.getParameter("precio");
        String fecha = request.getParameter("fecha");
        String importado = request.getParameter("importado");
        String paisOrigen = request.getParameter("pOrig");

        // Procesar los valores (por ejemplo, convertir tipos de datos si es necesario)
        double precioDouble = Double.parseDouble(precio);
        
        Productos p = new Productos(codArticulo,seccion,nombreArticulo,precioDouble,fecha,importado,paisOrigen);
        
        modeloProductos.insertarProducto(p);
        
        this.listarProductos(request,response);
    }
    
    private void cargarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String codigoArticulo = request.getParameter("CArticulo");
        Productos p = null;
        try {
            p = modeloProductos.getProducto(codigoArticulo);
        } catch (Exception ex) {
            throw new RuntimeException("Error en la inserción de datos", ex);
        }
        request.setAttribute("Producto", p);
        RequestDispatcher d = request.getRequestDispatcher("/actualizarProducto.jsp");
        d.forward(request, response);
    }
    
    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Obtener parámetros del formulario
        String codArticulo = request.getParameter("cArt");
        String seccion = request.getParameter("seccion");
        String nombreArticulo = request.getParameter("nArt");
        String precio = request.getParameter("precio");
        String fecha = request.getParameter("fecha");
        String importado = request.getParameter("importado");
        String paisOrigen = request.getParameter("pOrig");

        // Procesar los valores (por ejemplo, convertir tipos de datos si es necesario)
        double precioDouble = Double.parseDouble(precio);
        
        Productos p = new Productos(codArticulo,seccion,nombreArticulo,precioDouble,fecha,importado,paisOrigen);
        
        modeloProductos.actualizarProducto(p);
        
        this.listarProductos(request, response);
    }

    private void listarProductos(HttpServletRequest request, HttpServletResponse response) {
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
    
    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response){
        String cArt = request.getParameter("CArticulo");
        
        modeloProductos.eliminarProducto(cArt);
    }

}
