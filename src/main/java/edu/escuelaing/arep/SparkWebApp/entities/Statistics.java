package edu.escuelaing.arep.SparkWebApp.entities;

/**
 * clase encargada de tener todas las estadisticas necesarias para un conjunto de datos
 *
 * @author Ospina
 * 
 * @version (a version 15/8/19)
 */

public class Statistics {
    
    private LinkedList lista;
    private float promedio;
    private int numeroDatos;
    private float resta;
    private float desviacion;

    /**
     * Al momento de crear la clase esta pasa a ejecutar todas las estadisticas que se tienen.
     * @param lista LinkedList
     */
    
    public Statistics (LinkedList lista){
        this.lista = lista;
        this.promedio = promedio();
        this.resta = resta();
        this.desviacion = desviacion();
        
    }

    private float promedio (){
        float total = 0;
        int num = 0;
        float pro = 0;
        if(!lista.isEmpty()){
           Head head = lista.getHead();
           Nodo nodoActual  = head.getPrimerNodo();
           while (!(nodoActual == null)){
               total += nodoActual.getData();
               num ++;
               nodoActual = nodoActual.getNextNode();
           }
           pro = total / num ;
        }
        numeroDatos = num;
        return pro;
    }
    
    
    private float resta () {
        float total = 0;
        if(!lista.isEmpty()){
           Head head = lista.getHead();
           Nodo nodoActual  = head.getPrimerNodo();
           while (!(nodoActual == null)){
               total += (float) Math.pow(nodoActual.getData() - getPromedio(),2);
               nodoActual = nodoActual.getNextNode();
           }
        }
        return total;
    }
    
    
    private float desviacion(){
        return (float) Math.sqrt(getResta()/(getNumeroDatos()-1));
    }
    
    public float getPromedio(){
        return this.promedio;
    }
    
    public int getNumeroDatos(){
        return this.numeroDatos;
    }
    
    public float getResta(){
        return this.resta;
    }

    public float getDesviacion(){
        return this.desviacion;
    }
}