/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEll
 */
public class DataSource1 {
    private static DataSource1 instance;
    
    private static Connection cnx;
    
    private final String url="jdbc:mysql://localhost:3306/pisym";
    private final String username="root";
    private final String password="";
    
    private DataSource1(){
    
        try {
            cnx= DriverManager.getConnection(url, username, password);
            System.out.println("connecting");
        } catch (SQLException ex) {
            System.out.println("erreur");;
        }
    
    }
    
    public static DataSource1 getinstance(){
    
    if(instance == null)
        instance = new DataSource1();
    return instance;
    
    }

    public static Connection getCnx() {
        return cnx;
    }
    
    
    
}
