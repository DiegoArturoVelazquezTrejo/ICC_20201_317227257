package shapesSVG;

/**
 * @author: Diego Arturo Velázquez Trejo
 * @version: 1.0
 * @date: 25 septiembre, 2019
 **/


public class Algoritmo extends SimulatedAnnealing{

    // Valor de la temperatura a lo largo de la ejecución del algoritmo
    private double temperatura;
    // Centro del círculo (de la temperatura) en el SVG
    private Vector2 centro;
    // Radio de la temperatura en el SVG
    private double radio;

    /**
    * Constructor Prueba para inicializar los atributos de la clase
    **/
    public Algoritmo(){
      this.centro = new Vector2(10, 10);
    }


    // Función para ir imprimiendo el SVG de los valores en círculos dependiendo su valor en la imagen de la función
    public void graficarPunto(){
      this.centro.setX(this.centro.getX() + 20);
      this.centro.setY(this.centro.getY() + 20);
    	String cadena = "<circle cx="+"'"+this.centro.getX()+"'"+" cy="+"'"+this.centro.getY()+"' r="+"'"+this.radio+"' stroke='black' stroke-width='4' fill='transparent'/>";
    	System.out.println(cadena);
    }
    

}
