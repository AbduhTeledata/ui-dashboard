package com.raven.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class koneksi {
  
    private static Connection connection;
    
    public static Connection getConnection(){
        
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
                String user = "root";
                String pass = "@Hazlam2024";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Tidak terhubung ke database");
            }
        }
        return connection;
    }
}
