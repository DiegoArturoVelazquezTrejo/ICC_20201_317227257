package lifegame;

import lifegame.herramientas.Pixel;
import lifegame.herramientas.Matriz;
import lifegame.herramientas.FuncionesRandom;
import lifegame.excepciones.ImagenNoExiste;
import lifegame.excepciones.IndiceInvalido;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.Scanner;
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

  /* Imagen donde se realizará el juego de la vida */
  PImage imagen;

  /* Matriz con la imagen donde se realizará el juego de la vida */
  Matriz imagenPixeles;
  /* Copia de la matriz de pixeles */
  Matriz copiaImagenPixeles;
  /* Ruta de la imagen */
  String im = "/";

  public static void main(String args[]){
    PApplet.main("lifegame.JuegoVida");
    System.out.println("Ingresa el nombre de la imagen SIN EXTENSIÓN: "+"\n");
    System.out.println("\n(Si te equivocas al teclear el nombre, presiona enter y vuelve a ingresar el nombre)");
    System.out.println("\nPara agregar extensión de la imagen siga los pasos: \n");
    System.out.println(" a) Si presionas la tecla 1, en la ruta de la imagen se escribe .jpg");
    System.out.println("-----------------------------------------------------------------");
    System.out.println(" b) Si presionas la tecla 2, en la ruta de la imagen se escribe .png");
    System.out.println("\n ----------------------- Presiona ENTER -----------------------\n");
    System.out.println("-----------------------------------------------------------------");
    System.out.println(" c) Para guardar la imagen dale click!\n\n");
    System.out.println("\n\nSi deseas cambiar la imagen, vuelve a escribir el nombre de la nueva imagen\n");
  }

  @Override public void settings(){
    size(100,100);
  }

  @Override public void setup(){}

  /**
  * Se inicializa la imagenPixeles con los pixeles de la imagen que se trabajará
  **/
  public void setupImagen(){
    try{
      imagen = loadImage(getClass().getResource(im).getPath());
      surface.setResizable(true);
      surface.setSize(imagen.width, imagen.height);
      this.imagenPixeles = new Matriz(imagen.height, imagen.width);
      imagen.loadPixels();
      frameRate(6000);
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
    }catch(Exception e){
      System.out.println("\nImagen Inválida, escribe la ruta de nuevo\n");
      im = "/";
    }
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
        int sumaVecinos = this.imagenPixeles.sumaVecinos();
        if(pix.getEstado()){
          if(!(sumaVecinos > rangoInferior && sumaVecinos < rangoSuperior))
            this.pierdeCantidadAleatoria(pix);
        }else{
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

  /**
  * Método que espera la lectura de caracteres para que el usuario le pase la imagen
  **/
  public void keyPressed(){
    if(imagen != null && im.length() > 0){
       im = "/";
       imagen = null;
     }
    if(Character.getNumericValue(key) != -1){
      if(key == '1') this.im = this.im+".jpg";
      else if(key == '2') this.im = this.im+".png";
      else this.im = this.im + key;
      System.out.print(this.im);
    }else{
      this.setupImagen();
    }

  }
  /**
  * Identifica cuando se realiza un click
  **/
  @Override
  public void mouseClicked(){
    try{
      guardaImagen();
    }catch(ImagenNoExiste e){
      System.out.println(e.getMessage());
    }
    im = "/";
  }
  /**
  * Método que guarda la imagen
  **/
  public void guardaImagen() throws ImagenNoExiste{
    if(imagen != null){
    imagen.loadPixels();
    int a = 0;
    int b = 0;
    for(Pixel p : imagenPixeles){
      int loc = a + b * height;
      if(loc < imagen.pixels.length) imagen.pixels[loc] = color(p.getColor(0), p.getColor(1), p.getColor(2));
      if(a == imagen.height){
        a = 0;
        b++;
      }else{
        b++;
      }
    }
    imagen.save("resultado.jpg");
    System.out.println("\nLa imagen se ha guardado!\n");
  }else throw new ImagenNoExiste("La imagen aún no ha sido seleccionada\n");
  }
}
