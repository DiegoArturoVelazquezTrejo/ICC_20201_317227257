/**
* Clase Calculadora
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0
**/
public class Calculadora implements TarjetaMadre{
  /* Variable que indica si la calculadora es recargable o de baterías  */
  protected boolean recargable;
  /* Variable que indica si la calculadora es cientídica o no */
  protected boolean cientifica;
  /* Variable que indica si la calculadora grafica o no*/
  protected boolean grafica;

  /**
  * Constructor para la clase Calculadora
  * @param : boolean recargable
  * @param : boolean cientifica
  * @param : boolean grafica
  **/
  public Calculadora(boolean recargable, boolean cientifica, boolean grafica){
    this.recargable = recargable;
    this.cientifica = cientifica;
    this.grafica = grafica;
  }

  /**
  * Método getter para el atributo recargable
  * @return: boolean
  **/
  public boolean getRecargable(){ return this.recargable; }
  /**
  * Método getter para el atributo cientifica
  * @return: boolean
  **/
  public boolean getCientifica(){ return this.cientifica; }
  /**
  * Método getter para el atributo grafica
  * @return: boolean
  **/
  public boolean getGrafica(){ return this.grafica; }

  /**
  * Implementando el método de imprimeEspecificaciones
  * @return : String
  **/
  public String imprimeEspecificaciones(){
    return "RAM: "+this.RAM+"\nProcesador: "+this.modelo+"\nRecargable: "+this.recargable+ "\nCalculadora Científica: "+this.cientifica+"\nGrafica: "+this.grafica+"\n";
  }
}
