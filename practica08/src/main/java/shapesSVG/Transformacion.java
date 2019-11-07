package shapesSVG;

/**
* Interfaz funcional para tranformar un triángulo.
* @author: Diego Arturo Velázquez
* @version : 1.0.
**/

@FunctionalInterface
public interface Transformacion{
  /**
  * Método que va a transformar un triángulo
  * @param : Vector2 a
  * @return : Vector2 transformación
  **/
  public Vector2 transformacion(Vector2 vector);

}
