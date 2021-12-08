/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad_practica_obligatoria1;
import java.util.Scanner;

/**
 *
 * @author miranda
 */
public class Actividad_practica_obligatoria1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        
        System.out.println("Ingrese su nombre:");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese su apellido:");
        String apellido = sc.nextLine();
        
        System.out.println("Ingrese su hobbie:");
        String hobbie = sc.nextLine();
        
        System.out.println("Ingrese su editor de texto favorito:");
        String editorTexto = sc.nextLine();
        
        System.out.println("Ingrese el nombre del sistema operativo que utiliza más:");
        String sistemaOperativo = sc.nextLine();
        
        System.out.println("Ingrese su edad:");
        int edad = sc.nextInt();
        
        System.out.println("Mi nombre es "+nombre+" "+apellido +" y tengo "+edad+" años.");
        System.out.println("Y mi hobbie es "+hobbie+".");
        System.out.println("Por último, mi editor de texto favorito y el sistema operativo que más uso son "+editorTexto+" y "+sistemaOperativo+",respectivamente.");
            
    }
    
}
