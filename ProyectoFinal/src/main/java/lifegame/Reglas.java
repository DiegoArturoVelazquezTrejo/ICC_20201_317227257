package lifegame;

import lifegame.herramientas.Pixel;
/**
* Reglas para el juego de la vida
* @author : Diego Arturo Velázquez
* @version : 1.0.0
**/

public interface Reglas{

  /**
  * Regla que determina si un pixel está vivo o muerto
  * @param : Pixel
  * @return : <p>true si está vivo</p> <p>false si está muerto </p>
  **/
  public boolean estadoPixel(Pixel pixel);

  /**
  * Regla que provoca una pérdida aleatoria en el valor RGB del pixel
  * @param : Pixel pixel
  **/
  public void pierdeCantidadAleatoria(Pixel pixel);

  /**
  * Regla que provoca un aumento en el valor RGB del pixel
  * @param : Pixel
  **/
  public void aumentaCantidadAleatoria(Pixel pixel);

}
