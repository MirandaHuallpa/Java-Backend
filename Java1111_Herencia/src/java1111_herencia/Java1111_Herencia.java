/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java1111_herencia;

/**
 *
 * @author miranda
 */
public class Java1111_Herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona p1 = new Persona();
        p1.apellido = "Fernandez";
        p1.nombre = "Nicolas";
        p1.mail = "njdnn";
        p1.edad = 40;
        
        PersonaDetalle pd1 = new PersonaDetalle();
        pd1.celular = "1165397113";
        pd1.apellido = "Hernandez";
        pd1.nombre = "Mario";
        pd1.mail = "hdjdjd";
        
        Empleado e1 = new Empleado();
        e1.legajo = 124;
        e1.puesto = "Programador";
        e1.celular = "hdssjjj";
        e1.edad = 45;
         
    }
    
}
