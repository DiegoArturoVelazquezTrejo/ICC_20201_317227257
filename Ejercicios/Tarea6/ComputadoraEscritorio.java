/**
* Clase class ComputadoraEscritorio
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0
**/
public class ComputadoraEscritorio extends ComputadoraSimple{
  /* Variable que indica el tamaño de la computadora  */
  protected int tamano;
  /* Variable que indica el modelo del monitor */
  protected String modeloMonitor;
  /* Variable que indica si la tiene disco duro */
  protected boolean discoDuro;

  /**
  * Constructor para la clase ComputadoraEscritorio
  * @param : int getMemoria
  * @param : int usb
  * @param : boolean puertoEthernet
  * @param : int tamano
  * @param : String modeloMonitor
  * @param : boolean discoDuro
  **/
  public ComputadoraEscritorio(int memoria, int usb, boolean puertoEthernet, int tamano, String modeloMonitor, boolean discoDuro){
    super(memoria, usb, puertoEthernet);
    this.tamano = tamano;
    this.modeloMonitor = modeloMonitor;
    this.discoDuro = discoDuro;
  }
  /**
  * Método getter para el atributo tamano
  * @return : int
  **/
  public int getTamano(){ return this.tamano; }
  /**
  * Método getter para el atributo modeloMonitor
  * @return: String
  **/
  public String getModeloMonitor(){ return this.modeloMonitor; }
  /**
  * Método getter para el atributo discoDuro
  * @return: boolean
  **/
  public boolean getDidscoDuro(){ return this.discoDuro; }
  /**
  * Implementando el método de imprimeEspecificaciones
  * @return : String
  **/
  public String imprimeEspecificaciones(){
    return super.imprimeEspecificaciones()+"\nTamaño: "+this.tamano+ "\nModelo del monitor: "+this.modeloMonitor+"\nDisco duro: "+this.discoDuro+"\n"; 
  }
}
