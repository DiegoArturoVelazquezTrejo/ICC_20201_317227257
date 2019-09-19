package shapesSVG;

/**
 * @author: Diego Arturo Velázquez Trejo
 * @version: 1.0
 * @date: 17 septiembre 2019
 * @class Vector2
 * Clase que define un vector con sus componentes (magnitud)
 **/

public class Vector2{

    /*X, Y componentes en el plano 2D de un vector*/
    private double x, y;
    /*Magnitud del vector*/
    private double magnitud;

    /*Constructor por omisión*/
    public Vector2(){
    	this.x = this.y = 0;
    }

    /**
     * Constructor Vector2
     * @param: double x, double y (Componentes x, y del vector en 2D)
     */
    public Vector2(double x, double y){
    	this.x = x;
    	this.y = y;
    }

    /**
     * Calcular la distancia entre dos vectores
     * @param: Vector2
     **/
    public double distancia(Vector2 vector){
    	double distancia = 0;
    	distancia = Math.sqrt(Math.pow(vector.getX()-this.x, 2)+ Math.pow(vector.getY()-this.y, 2));
    	return distancia;
    }

    /*Getter del parámetro x*/
    public double getX(){
	     return this.x;
    }
    /*Getter del parámetro y*/
    public double getY(){
	     return this.y;
    }
    /*Getter del parámetro magnitud*/
    public double getMagnitud(){
	     return this.magnitud;
    }

    /**Setter del parámetro x
     * @param:  double x;
     **/
    public void setX(double x){
	      this.x = x;
    }

    /**Setter del parámetro y
     * @param: double y;
    **/
    public void setY(double y){
    	this.y = y;
    }

    /**
     *Método equals
     * @return: true/ si los objetos son iguales, false/ si los objetos son distintos
     **/
    @Override
    public boolean equals(Object o){
      	if(!(o instanceof Vector2)) return false;
      	@SuppressWarnings("unchecked") Vector2 vector = (Vector2) o;
      	return (vector.getX()== this.x) && (vector.getY() == this.y) && (vector.getMagnitud() == this.magnitud);
    }

    /**
    * Método toString
    * @return: String del objeto
    **/
    @Override
    public String toString(){
    	return "X: "+this.x+", Y: "+this.y+", Magnitud: "+this.magnitud;
    }

    /*Método que convierte */
    public String toSVG(){
    	return "<circle cx=" +"'"+this.x+"'"+ "cy="+"'" + this.y +"'"+ "r='40' stroke='green' stroke-width='4' fill='yellow' />";
    }

    /**
    * Punto medio entre los lados de un triangulo
    **/
    public Vector2 puntoMedio(Vector2 vector1){
      Vector2 vectorMedio = new Vector2((this.x+vector1.getX())/2, (this.y+vector1.getY())/2);
      return vectorMedio; 
    }

}
