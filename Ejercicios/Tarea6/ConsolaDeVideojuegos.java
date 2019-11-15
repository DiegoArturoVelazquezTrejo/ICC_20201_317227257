/**
* Clase para ConsolaDeVideojuegos
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0
**/
public class ConsolaDeVideojuegos extends ComputadoraSimple{
  /* Variable que indica el modelo de la tarjeta de video   */
  protected String tarjetaDeVideo;
  /* Variable que indica si la consola es portatil   */
  protected boolean portatil;

  /**
  * Constructor para la clase Laptop
  *  @param : double getMemoria
  *  @param : int usb
  *  @param : boolean puertoEthernet
  **/
  public ConsolaDeVideojuegos(int memoria, int usb, boolean puertoEthernet, String tarjetaDeVideo, boolean portatil){
    super(memoria, usb, puertoEthernet);
    this.tarjetaDeVideo = tarjetaDeVideo;
    this.portatil = portatil;
  }

  /**
  * Método getter para el atributo tarjetaDeVideo
  * @return: String
  **/
  public String getTarjetaDeVideo(){ return this.tarjetaDeVideo; }
  /**
  * Método getter para el atributo portatil
  * @return: boolean
  **/
  public boolean getPortatil(){ return this.portatil; }
  /**
  * Implementando el método de imprimeEspecificaciones
  * @return : String
  **/
  @Override
  public String imprimeEspecificaciones(){
    return super.imprimeEspecificaciones() + "\nTarjeta de video: "+this.tarjetaDeVideo+"\nPortatil: "+this.portatil+"\n";
  }
}
