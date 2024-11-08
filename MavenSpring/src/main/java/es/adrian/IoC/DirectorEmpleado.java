/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.adrian.IoC;

/**
 *
 * @author Admin
 */
public class DirectorEmpleado implements Empleados{

    private CreacionInformes informe;

    public DirectorEmpleado(CreacionInformes informe) {
        this.informe = informe;
    }
    
    private CreacionInformes informeNuevo;
    
    private String email;
    
    private String nombreEmpresa;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public CreacionInformes getInformeNuevo() {
        return informeNuevo;
    }

    public void setInformeNuevo(CreacionInformes informeNuevo) {
        this.informeNuevo = informeNuevo;
    }
    
    
    @Override
    public String getTareas() {
       return "Gestionar plantilla de la empresa";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el director: "+this.informe.getInforme();
    }
    
}
