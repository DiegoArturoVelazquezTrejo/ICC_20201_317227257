package lifegame;

import lifegame.herramientas.Pixel;
import lifegame.herramientas.Matriz;
import lifegame.herramientas.FuncionesRandom;
import processing.core.PApplet;
import processing.core.PImage;
/**
* Clase que modela el Juego de la Vida
* @author: Diego Arturo Velázquez
* @version: 1.0.0
**/

public class JuegoVida extends PApplet implements Reglas{

  /* Rangos para determinar el intervalo en el que el pixel se debe encontrar para conservar su valor*/
  /* Rango inferior */
  int rangoInferior = 1000;
  /* Rango superior */
  int rangoSuperior = 2295;
  /* Cota para saber si un pixel está vivo o muerto */
  int cotaSupervivencia = 500;

  /* Imagen donde se realizará el juego de la vida */
  PImage imagen;

  /* Matriz con la imagen donde se realizará el juego de la vida */
  Matriz imagenPixeles;
  /* Copia de la matriz de pixeles */
  Matriz copiaImagenPixeles;

  public static void main(String args[]){
    PApplet.main("lifegame.JuegoVida");
    //String im = args[0];
    //int ciclos = Integer.parseInt(args[2]);
  }

  @Override public void settings(){
      size(500,500);
  }

  @Override public void setup(){
    String im = "/paisaje.png";
    imagen = loadImage(getClass().getResource(im).getPath());
    imagenPixeles = new Matriz(imagen.height, imagen.width);
    imagen.loadPixels();
    //image(imagen, 0,0);
    for (int i = 0; i < imagen.height; i++) {
      for (int j = 0; j < imagen.width; j++) {
        int loc = i + j*imagen.width;
        int r = (int) red(imagen.pixels[loc]);
        int g = (int) green(imagen.pixels[loc]);
        int b = (int) blue(imagen.pixels[loc]);
        int[] rgb = {r,g,b};
        imagenPixeles.setPixel(i,j, new Pixel(rgb));
      }
    }
    copiaImagenPixeles = imagenPixeles.copia();
  }

  @Override public void draw(){
    loadPixels();
    int loc = 0;
    for(int i =0; i < imagen.height; i++){
      for(int j =0; j < imagen.width; j++){
        Pixel p = copiaImagenPixeles.getPixel(i,j);
        loc = i + j*imagen.width;
        pixels[loc] = color(p.getColor(0), p.getColor(1), p.getColor(2));
      }
    }
    updatePixels();
    comenzar(20);
  }

    /**
  * Método para comenzar con el juego de la vida
  * @param : número de ciclos que durará el juego de la vida
  **/
  public void comenzar(int ciclos){
    int i = 0;
    for(Pixel pix : this.imagenPixeles){
        // Adquirimos la suma por pixel de sus vecinos
        int sumaVecinos = this.imagenPixeles.sumaVecinos();
        if(this.estadoPixel(pix)){ // Esto quiere decir que el pixel está vivo
          if(!(sumaVecinos > this.rangoInferior && sumaVecinos < this.rangoSuperior))
            this.pierdeCantidadAleatoria(pix);
        }else{ // pixel está muerto
          if(sumaVecinos>cotaSupervivencia && sumaVecinos<cotaSupervivencia+255)
            this.aumentaCantidadAleatoria(pix);
        }
    }
    copiaImagenPixeles = imagenPixeles.copia();
  }
  /**
  * Regla que determina si un pixel está vivo o muerto
  * @param : Pixel
  * @return : <p>true si está vivo</p> <p>false si está muerto </p>
  **/
  @Override public boolean estadoPixel(Pixel pixel){
    return pixel.sumaColores() > cotaSupervivencia;
  }

  /**
  * Regla que provoca una pérdida aleatoria en el valor RGB del pixel
  * @param : Pixel pixel
  **/
  @Override public void pierdeCantidadAleatoria(Pixel pixel){
    while(pixel.sumaColores()>500){
      int c = FuncionesRandom.randomNumber();
      FuncionesRandom.disminuyePixelRandom(pixel, c);
    }
  }

  /**
  * Regla que provoca un aumento en el valor RGB del pixel
  * @param : Pixel
  **/
  @Override public void aumentaCantidadAleatoria(Pixel pixel){
    while(pixel.sumaColores()<=500){
      int c = FuncionesRandom.randomNumber();
      FuncionesRandom.aumentaPixelRandom(pixel, c);
    }
  }

}
