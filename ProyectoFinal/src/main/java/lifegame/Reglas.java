package lifegame;

import lifegame.herramientas.Pixel;
/**
* Reglas para el juego de la vida
* @author : Diego Arturo Velázquez
* @version : 1.0.0
**/

public interface Reglas{

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
