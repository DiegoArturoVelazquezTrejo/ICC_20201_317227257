/**
  @author: Luis Méndez, Diego Arturo Velázquez
  @date: 9 de Septiembre, 2019.
  @version: 1.0
**/


public class Arbol{

  private String nombre;
  private boolean flor;
  private boolean semilla;
  private boolean frutos;
  private double costo;

  // COnstructor inicializando los parámetros de entrada:
  /**
  @param nombre: String nombre de la flor
  @param flor: booleano indicando si tiene flor
  @param semilla: booleano indicando si se reproduce por semilla
  @param frutos: booleano indicando si tiene frutos o no
  @param costo: double indicando el costo de la flor
  **/
  public Arbol(String nombre, boolean flor, boolean semilla, boolean frutos, double costo){
    this.nombre = nombre;
    this.flor = flor;
    this.semilla = semilla;
    this.frutos = frutos;
    this.costo = costo;
  }

  /**
  @param nombre: String nombre nuevo del Arbol
  **/
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  /**
  @param costo: Double nuevo costo del Arbol
  **/  
  public void setCosto(double costo){
    this.costo = costo;
  }

  /**
  @param fruto: Boolean definir si ahora tiene fruto o no
  **/  
  public void setFruto(boolean fruto){
    this.frutos = frutos;
  }

  /**
  @param semilla: Boolean definir si ahora tiene semilla o no
  **/  
  public void setSemilla(boolean semilla){
    this.semilla = semilla;
  }

  /**
  @param flor: Boolean definir si ahora tiene flor o no
  **/  
  public void setFlor(boolean flor){
    this.flor = flor;
  }

  // Getters para los atributos de la clase
    
  public String getNombre(){
    return this.nombre;
  }
  public double getCosto(){
    return this.costo;
  }
  public boolean getFlor(){
    return this.flor;
  }
  public boolean getSemilla(){
    return this.semilla;
  }
  public boolean getFruto(){
    return this.frutos;
  }

  // Método toString para imprimir los atributos del objeto
  @Override
  public String toString(){
    String cadena = "";
    cadena = "Nombre: "+this.getNombre()+" Costo: "+this.getCosto()+" Flor: "+this.getFlor()+" Semilla: "+this.getSemilla()+" Fruto: "+this.getFruto()+" .";
    return cadena;
  }


  public static void main(String args[]){
    Arbol syzygium = new Arbol("Syzygium Oligarae", true, true, true, 14.50);
    Arbol serrulato = new Arbol("Prunus Serrulato", true, true, true, 13.90);

    System.out.print(syzygium);
    System.out.print("\n");
    System.out.print(serrulato);
  }

}