package edu.escuelaing.arep.SparkWebApp;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.util.Arrays;
import java.util.List;

import edu.escuelaing.arep.SparkWebApp.entities.LinkedList;
import edu.escuelaing.arep.SparkWebApp.entities.Nodo;
import edu.escuelaing.arep.SparkWebApp.entities.Statistics;


public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>HTML Forms</h2>"
                + "<form action=\"/results\">"
                + "  First name:<br>"
                + "  <input type=\"text\" name=\"firstname\" value=\"1,2,3,4,5,6,7,8,9,10,11,12,13\">"
                + "  <br>"
                + "  Last name:<br>"
                + "  <input type=\"text\" name=\"lastname\" value=\"Mouse\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
      LinkedList list = lecturaDatos(req,res);
      Statistics stat = new Statistics(list);

      String pageContent
               = "<!DOCTYPE html>"
               + "<html>"
               + "<body>"
               + "<h2>Answer</h2>"
               + "<form action=\"/results\">"
               + "  First name:<br>"
               + "  Datos: "+list.showList()
               + "  <br>"
               + "  El promedio es: "+ stat.getPromedio()
               + "  <br>"
               + "  La desviacion estandar es : " + stat.getDesviacion()
               + "</form>"
               + "</body>"
               + "</html>";
      return pageContent;
    }

    private static LinkedList lecturaDatos(Request req, Response res){

      String respuesta = req.queryParams("firstname");
         List<String> array = Arrays.asList(respuesta.split(","));
         LinkedList list = new LinkedList();
         int num = 0;
         Nodo primario = null ;
         Nodo secundario = null ;
         for (String i : array){
            if (num == 0){
               primario  = new Nodo(Float.parseFloat(i),num+1,null);
               list.getHead().setPrimerNodo(primario);
            }else{
               secundario = primario;
               primario  = new Nodo(Float.parseFloat(i),num+1,null);
               secundario.setNextNode(primario);
            }
            num++;
            list.addNode(primario);
            
         }
         list.getHead().setUltimoNodo(primario);
         return list;
    }
    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}