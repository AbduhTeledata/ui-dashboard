package com.raven.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class SingletonConnection {
    
    private final String SERVER = "localhost:3306";
    private final String DB = "infotama_pool_cafe";
    private final String USER = "root";
    private final String PASS = "@Hazlam2024";
    private Connection con;
    
    private static SingletonConnection instance = null;
    
    private SingletonConnection(){
    }
    
    public static SingletonConnection getInstance(){
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }
    
    public void connectDatabase() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = java.sql.DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DB, USER, PASS);
    }
    
    public void reconnect() throws Exception{
        con = java.sql.DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DB, USER, PASS);
    }
    
    public Connection openConnection(){
        return con;
    }
    
    public void closeConnection() throws Exception{
        if (con != null) {
            con.close();
        }
    }
}
