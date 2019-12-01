package lifegame.excepciones;
/**
* Excepción de color inválido
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0.0
**/
public class ColorInvalido extends Exception{
  /* Constructor por omisión de la Excepción ColorInvalido*/
  public ColorInvalido(){
    super();
  }
  /**
  * Constructor de la excepción ColorInvalido
  * @param : String mensaje
  **/
  public ColorInvalido(String m){
    super(m);
  }
}
