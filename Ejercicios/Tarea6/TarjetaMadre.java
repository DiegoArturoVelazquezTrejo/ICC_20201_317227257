/**
* Interfaz Tarjeta Madre
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0
**/
public interface TarjetaMadre{
  /* Variable que indica la cantidad de memoria RAM */
  public int RAM = 32;
  /* Variable que indica el modelo de la tarjeta madre */
  public String modelo = "Intel I Core 8 Generación";

  /**
  * Método imprimeEspecificaciones
  * @return : String
  **/
  public String imprimeEspecificaciones();
}
