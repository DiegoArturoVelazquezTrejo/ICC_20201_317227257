package lifegame.herramientas;

import lifegame.herramientas.Pixel;
import lifegame.excepciones.ColorInvalido;
import java.util.Random;
/**
* Clase para modelar los métodos de cambio aleatorio en los pixeles
* @author: Diego Arturo Velázquez
* @version: 1.0.0
* Cambiando los pixeles del objeto Pixel, buscaremos un número aleatorio entre 0 y 30 para no afectar un cambio que
* pueda ir de 0 a 255.
**/

public class FuncionesRandom{
  /* Consructor privado para evitar que se intancie la clase y solo usar sus métodos */
  private FuncionesRandom(){}
  /**
  * Método que devuelve un número aleatorio entre 1 y 3 por los colores RGB
  * @return: int numero aleatorio [1,2,3]
  **/
  public static int randomNumber(){
    // Objeto Random
    Random r = new Random();
    int numero = r.nextInt(3);
    return numero;
  }

  /**
  * Método que modifica aleatoriamente el color del pixel
  **/
  public static void aumentaPixelRandom(Pixel pixel, int numero){

    // Objeto Random
    Random r = new Random();
    int variableRandom = r.nextInt(255);
    int color = pixel.getColor(numero);
    int nuevoColor = color + variableRandom;
    if(nuevoColor > 0 && nuevoColor <255){
      try{
        pixel.setColor(numero, nuevoColor);
      }catch(ColorInvalido e){
        System.out.println(e.getMessage());
      }
    }
  }
  /**
  * Método que modifica aleatoriamente el color del pixel
  **/
  public static void disminuyePixelRandom(Pixel pixel, int numero){

    // Objeto Random
    Random r = new Random();
    int variableRandom = r.nextInt(255);
    int color = pixel.getColor(numero);
    int nuevoColor = color - variableRandom;
    if(nuevoColor>0 && nuevoColor<255){
      try{
        pixel.setColor(numero, nuevoColor);
      }catch(ColorInvalido e){
        System.out.println(e.getMessage());
      }
    }
  }


}
