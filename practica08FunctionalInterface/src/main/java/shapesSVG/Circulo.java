package shapesSVG;
/**
 * @author: Diego Arturo Velázquez Trejo
 * @version: 1.0
 * @date: 17 septiembre 2019
 * @class Círculo
 * Clase que define a un Círculo
 **/


public class Circulo extends Figura{
    /*Centro del círculo*/
    private Vector2 centro;
    /*Radio del círculo*/
    private double radio;
    /**
     * Constructor de la clase círculo
     * @param: Vector2, radio del círculo
     **/
    public Circulo(Vector2 a, double radio){
      super();
    	this.centro = a;
    	this.radio = radio;
    	this.perimetro = calculaPerimetro();
    	this.area = calculaArea();
    }

    /**
     * Constructor de la clase círculo
     * @param: dos puntos para iniciar el vector del centro y el radio del círculo
     **/
    public Circulo(double x, double y, double radio){
	      this.centro = new Vector2(x, y);
	      this.radio = radio;
        this.perimetro = calculaPerimetro();
        this.area = calculaArea();
    }

    /*Constructor por omisión de la clase círculo*/
    public Circulo(){}
    /*Método que calcula el área del círculo*/
    public double calculaArea(){
	     return this.radio * this.radio * 3.1416;
    }
    /*Método que calcula el perímetro del círculo*/
    public double calculaPerimetro(){
	     return 3.1416 * (2 * this.radio);
    }
    /*Método que convierte los atributos de la figura a una etiqueta SVG*/
    public String toSVG(){
	     return "<circle cx=" +"'"+this.centro.getX()+"'"+ " cy="+"'" + this.centro.getY()+"'" + " r="+"'"+this.radio+"'"+" stroke='black' stroke-width='4' fill='transparent' />";
    }
    /*Getter del centro del círculo*/
    public Vector2 getCentro(){
	     return this.centro;
    }
    /*Getter del radio del círculo*/
    public double getRadio(){
	     return this.radio;
    }
    /**
     * Setter del radio del círculo
     * @param: double radio del círculo
     **/
    public void setRadio(double radio){
    	this.radio = radio;
    	this.perimetro = calculaPerimetro();
    	this.area = calculaArea();
    }
    /**
     * Setter del centro
     * @param: Vector2 para el nuevo centro del círculo
     **/
    public void setCentro(Vector2 a){
    	this.centro = a;
    }
    /**
    * Método toString
    * @return: String del objeto
    **/
    @Override
    public String toString(){
    	return "Centro: "+this.centro.toString()+"\n"+
    	       "Radio: "+this.radio+"\n"+
    	       super.toString();
    }

    /**
     *Método equals
     * @return: true/ si los objetos son iguales, false/ si los objetos son distintos
     **/
    @Override
    public boolean equals(Object o){
    	if(!(o instanceof Circulo)) return false;
    	@SuppressWarnings("unchecked") Circulo cir = (Circulo) o;
    	return this.radio == cir.getRadio() && this.centro.equals(cir.getCentro());
    }

    /**
     * Círculos recursivos dentro de otros
     **/
    public String circulinsky(int n){
        if(n == 0) return "";
        else{
            //El cícrulo tiene un vector que es el centro del mismo y tiene un radio
            Vector2 norte = new Vector2(this.centro.getX(), this.centro.getY()-this.radio);
            Vector2 sur   = new Vector2(this.centro.getX(), this.centro.getY()+this.radio);
            Vector2 este  = new Vector2(this.centro.getX()+this.radio, this.centro.getY());
            Vector2 oeste = new Vector2(this.centro.getX()-this.radio, this.centro.getY());

            Circulo cir1 = new Circulo(norte.puntoMedio(this.centro), this.radio/2);
            Circulo cir2 = new Circulo(sur.puntoMedio(this.centro), this.radio/2);
            Circulo cir3 = new Circulo(este.puntoMedio(this.centro), this.radio/2);
            Circulo cir4 = new Circulo(oeste.puntoMedio(this.centro), this.radio/2);

            return this.toSVG()+cir1.circulinsky(n-1)+cir2.circulinsky(n-1)+cir3.circulinsky(n-1)+cir4.circulinsky(n-1);
        }

    }
}
