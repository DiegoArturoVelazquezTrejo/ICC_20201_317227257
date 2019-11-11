package shapesSVG;
/**
* Clase abstracta de Figura para modelar figuras
* @author: Diego Arturo Velazquez Trejo
* @version: 1.0
**/

public abstract class Figura implements Comparable<Figura>{
  /* Atributo del área de la figura */
  protected double area;
  /* Atributo del perímetro de la figura */
  protected double perimetro;
  /* Constructor por omisión para la calse Figura */
  public Figura(){}
  /* Método abstracto para calcular el área de la figura */
  abstract public double calculaArea();
  /* Método abstracto para calcular el perímetro de la figura */
  abstract public double calculaPerimetro();
  /* Método abstracto toSVG de cada figura */
  abstract public String toSVG();
  /* Método  compareTo para comparar objetos */
  @Override
  public int compareTo(Figura figura){
    if(this.area < figura.getArea()) return -1;
    if(this.area>figura.getArea()) return 1;
    if(this.area == figura.getArea()) return 0;
    return -1; 
  }
  /**
  * Método equals para comparar figuras con base en su área y perímetro
  * @param : Object o
  **/
  @Override
  public boolean equals(Object o){
    if(!(o instanceof Figura)) return false;
    @SuppressWarnings("unchecked") Figura f = (Figura) o;
    return (f.calculaArea() == this.area) && (f.calculaPerimetro()==this.perimetro);
  }
  /**
  * Método toString de la clase Figura
  * @return String
  **/
  @Override
  public String toString(){
    return "Perímetro: "+this.perimetro+ ", Area: "+this.area;
  }
  /*Getter del área de la figura*/
  public double getArea(){
     return this.area;
  }
  /*Getter del perímetro de la figura */
  public double getPerimetro(){
     return this.perimetro;
  }
}
