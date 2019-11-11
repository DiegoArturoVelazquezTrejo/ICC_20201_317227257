package shapesSVG;
/**
 * @author: Diego Arturo Velázquez Trejo
 * @version: 1.0
 * @date: 17 septiembre 2019
 * @class Triángulo
 * Clase que define a un triángulo
 **/

public class Triangulo extends Figura{

    /*Puntos de un triángulo*/
    private Vector2 a, b, c;

    /**
     * Constructor de la clase Triangulo
     * @param: Vectores de los tres lados del triángulo
     **/
    public Triangulo(Vector2 a, Vector2 b, Vector2 c){
      super();
    	this.a = a;
    	this.b = b;
    	this.c = c;
      this.perimetro = calculaPerimetro();
      this.area = calculaArea();
    }
    /**
     * Constructor de la clase triángulo
     * @param: 6 puntos double para los tres lados del triángulo
     **/
    public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3 ){
      	a = new Vector2(x1, y1);
      	b = new Vector2(x2, y2);
      	c = new Vector2(x3, y3);
      	this.perimetro = calculaPerimetro();
        this.area = calculaArea();
    }
    /*Constructor por imisión*/
    public Triangulo(){}
    /**
     * calculaPerímetro -> calcula el perímetro del triángulo
    **/
    public double calculaPerimetro(){
	     return this.perimetro = a.distancia(b) + b.distancia(c)+ c.distancia(a);
    }
    /* Método para calcular el área del triángulo */
    public double calculaArea(){
      double lado1 = a.distancia(b);
      double lado2 = b.distancia(c);
      double lado3 = c.distancia(a);
      double semiPerimetro = (lado1+lado2+lado3)/2;
      return Math.sqrt(Double.valueOf(semiPerimetro*(semiPerimetro-lado1)*(semiPerimetro-lado2)*(semiPerimetro-lado3)));
    }

    /*Getter del punto a del triángulo*/
    public Vector2 getA(){
	     return this.a;
    }
    /*Getter del punto b del triángulo*/
    public Vector2 getB(){
	     return this.b;
    }
    /*Getter del punto c del triángulo*/
    public Vector2 getC(){
	     return this.c;
    }
    /**
     * Setter del punto a del triángulo
     * @param: Vector2 nuevo punto
     **/
    public void setA(Vector2 a){
    	this.a = a;
    	this.perimetro = calculaPerimetro();
    }
    /**
     * Setter del punto b del triángulo
     * @param: Vector2 nuevo punto
     **/
    public void setB(Vector2 a){
        this.b = a;
        this.perimetro = calculaPerimetro();
    }
    /**
     * Setter del punto c del triángulo
     * @param: Vector2 nuevo punto                                                                                                          **/
    public void setC(Vector2 a){
        this.c = a;
        this.perimetro = calculaPerimetro();
    }
    /*Convierte los atributos de la figura en una etiqueda svg válida*/
    public String toSVG(){
    	return "<polygon points= '"+Double.toString(a.getX())+", "+Double.toString(a.getY())+", "+Double.toString(b.getX())+", "+Double.toString(b.getY())+", "+Double.toString(c.getX())+", "+Double.toString(c.getY())+
      "' stroke='blue' stroke-width=2 fill='transparent'/>";
    }

    /**
    * Método toString
    * @return: String del objeto
    **/
    @Override
    public String toString(){
    	return "Vector A: "+this.a.toString()+"\n"+
    	       "Vector B: "+this.b.toString()+"\n"+
    	       "Vector C: "+this.c.toString()+"\n"+
    	       super.toString();
    }

    /**
     *Método equals
     * @return: true/ si los objetos son iguales, false/ si los objetos son distintos
     **/
    @Override
    public boolean equals(Object o){
    	if(!(o instanceof Triangulo)) return false;
    	@SuppressWarnings("unchecked") Triangulo trian = (Triangulo) o;
    	return this.a.equals(trian.getA()) && this.b.equals(trian.getB()) && this.c.equals(trian.getC());
    }

    /*Serpinsky*/
    public String serpinsky(int n){
      if(n == 0) return "";
      Triangulo aux1 = new Triangulo(a, a.puntoMedio(b), a.puntoMedio(c));
      Triangulo aux2 = new Triangulo(a.puntoMedio(b), b, b.puntoMedio(c));
      Triangulo aux3 = new Triangulo(a.puntoMedio(c), c.puntoMedio(b), c);
      return this.toSVG() + aux1.serpinsky(n-1) + aux2.serpinsky(n-1)+aux3.serpinsky(n-1);
    }

    public void transformacion(Transformacion f ){
      this.a = f.transformacion(this.a);
      this.b = f.transformacion(this.b);
      this.c = f.transformacion(this.c);
    }
}
