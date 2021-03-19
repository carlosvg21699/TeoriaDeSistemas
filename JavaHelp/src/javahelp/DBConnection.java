/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahelp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class DBConnection {
    private String INSTANCE="DESKTOP-PE21C6I\\SQLEXPRESS;";
    private String DB = "PruebaJava;";
    private String USER="usuJava;";
    private String PASSWORD="123;";
    private Connection CONNECTION;
    
    /**
     * @return a default connection to the DB
     * you may manage the default credentials
     * making changes in the internal variables 
     * of the class
     */
    public Connection getConnection(){
        String connectionUrl = "jdbc:sqlserver://"+getINSTANCE()+"database="+getDB()+"user="+getUSER()+"password="+getPASSWORD();
        try {
            CONNECTION = DriverManager.getConnection(connectionUrl);
            return CONNECTION;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    /**
     * @return a connection to the DB
     * with an specific user and paswword
     * this credentials could be changed
     */
    public Connection getConnection(String User,String Password){
        setUSER(User);
        setPASSWORD(Password);
        return getConnection();
    }

    /**
     * @return a connection to the DB
     * with an specific Instance and DB Name
     * this data could be changed
     */
    public Connection getNewDBConnection(String Instance,String DataBase){/*The constructor needs strings values sended as objects*/
        setINSTANCE(Instance);
        setDB(DataBase);
        return getConnection();
    }
    public Connection getConnection(String Instance,String DataBase,String User,String Password){
        setINSTANCE(Instance);setDB(DataBase);setUSER(User);setPASSWORD(Password);
        return getConnection();
    }

    /**
     * @return the INSTANCE
     */
    public String getINSTANCE() {
        return INSTANCE;
    }

    /**
     * @param INSTANCE the INSTANCE to set
     */
    public void setINSTANCE(String INSTANCE) {
        this.INSTANCE = INSTANCE;
    }

    /**
     * @return the DB
     */
    public String getDB() {
        return DB;
    }

    /**
     * @param DB the DB to set
     */
    public void setDB(String DB) {
        this.DB = DB;
    }

    /**
     * @return the USER
     */
    public String getUSER() {
        return USER;
    }

    /**
     * @param USER the USER to set
     */
    public void setUSER(String USER) {
        this.USER = USER;
    }

    /**
     * @return the PASSWORD
     */
    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * @param PASSWORD the PASSWORD to set
     */
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
