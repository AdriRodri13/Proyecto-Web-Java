/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.adrian.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Admin
 */
public class UsoEmpleados {
    public static void main(String[] args){
        
        ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationcontext.xml");
        Empleados juan = contexto.getBean("miEmpleado",Empleados.class);
        System.out.println(juan.getTareas());
        System.out.println(juan.getInforme());
        contexto.close();
    }
}
