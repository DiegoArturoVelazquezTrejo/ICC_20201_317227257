/**
* Clase para Laptop
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0
**/
public class Laptop extends ComputadoraSimple{
  /* Variable que indica el tamano de la pantalla  */
  protected float tamanoPantalla;
  /* Variable que indica el peso de la laptop  */
  protected float peso;
  /* Variable que indica si la laptop tiene carga rápida */
  protected boolean cargaRapida;
  /* Variable que indica si la laptop tiene camara integrada */
  protected boolean camaraIntegrada;
  /* Atributo que indica si la laptop tiene wifi */
  protected boolean wifi;


  /**
  * Constructor para la clase Laptop
  *  @param : float getMemoria
  *  @param : int usb
  *  @param : boolean puertoEthernet
  *  @param : float tamanoPantalla
  *  @param : float peso
  *  @param : boolean cargaRapida
  *  @param : boolean camaraIntegrada
  *  @param : boolean wifi
  **/
  public Laptop(int memoria, int usb, boolean puertoEthernet, float tamanoPantalla, float peso, boolean cargaRapida, boolean camaraIntegrada, boolean wifi){
    super(memoria, usb, puertoEthernet);
    this.tamanoPantalla = tamanoPantalla;
    this.peso = peso;
    this.cargaRapida = cargaRapida;
    this.camaraIntegrada = camaraIntegrada;
    this.wifi = wifi;
  }

  /**
  * Método getter para el atributo tamanoPantalla
  * @return: float
  **/
  public float getTamanoPantalla(){ return this.tamanoPantalla; }
  /**
  * Método getter para el atributo peso
  * @return: float
  **/
  public float getPeso(){ return this.peso; }
  /**
  * Método getter para el atributo cargaRapida
  * @return: boolean
  **/
  public boolean getCargaRapida(){ return this.cargaRapida; }
  /**
  * Método getter para el atributo camaraIntegrada
  * @return: boolean
  **/
  public boolean getCamaraIntegrada(){ return this.camaraIntegrada; }
  /**
  * Método getter para el atributo wifi
  * @return: boolean
  **/
  public boolean getWifi(){ return this.wifi; }
  /**
  * Implementando el método de imprimeEspecificaciones
  * @return : String
  **/
  public String imprimeEspecificaciones(){
    return super.imprimeEspecificaciones()+ "\nTamaño pantalla: "+this.tamanoPantalla+ "\nPeso: "+this.peso+"\nCarga Rápida: "+this.cargaRapida+"\nCamara integrada: "+this.camaraIntegrada+"\nWIFI: "+this.wifi+"\n";
  }
}
