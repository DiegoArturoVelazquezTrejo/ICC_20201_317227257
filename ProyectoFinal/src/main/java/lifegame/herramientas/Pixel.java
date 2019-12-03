package lifegame.herramientas;

import lifegame.excepciones.ColorInvalido;
/**
* Clase para modelar un pixel almacenando sus valores
**/
public class Pixel {

  /* Arreglo para almacenar los colores */
  private int[] rgb;
  /* Variable boolean de estado*/
  private boolean estado;

  /**
  * Constructor de la clase Pixel
  * @param : arreglo de int (rgb)
  **/
  public Pixel(int[] rgb){
    this.rgb = rgb;
    this.setEstado();
  }

  /**
  * Getter del atributo rgb
  * @return: arreglo de int [rgb]
  **/
  public int[] getRGB(){
    return this.rgb;
  }

  /**
  * Getter de un atributo del rgb
  * @return: int color
  **/
  public int getColor(int color){
    return this.rgb[color];
  }

  /**
  * Setter de un atributo del rgb
  * @param : int indice
  * @param : int color nuevo
  **/
  public void setColor(int indice, int color) throws ColorInvalido{
    if(color > 255) throw new ColorInvalido("Color fuera del rango");
    this.rgb[indice] = color;
    this.setEstado();
  }

  /**
  * Método que suma los tres colores
  * @return : int suma
  **/
  public int sumaColores(){
    return this.rgb[0]+this.rgb[1]+this.rgb[2];
  }

  /**
  * Getter del atributo estado
  * @return : boolean estado
  **/
  public boolean getEstado(){
    return this.estado;
  }

  /**
  * Setter del atributo estado
  **/
  public void setEstado(){
    this.estado = this.sumaColores() >= 500;
  }
  /**
  * toString del pixel
  * @return : String
  **/
  @Override
  public String toString(){
    return "R: "+this.rgb[0] + " G: "+this.rgb[1] + " B: "+this.rgb[2];
  }

}
