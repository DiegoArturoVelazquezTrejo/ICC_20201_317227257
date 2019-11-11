package shapesSVG;
/**
 * @author: Diego Arturo Velázquez Trejo
 * @version: 1.0
 * @date: 17 septiembre 2019
 * @class Vector2
 * Clase que define una línea usando vectores
 **/

public class Linea{

    /*Vectores a y b de la línea*/
    private Vector2 a, b;
    /*Distancia de los dos vectores*/
    private double distancia;

    /*Constructor por omisión*/
    public Linea(){}
    /**
     * Constructor
     * @param: Vector2 a, b de la línea
     ***/
    public Linea(Vector2 a, Vector2 b){
    	this.a = a;
    	this.b = b;
    	this.distancia = a.distancia(b);
    }
    /*Getter del punto a*/
    public Vector2 getA(){
	     return this.a;
    }
    /*Getter del punto b*/
    public Vector2 getB(){
	     return this.b;
    }
    /*Getter de la distancia entre los dos puntos de la línea*/
    public double getDistancia(){
	     return this.distancia;
    }
    /**
     * Setter del vector a
     * @param: Vector2 nuevo
     ***/
    public void setA(Vector2 a){
	     this.a = a;
    }
    /**
     * Setter del vector b
     * @param: Vector2 nuevo
     **/
    public void setB(Vector2 b){
	     this.b = b;
    }

    /*Convierte a string las propiedades para pasar la etiqueta a processing*/
    public String toSVG(){
    	return "<line x1= "+"'"+this.a.getX()+"'"+" x2="+"'"+this.b.getX()+"'"+" y1="+"'"+this.a.getY()+"'"+" y2="+"'"+this.b.getY()+"'"+" stroke='orange'/>";
    }

    /*ToString del objeto línea*/
    @Override
    public String toString(){
    	return "El vector A: "+this.a.toString()+"\n"+
    	       "El vector B: "+this.b.toString()+"\n"+
    	       "Distancia: "+this.distancia;
    }

    /**
     *Método equals
     * @return: true/ si los objetos son iguales, false/ si los objetos son distintos                                                      **/
    @Override
    public boolean equals(Object o){
    	if(!(o instanceof Linea)) return false;
    	@SuppressWarnings("unchecked") Linea linea = (Linea) o;
    	return this.a.equals(linea.getA()) && this.b.equals(linea.getB());
    }

}
