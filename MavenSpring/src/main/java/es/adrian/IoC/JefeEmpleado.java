/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.adrian.IoC;

/**
 *
 * @author Admin
 */
public class JefeEmpleado implements Empleados{
    
    private CreacionInformes informe;

    public JefeEmpleado(CreacionInformes informe) {
        this.informe = informe;
    }
    
    @Override
    public String getTareas(){
        return "Gestiono las cuestiones relativas a mis empleados de seccion";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el jefe: "+this.informe.getInforme();
    }
    
}
