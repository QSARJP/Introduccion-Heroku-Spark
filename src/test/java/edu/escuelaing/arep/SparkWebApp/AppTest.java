package edu.escuelaing.arep.SparkWebApp;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.escuelaing.arep.SparkWebApp.entities.*;


 /**
 * clase encargada de realizar test con diferentes data set 
 *
 * @author Ospina
 * 
 * @version (a version 15/8/19)
 */
public class AppTest{
    /**
     * Default constructor for test class AppTest
     */
    public AppTest()
    {
    }

	@Test
	public void pruebaJUnit() {

		assertTrue(true);
    }
    @Test
	public void promedio() {
        try{
            Programa pro = new Programa();
            LinkedList list = pro.readFile("file3.txt");
            Statistics stat = new Statistics(list);
            assertEquals( Math.round(stat.getPromedio()) ,  639);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    @Test
	public void resta() {
        try{
            Programa pro = new Programa();
            LinkedList list = pro.readFile("file3.txt");
            Statistics stat = new Statistics(list);
            assertEquals( Math.round(stat.getResta()),3522761);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
	public void segundoEjemplo() {
        try{
            Programa pro = new Programa();
            LinkedList list = pro.readFile("file2.txt");
            Statistics stat = new Statistics(list);
            assertEquals( Math.round(stat.getDesviacion()),572);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
   

}
