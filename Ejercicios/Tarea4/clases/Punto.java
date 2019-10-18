/**
 * @author: Diego Arturo Velázquez Trejo
 * @version: 1.0
 * @date: 17 septiembre 2019
 * @class Punto
 * Clase que define un vector con sus componentes (magnitud)
 **/

class Punto{

    /*X, Y componentes en el plano 2D de un vector*/
    float x, y;
    /*Magnitud del vector*/
    float magnitud;

    /*Constructor por omisión*/
    public Punto(){
      this.x = this.y = 0;
    }

    /**
     * Constructor Punto
     * @param: double x, double y (Componentes x, y del vector en 2D)
     */
    public Punto(float x, float y){
      this.x = x;
      this.y = y;
    }

    /**
     * Calcular la distancia entre dos vectores
     * @param: Punto
     **/
    public double distancia(Punto vector){
      double distancia = 0;
      distancia = Math.sqrt(Math.pow(Double.valueOf(vector.getX()-this.x), 2)+ Math.pow(Double.valueOf(vector.getY()-this.y), 2));
      return distancia;
    }

    /*Getter del parámetro x*/
    public float getX(){
       return this.x;
    }
    /*Getter del parámetro y*/
    public float getY(){
       return this.y;
    }
    /*Getter del parámetro magnitud*/
    public float getMagnitud(){
       return this.magnitud;
    }

    /**Setter del parámetro x
     * @param:  double x;
     **/
    public void setX(float x){
        this.x = x;
    }

    /**Setter del parámetro y
     * @param: double y;
    **/
    public void setY(float y){
      this.y = y;
    }

    /**
     *Método equals
     * @return: true/ si los objetos son iguales, false/ si los objetos son distintos
     **/
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Punto)) return false;
        @SuppressWarnings("unchecked") Punto vector = (Punto) o;
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

    /**
    * Punto medio entre los lados de un triangulo
    **/
    public Punto puntoMedio(Punto vector1){
      Punto vectorMedio = new Punto((this.x+vector1.getX())/2, (this.y+vector1.getY())/2);
      return vectorMedio;
    }

}
