package shapesSVG;
/**
 * @author: Diego Arturo Velázquez Trejo
 * @version: 1.0
 * @date: 17 septiembre 2019
 * @class Rectángulo
 * Clase que define a un rectángulo
 **/

public class Rectangulo{
    /*Vector2 del rectángulo*/
    private Vector2 a;
    /*Ancho del rectángulo*/
    private double ancho;
    /*Alto del rectángulo*/
    private double alto;
    /*Perímetro del rectángulo*/
    private double perimetro;
    /*Área del rectángulo*/
    private double area;

    /**
    * Constructor del rectángulo
    * @param: Vector2, double ancho y alto del rectángulo
    **/
    public Rectangulo(Vector2 a, double ancho, double alto){
    	this.a = a;
    	this.ancho = ancho;
    	this.alto = alto;
    	this.perimetro = 2 * ancho + 2 * alto;
    	this.area = ancho * alto;
    }
    /**
    * Constructor del rectángulo
    * @param: dos puntos double para crear un vector2, double ancho y alto del rectángulo
    **/
    public Rectangulo(double x, double y, double ancho, double alto){
      	this.a = new Vector2(x, y);
      	this.ancho = ancho;
      	this.alto = alto;
      	this.perimetro = 2 * ancho + 2 * alto;
        this.area = ancho * alto;
    }
    /**
    * Constructor por omisión del rectángulo
    **/
    public Rectangulo(){}
    /*Getter del vector A del rectángulo*/
    public Vector2 getA(){
	     return this.a;
    }
    /*Getter del ancho del rectángulo*/
    public double getAncho(){
	     return this.ancho;
    }
    /*Getter del alto del rectángulo*/
    public double getAlto(){
	     return this.alto;
    }
    /*Getter del área del rectángulo*/
    public double getArea(){
	     return this.area;
    }
    /*Getter del perímetro del recángulo*/
    public double getPerimetro(){
	     return this.perimetro;
    }

    /**Setter del vector a del rectángulo:
     * @param: Vector2
     **/
    public void setA(Vector2 a){
	     this.a = a;
    }

    /**
     * Setter del ancho del rectángulo
     * @param: double ancho
     **/
    public void setAncho(double ancho){
  	   this.ancho = ancho;
  	   this.area = this.alto* ancho;
  	   this.perimetro = this.alto * 2 + 2 * ancho;
    }

    /**
     * Setter del alto del rectángulo
     * @param: double alto
     **/
    public void setAlto(double alto){
    	this.alto = alto;
    	this.area = this.ancho * alto;
    	this.perimetro = this.ancho * 2 + 2* alto;
    }
    /*ToSVG convierte a una etiqueta las propiedades del rectángulo*/
    public String toSVG(){
    	return "<rect x="+"'"+this.a.getX()+"'"+" y="+"'"+this.a.getY()+"'"+" width="+"'"+this.ancho+"'"+" height="+"'"+this.alto+"'"+" fill='transparent' stroke='blue'/>";
    }
    /**
     *Método equals
     * @return: true/ si los objetos son iguales, false/ si los objetos son distintos
     **/
    @Override
    public boolean equals(Object o){
    	if(!(o instanceof Rectangulo))return false;
    	@SuppressWarnings("unchecked") Rectangulo rec = (Rectangulo) o;
    	return this.a.equals(rec.getA()) && this.ancho == rec.getAncho() && this.alto == rec.getAlto();
    }

    /**
    * Método toString
    * @return: String del objeto
    **/
    @Override
    public String toString(){
      	return "Alto: "+this.alto+"\n"+
      	       "Ancho: "+this.ancho+"\n"+
      	       "Area: "+this.area+"\n"+
      	       "Perimetro: "+this.perimetro+"\n"+
      	       "Vector a: "+this.a.toString();
    }

    /**
    * Cuadros recursivos dentro de otros cuadros
    **/
    public String cuadros(int n){
      if(n == 0) return "";
      else{
        Rectangulo rec = new Rectangulo(new Vector2(this.a.getX()+50, this.a.getY()+50), (this.ancho-this.ancho/4), (this.alto-this.alto/4));
        return this.toSVG()+rec.cuadros(n-1);
      }
    }
}
