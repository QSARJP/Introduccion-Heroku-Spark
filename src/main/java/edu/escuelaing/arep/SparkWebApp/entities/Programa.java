/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.SparkWebApp.entities;

import java.io.*;

 /**
 * clase encargada de leer un archivo y poder retornas una LinkedList
 *
 * @author Ospina
 * 
 * @version (a version 15/8/19)
 */
public class Programa {
    
    private LinkedList list ;



    public Programa() {

    }


    
    /**
     * Metodo para la lectura de los datos de un archivo 
     * @param doc nombre del documento
     * @return LinkedList
     */
    public LinkedList readFile(String doc){
        
        File file = new File("src\\main\\resources\\"+doc);
        BufferedReader reader = null;
        list = new LinkedList();
        int num = 0;
        Nodo primario = null ;
        Nodo secundario = null ;
        
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
                
            while ((text = reader.readLine()) != null) {
                if (num == 0){
                    primario  = new Nodo(Float.parseFloat(text),num+1,null);
                    list.getHead().setPrimerNodo(primario);
                }else{
                    secundario = primario;
                    primario  = new Nodo(Float.parseFloat(text),num+1,null);
                    secundario.setNextNode(primario);
                }
                num++;
                list.addNode(primario);
                
                
            }
            list.getHead().setUltimoNodo(primario);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return list;
    }
    
    
}
