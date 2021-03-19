/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahelp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Carlo
 */
public class JavaHelp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
// <editor-fold defaultstate="collapsed" desc=" TXTManager "> 
        //probando clase manejadora de archivos de texto
        TXTManager txtman = new TXTManager();
        LinkedList<String> LL1 = new LinkedList<>();
        Scanner readln = new Scanner(System.in);
        System.out.println("Ingrese valores");
        String datoaux;
        for(int i=0; i<5;i++){
            datoaux= readln.next();
            LL1.add(datoaux);
        }
        System.out.println("Creando txt");
        txtman.CreateAFile(null, null, null);
        System.out.println("Iniciando guardado de txt");
        txtman.AddToFile(LL1);
        System.out.println("Se ha guardado el txt");
        System.out.println("Leyendo el txt");
        Object[] reads = txtman.ReadFileToLinkedList().toArray();
        System.out.println("Imprimiendo los datos");
        for(int i =0;i<reads.length;i++){
            System.out.println("dato "+(i+1)+": "+reads[i].toString());
        }
//</editor-fold>
        System.out.println("\n\n\n\r ------------ test en bases de datos ---------");
        System.out.println("hola mundo");
        String datos = "";
        try{
            Statement stat = ConnectionsManager.connections().createStatement();
            String sql = "SELECT * FROM PruebaJava.dbo.Table_1";
            ResultSet tb_resul = stat.executeQuery(sql);
            while (tb_resul.next()){
                datos+= tb_resul.getString(1)+ " "+tb_resul.getString(2)+" "+tb_resul.getString(3)+ "\n";
            }
            System.out.println(datos);
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
}
