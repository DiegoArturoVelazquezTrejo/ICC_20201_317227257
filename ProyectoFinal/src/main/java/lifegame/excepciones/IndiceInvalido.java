package lifegame.excepciones;
/**
* Excepción de índice inválido
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0.0
**/
public class IndiceInvalido extends Exception{
  /* Constructor por omisión de la Excepción IndiceInvalido*/
  public IndiceInvalido(){
    super();
  }
  /**
  * Constructor de la excepción IndiceInvalido
  * @param : String mensaje
  **/
  public IndiceInvalido(String m){
    super(m);
  }
}

 
