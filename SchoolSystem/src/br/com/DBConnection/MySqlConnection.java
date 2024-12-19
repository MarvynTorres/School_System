/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    public static String status = "Não conectou...";
    
    public static java.sql.Connection getMySqlConnection(){
        Connection connection = null;
        
        try{
            String driverName = "com.mysql.jbdc.Driver";
            Class.forName(driverName);
            
            String serverName = "localhost";
            String myDataBase = "mysql";
            String url = "jdbc:mysql://" + serverName + "/" + myDataBase;
            String username = "admin";
            String dbPassword = "admin123";
            connection = DriverManager.getConnection(url, username, dbPassword);
            
            if(connection!=null){
                status = "Não conectado...";
            }
            else{
                status = "Conectado com sucesso...";
            }
            
            return connection;
        }
        catch(ClassNotFoundException e){
            System.out.println("O driver especificado nao foi encontrado.");
            return null;
        } 
        catch(SQLException e){
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
        
    }
    public static String statusConection() {
        return status;
    }
    
    public static boolean closeConnection() {
        try {
            getMySqlConnection().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static java.sql.Connection restartConnection(){
        closeConnection();
        
        return getMySqlConnection();
    }
}
