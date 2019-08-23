package edu.escuelaing.arep.SparkWebApp.entities;

/**
 * clase Linked, es la responsable de guardar los datos que le ingresen, ademas tiene diferentes operaciones basicas de listas como la insercion o la elminiacion de un nodo
 *
 * @author Ospina
 * 
 * @version (a version 15/8/19)
 */

public class LinkedList {

    private Head head;
    

    public LinkedList() {
        this.head = new Head(null, null);
        
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }


    /**
     * Agregar un nodo a la LinkedList
     * @param nodo 
     */
    
    public void addNode(Nodo nodo){
        Nodo ultimo = null;
        if (head.getUltimoNodo() != null){
            ultimo = head.getUltimoNodo();
            ultimo.setNextNode(nodo);    
        }else{
            ultimo = nodo;
        }
        nodo.setNextNode(null); 
        head.setUltimoNodo(nodo);
        
    }
    /**
     * remover un nodo de la LInkedList
     * @param nodo
     */
    public void removeNode (Nodo nodo){
        Nodo nodop = head.getPrimerNodo();
        while (nodop.getIdNodo() != nodo.getIdNodo() && nodop.getNextNode() != null){
            Nodo nodo2 = nodop.getNextNode();
            if (nodo2.equals(nodo)){
                nodop.setNextNode(nodo2.getNextNode());
                nodo2.setNextNode(null);
            }
            nodop = nodo2;
        }
    }

    /**
     * Conocer cual el el siguiente nodo del nodo que se le pasa como parametro
     * @param nodo
     * @return Nodo
     */

    public Nodo nextNode (Nodo nodo){
        return nodo.getNextNode();
    }

    /**
     * conocer si la lista LinkedList esta vacia o no 
     * @return Boolean 
     */

    public Boolean isEmpty(){
        return (head.getPrimerNodo()== null && head.getUltimoNodo()==null);
    }

    /**
     * mostrar la conformacion del LinkedList 
     */

    public String showList(){
        String str =  " ";
		Nodo current = head.getPrimerNodo();
		while(current!=null){
			str += current.displayLink() + "\n";
			current=current.getNextNode();
		}
		return str;
	} 


}