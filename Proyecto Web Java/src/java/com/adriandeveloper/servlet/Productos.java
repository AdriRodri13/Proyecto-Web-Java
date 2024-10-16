/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adriandeveloper.servlet;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Productos {
    private String cArt;
    private String seccion;
    private String nArt;
    private double precio;
    private String fecha;
    private String importado;
    private String pOrig;

    public Productos() {
    }

    public Productos(String seccion, String nArt, double precio, String fecha, String importado, String pOrig) {
        this.seccion = seccion;
        this.nArt = nArt;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.pOrig = pOrig;
    }

    public Productos(String cArt, String seccion, String nArt, double precio, String fecha, String importado, String pOrig) {
        this.cArt = cArt;
        this.seccion = seccion;
        this.nArt = nArt;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.pOrig = pOrig;
    }

    public String getcArt() {
        return cArt;
    }

    public void setcArt(String cArt) {
        this.cArt = cArt;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getnArt() {
        return nArt;
    }

    public void setnArt(String nArt) {
        this.nArt = nArt;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public String getpOrig() {
        return pOrig;
    }

    public void setpOrig(String pOrig) {
        this.pOrig = pOrig;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Productos{");
        sb.append("cArt=").append(cArt);
        sb.append(", seccion=").append(seccion);
        sb.append(", nArt=").append(nArt);
        sb.append(", precio=").append(precio);
        sb.append(", fecha=").append(fecha);
        sb.append(", importado=").append(importado);
        sb.append(", pOrig=").append(pOrig);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
