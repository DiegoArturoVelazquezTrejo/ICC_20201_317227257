package items;
/**
* Clase para modelar el comportamiento de una tarjeta de circuitos que todos los dispositivos tienen.
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0
**/

public class Tarjeta{
  /* Atributo de modelo*/
  protected int modelo;
  /* Atributo de la memoria */
  protected double capacidadMemoria;
  /* Atributo de Bus de la Tarjeta*/
  protected int bus;
  /* Atributo de Tamaño*/
  protected int tamano;

  /**
  * Constructor del objeto Tarjeta
  * @param : Integer -> Modelo de la tarjeta
  * @param : double -> Capacidad de Memoria de la tarjeta
  * @param : Integer -> Cantidad de bus
  **/
  public Tarjeta(int modelo, double capacidadMemoria, int bus){
    this.modelo = modelo;
    this.capacidadMemoria = capacidadMemoria;
    this.bus = bus;
    this.tamano = 20;
  }
  /**
  * getter del atributo modelo
  * @return : Integer -> Modelo
  **/
  public int getModelo(){return this.modelo; }
  /**
  * getter del atributo capacidadMemoria
  * @return : Double -> capacidadMemoria
  **/
  public double getCapacidadMemoria(){return this.capacidadMemoria; }
  /**
  * getter del atributo Bus
  * @return : Integer -> bus
  **/
  public int getBus(){ return this.bus; }
  /**
  * getter del atributo Tamano
  * @return : Integer -> Tamano
  **/
  public int getTamano(){ return this.tamano; }
  /**
  * setter del atributo modelo
  * @param : Integer -> modelo
  **/
  public void setModelo(int modelo){this.modelo = modelo; }
  /**
  * setter del atributo capacidadMemoria
  * @param : double -> Capacidad en memoria
  **/
  public void setCapacidadMemoria(double capacidad){ this.capacidadMemoria = capacidad; }
  /**
  * setter del atributo bus
  * @param : Integer -> bus
  **/
  public void setBus(int bus){ this.bus = bus; }
  /**
  * setter del atributo  tamano
  * @param : Integer -> tamano
  **/
  public void setTamano(int tamano){ this.tamano = tamano; }

  /**
  * Método toString de la clase Tarjeta
  * @return : toString
  **/
  @Override
  public String toString(){
    return "Tarjeta RAM: Modelo="+this.modelo+"\n"+"Capacidad: "+this.capacidadMemoria+"\n"+"Número de bus: "+this.bus+"\n"+"Tamaño: "+this.tamano;
  }
  /**
  * Método equals para comparar objetos
  * @param : Object o
  * @return : true -> son iguales, false -> no son iguales
  **/
  @Override
  public boolean equals(Object o){
    if(!(o instanceof Tarjeta)) return false;
    @SuppressWarnings("unchecked") Tarjeta t = (Tarjeta) o;
    return o.toString().equals(this.toString());
  }
}
