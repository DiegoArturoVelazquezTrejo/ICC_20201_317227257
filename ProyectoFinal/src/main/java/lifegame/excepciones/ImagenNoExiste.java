package lifegame.excepciones;
/**
* Excepción de inexistencia de imagen
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0.0
**/
public class ImagenNoExiste extends Exception{
  /* Constructor por omisión de la Excepción ImagenNoExiste*/
  public ImagenNoExiste(){
    super();
  }
  /**
  * Constructor de la excepción ImagenNoExiste
  * @param : String mensaje
  **/
  public ImagenNoExiste(String m){
    super(m);
  }
}
