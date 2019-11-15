/**
* Clase abstracta ComputadoraSimple
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0
**/
public abstract class ComputadoraSimple implements TarjetaMadre{
  /* Variable que indica la memoria de la computadora */
  protected int memoria;
  /* Variable que indica la cantidad de puertos USB */
  protected int usb;
  /* Variable que indica si la computadora tiene puerto ethernet o no*/
  protected boolean puertoEthernet;

  /**
  * Constructor para la clase ComputadoraSimple
  *  @param : int getMemoria
  *  @param : int usb
  *  @param : boolean puertoEthernet
  **/
  public ComputadoraSimple(int memoria, int usb, boolean puertoEthernet){
    this.memoria = memoria;
    this.usb = usb;
    this.puertoEthernet = puertoEthernet;
  }

  /**
  * Método getter para el atributo memoria
  * @return: int
  **/
  public int getMemoria(){ return this.memoria; }
  /**
  * Método getter para el atributo usb
  * @return: boolean
  **/
  public int getUSB(){ return this.usb; }
  /**
  * Método getter para el atributo puertoEthernet
  * @return: boolean
  **/
  public boolean getPuertoEthernet(){ return this.puertoEthernet; }
  /**
  * Método getter para el atributo modelo
  * @return : String
  **/
  public String getModelo(){ return this.modelo; }
  /**
  * Método getter para el atributo RAM
  * @return : int
  **/
  public int getRAM(){ return this.RAM; }

  /**
  * Implementando el método de imprimeEspecificaciones
  * @return : String
  **/
  public String imprimeEspecificaciones(){
    return "RAM: "+this.RAM+"\nProcesador: "+this.modelo+"\nMemoria: "+this.memoria+"\nCantidad de puertos USB: "+this.usb+"\nPuerto Ethernet: "+this.puertoEthernet;
  }
}
