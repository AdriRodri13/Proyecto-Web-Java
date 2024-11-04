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
    
    
    
    @Override
    public String getTareas() {
       return "Gestionar plantilla de la empresa";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el director: "+this.informe.getInforme();
    }
    
}
