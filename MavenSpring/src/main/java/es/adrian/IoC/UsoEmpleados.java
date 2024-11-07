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
        
        try (ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationcontext2.xml")
//        Empleados juan = contexto.getBean("miEmpleado",Empleados.class);
//        System.out.println(juan.getTareas());
//        System.out.println(juan.getInforme());
        ) {
            SecretarioEmpleado maria = contexto.getBean("miSecretarioEmpleado",SecretarioEmpleado.class);
            System.out.println(maria.getTareas());
            System.out.println(maria.getInforme());
            System.out.println(maria.getEmail());
            System.out.println(maria.getNombreEmpresa());
        }
    }
}
