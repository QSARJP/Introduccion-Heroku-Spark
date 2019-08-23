package edu.escuelaing.arep.SparkWebApp.entities;

/**
 * clase Head, la cual tiene como objetivo conocer cuales nodos son el primero y el utlimo de la linkedList
 *
 * @author Ospina
 * 
 * @version (a version 22/8/19)
 */

public class Head {

    private Nodo primerNodo;
    private Nodo ultimoNodo;

    public Head(Nodo primerNodo, Nodo ultimoNodo) {
        this.primerNodo = primerNodo;
        this.ultimoNodo = ultimoNodo;
    }

    public Nodo getUltimoNodo() {
        return ultimoNodo;
    }

    public void setUltimoNodo(Nodo ultimoNodo) {
        this.ultimoNodo = ultimoNodo;
    }

    public Nodo getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(Nodo primerNodo) {
        this.primerNodo = primerNodo;
    }
}