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

/**
 *
 * @author miranda
 */
public class Auto {
    
    public static void main(String[] args){
        System.out.println("Prueba de Ingreso de Datos");
        
        //Consultar datos
        consultar();
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
}

