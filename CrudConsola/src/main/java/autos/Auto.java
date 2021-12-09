/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autos;

import org.mariadb.jdbc.internal.util.exceptions.MariaDbSqlException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author miranda
 */
public class Auto {
    
    public static void main(String[] args){
        System.out.println("Prueba de Ingreso de Datos");
        
        int opc = 0;
        String patenteNumero;
        boolean patenteActiva;
        String marca;
        String categoria;
        String color;
        Scanner sc = new Scanner(System.in);
        
        do{
            do {
                System.out.println("1.-Ver Datos");
                System.out.println("2.-Ingresar");
                System.out.println("3.-Modificar");
                System.out.println("4.-Eliminar");
                System.out.println("5.-Salir");
                System.out.println("");
                System.out.println("Ingresar opción: ");
                opc = sc.nextInt();
                
            }while (opc < 0 || opc > 6);
        
            switch(opc){
                case 1:
                    consultar();
                    break;
                case 2:
                    System.out.println("Ingresar Chapa Patente:");
                    patenteNumero = sc.next();
                    patenteActiva = false;
                    System.out.println("Ingresar Marca:");
                    marca = sc.next();
                    System.out.println("Ingresar Categoria:");
                    categoria = sc.next();
                    System.out.println("Ingresar Color:");
                    color = sc.next();
                    insertar(patenteNumero,patenteActiva,marca,categoria,color);
                    break;
                case 3:
                    actualizar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    System.out.println("Gracias por usar la aplicación");
                    break;
            }
            
        }while (opc != 5);
        
    }
    
    private static Connection conectarBaseDeDatos()throws SQLException{
        Connection conexion = null;
        try{
            String driver = "org.mariadb.jdbc.Driver";
            String url = "jdbc:mariadb://localhost:3306/javacac";
            String usuario = "root";
            String clave = "";
            conexion = DriverManager.getConnection(url,usuario,clave);
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return conexion;
    }
    
    private static void consultar(){
        try{
            Connection conexion = conectarBaseDeDatos();
            String sql = "select * from autofamiliar";
            Statement querry = conexion.createStatement();
            ResultSet resultado = querry.executeQuery(sql);
            
            System.out.println("Inicio");
            
            while(resultado.next()){
                System.out.print(resultado.getString("patenteNumero")+"|");
                System.out.print(resultado.getBoolean("patenteActiva")+"|");
                System.out.print(resultado.getString("marca")+"|");
                System.out.print(resultado.getString("categoria")+"|");
                System.out.println(resultado.getString("color")+"|");
            }
            
            System.out.println("Fin");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
            
    }
    
    public static void insertar(String patente, boolean pa, String marca, String categoria, String color){
        try{
            Connection conexion = conectarBaseDeDatos();
            String sql = "INSERT INTO autofamiliar(patenteNumero,patenteActiva,marca,categoria,color)"
                    +"VALUES ('"+patente+"',"+pa+",'"+marca+"','"+categoria+"','"+color+"')";
            Statement querry = conexion.createStatement();
            querry.execute(sql);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void eliminar(){
        try{
            Connection conexion = conectarBaseDeDatos();
            String sql = "DELETE FROM autofamiliar WHERE patenteNumero = 'ABC 100'";
            Statement querry = conexion.createStatement();
            querry.execute(sql);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void actualizar() {
        try{
            Connection conexion = conectarBaseDeDatos();
            String sql = "UPDATE autofamiliar SET patenteActiva=0 WHERE patenteActiva=1";
            Statement querry = conexion.createStatement();
            querry.execute(sql);
        }
        catch (Exception ex){
            ex.getMessage();
        }
    }
}

