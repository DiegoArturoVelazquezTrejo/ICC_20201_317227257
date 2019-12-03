package lifegame;

import lifegame.herramientas.Pixel;
import lifegame.herramientas.Matriz;
import lifegame.herramientas.FuncionesRandom;
import lifegame.excepciones.ImagenNoExiste;
import lifegame.excepciones.IndiceInvalido;
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
  int rangoSuperior = 2900;

  /* Imagen donde se realizará el juego de la vida */
  PImage imagen;

  /* Matriz con la imagen donde se realizará el juego de la vida */
  Matriz imagenPixeles;
  /* Copia de la matriz de pixeles */
  Matriz copiaImagenPixeles;
  /* Ruta de la imagen */
  String im;

  public static void main(String args[]){
    PApplet.main("lifegame.JuegoVida");
  }

  @Override public void settings(){
      size(500,500);
  }
  /**
  * Se inicializa la imagenPixeles con los pixeles de la imagen que se trabajará
  **/
  @Override public void setup(){
    im = "/wolf.jpg";
    imagen = loadImage(getClass().getResource(im).getPath());
    this.imagenPixeles = new Matriz(imagen.height, imagen.width);
    imagen.loadPixels();
    for (int i = 0; i < imagen.height; i++) {
      for (int j = 0; j < imagen.width; j++) {
        int loc = i + j*imagen.height;
        int r = (int) red(imagen.pixels[loc]);
        int g = (int) green(imagen.pixels[loc]);
        int b = (int) blue(imagen.pixels[loc]);
        int[] rgb = {r,g,b};
        this.imagenPixeles.setPixel(i,j,new Pixel(rgb));
      }
    }
    copiaImagenPixeles = imagenPixeles.copia();
  }
  /**
  * Este método está dibujando constantemente la imagen copia 
  **/
  @Override public void draw(){
    try{
      if(imagen != null) dibujaImagen();
    }catch(IndiceInvalido e){
      System.out.println(e.getMessage());
    }
  }

  /**
  * Método que dibuja la imagen en la pantalla
  **/
  public void dibujaImagen() throws IndiceInvalido{
    imagen.loadPixels();
    image(imagen,0,0);
    int loc = 0;
    for(int i =0; i < imagen.height; i++){
      for(int j =0; j < imagen.width; j++){
        Pixel p = copiaImagenPixeles.getPixel(i,j);
        loc = i + j*imagen.height;
        if(loc >= imagen.pixels.length) throw new IndiceInvalido("Indice Inválido");
        imagen.pixels[loc] = color(p.getColor(0), p.getColor(1), p.getColor(2));
      }
    }
    imagen.updatePixels();
    comenzar();
  }

  /**
  * Método para comenzar con el juego de la vida
  **/
  public void comenzar(){
    for(Pixel pix : this.imagenPixeles){
        // Adquirimos la suma por pixel de sus vecinos
        int sumaVecinos = this.imagenPixeles.sumaVecinos();
        if(pix.getEstado()){ // Esto quiere decir que el pixel está vivo
          if(!(sumaVecinos > rangoInferior && sumaVecinos < rangoSuperior))
            this.pierdeCantidadAleatoria(pix);
        }else{ // pixel está muerto
          if(sumaVecinos>500 && sumaVecinos<755)
            this.aumentaCantidadAleatoria(pix);
        }
    }
    copiaImagenPixeles = imagenPixeles.copia();
  }

  /**
  * Regla que provoca una pérdida aleatoria en el valor RGB del pixel
  * @param : Pixel pixel
  **/
  @Override public void pierdeCantidadAleatoria(Pixel pixel){
    if(pixel == null) return;
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
    if(pixel == null) return;
    while(pixel.sumaColores()<=500){
      int c = FuncionesRandom.randomNumber();
      FuncionesRandom.aumentaPixelRandom(pixel, c);
    }
  }

}
