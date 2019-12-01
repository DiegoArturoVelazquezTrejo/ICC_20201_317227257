package lifegame.prueba;

import lifegame.herramientas.Matriz;
import lifegame.JuegoVida;
import processing.core.PApplet;
import processing.core.PImage;
/**
* Clase que muestra gŕaficamente el Juego de la vida
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0.0
**/

public class Main extends PApplet{
  /* Imagen donde se realizará el juego de la vida */
  PImage imagen;

  public static void main(String args[]){
    PApplet.main("lifegame.gui.Main");
    /* Leemos la imagen que le pasemos al juego */
    int[][][] imagen = { {  {1,2,3}, {4,5,6}, {7,8,9}  },
                         {  {10,11,12}, {13,14,15}, {16,17,18}  },
                         {  {19,20,21}, {22,23,24}, {25,26,27}  },
                         {  {28,29,30}, {31,32,33}, {34,35,36}  }
                     };
    //JuegoVida juego = new JuegoVida(imagen);
    /* Comienza el juego de la vida con 20 ciclos */
    //juego.comenzar(20);
    /* Obteniendo la matriz como resultado de las ejecuciones del juego de la vida */
    //Matriz imagenFinal = juego.getImagenPixeles();
  }

  @Override public void settings(){
      //size(500,500);
  }

  @Override public void setup(){
    //String im = "/paisaje.png";
    //imagen = loadImage(getClass().getResource(im).getPath());
    //loadPixels();
    //System.out.println(imagen.width);
    //System.out.println(imagen.height);
    //image(imagen, 0,0);
  }

  @Override public void draw(){

  }

}
