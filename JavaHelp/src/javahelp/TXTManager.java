/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahelp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class TXTManager {

    private DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.FULL);//DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
    private SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    private FileWriter fichero = null;
    private PrintWriter pw = null;
    private String filePath="c:\\workspacejava\\Generaltxt\\";
    private String fileName="NewFile"+df.format(new Date());
    private String fileType=".txt";
    
    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileType
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
     public void AddToFile(LinkedList<String> lines) {
        File archivo = new File(getFilePath()+getFileName()+getFileType());
        try {
            PrintWriter write = new PrintWriter(new FileWriter(archivo,true));
            for(String line : lines){
                write.println(line);
            }
            write.close();
        } catch (IOException ex) {

        }
    }
     public void AddToFile(String line) {
        File archivo = new File(getFilePath()+getFileName()+getFileType());
        try {
            PrintWriter write = new PrintWriter(new FileWriter(archivo,true));
            write.println(line);
            write.close();
        } catch (IOException ex) {

        }
    }
    public DefaultTableModel ReadFileToTableModel(String[] columnas) 
    {
        DefaultTableModel tablagen = new DefaultTableModel();
        for(int x=0;x<columnas.length;x++)
        {
            tablagen.addColumn(columnas[x]);
        }
        File archivo = new File(getFilePath()+getFileName()+getFileType());
        try {
            BufferedReader read = new BufferedReader(new FileReader(archivo));
            String linea = read.readLine();
            while (linea != null) {
                String[] aux=linea.split(",");
                tablagen.addRow(aux);
                linea = read.readLine();
            }
            read.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return tablagen;
    }
    public LinkedList ReadFileToLinkedList() 
    {
        LinkedList<String> tempList = new LinkedList<>();
        File archivo = new File(getFilePath()+getFileName()+getFileType());
        try {
            BufferedReader read = new BufferedReader(new FileReader(archivo));
            String linea = read.readLine();
            while (linea != null){
                tempList.add(linea);
                linea = read.readLine();
            }
            read.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return tempList;
    }
    
    public void UpdateFileFromTableModel(String ubicacion,DefaultTableModel modelo)
    {
        File archivo=new File(getFilePath()+getFileName()+getFileType());
        try {
            PrintWriter escribir=new PrintWriter(archivo);
            for(int y=0;y<modelo.getRowCount();y++)
            {
                String linea="";
                linea=modelo.getValueAt(y, 0).toString();
                for(int x=1;x<modelo.getColumnCount();x++)
                {
                   linea=linea+","+modelo.getValueAt(y, x).toString();
                }
                escribir.println(linea);
            }
            escribir.close();
        } catch (FileNotFoundException ex) {
            
        }
    }
    
    public void CreateAFile(String fp,String fn, String ft)
    {
        if(fp != null) setFilePath(fp);
        if(fn != null) setFileName(fn);
        if(ft != null) setFileType(ft);
        File archivo=new File(getFilePath()+getFileName()+getFileType());
        try {
            PrintWriter escribir=new PrintWriter(archivo);
            escribir.close();
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: ");ex.printStackTrace();
        }
    }
            
    public void SaveOneString(String Line){
        File archivo=new File(getFilePath()+getFileName()+getFileType());
        try {
           // PrintWriter escribir=new PrintWriter(archivo); //Ingresar informacion nueva, borra el contenido del archivo
           PrintWriter escribir=new PrintWriter(new FileWriter(archivo,true));
           escribir.println(Line);
            escribir.close();
          //JOptionPane.showMessageDialog(this, "Linea creada con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }
}
