/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahelp;

import java.sql.Connection;

/**
 *
 * @author Carlo
 */
public class ConnectionsManager {
    public static Connection connections(){
        DBConnection dbcon = new DBConnection();
        return dbcon.getConnection();
    }
    public static Connection connections_user_password(String user,String password){
        DBConnection dbcon = new DBConnection();
        return dbcon.getConnection(user, password);
    }
    public static Connection connections_instance_dbname(String instance,String database){
        DBConnection dbcon = new DBConnection();
        return dbcon.getNewDBConnection(instance, database);
    }
    public static Connection connections(String Instance,String DataBase,String User,String Password){
        DBConnection dbcon = new DBConnection();
        return dbcon.getConnection(Instance, DataBase, User, Password);
    }
}
