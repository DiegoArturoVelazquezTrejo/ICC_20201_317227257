  /**
 * @author: Diego Arturo Velázquez Trejo
 * @version: 1.0
 * @date: 17 septiembre 2019
 * @class Círculo
 * Clase que define a un Círculo
 **/
public class Circulo{
    /*Centro del círculo*/
    Punto centro;
    /*Radio del círculo*/
    float radio;
    /*Perímetro del círculo*/
    float perimetro;
    /*Área del círculo*/
    float area;

    /**
     * Constructor de la clase círculo
     * @param: Punto, radio del círculo
     **/
    public Circulo(Punto a, float radio){
      this.centro = a;
      this.radio = radio;
      this.perimetro = calculaPerimetro();
      this.area = calculaArea();
    }

    /**
     * Constructor de la clase círculo
     * @param: dos puntos para iniciar el vector del centro y el radio del círculo
     **/
    public Circulo(float x, float y, float radio){
        this.centro = new Punto(x, y);
        this.radio = radio;
        this.perimetro = calculaPerimetro();
        this.area = calculaArea();
    }

    /*Constructor por omisión de la clase círculo*/
    public Circulo(){}
    /*Método que calcula el área del círculo*/
    public float calculaArea(){
       return this.radio * this.radio * 3.1416;
    }
    /*Método que calcula el perímetro del círculo*/
    public float calculaPerimetro(){
       return 3.1416 * (2 * this.radio);
    }
    /*Getter del centro del círculo*/
    public Punto getCentro(){
       return this.centro;
    }
    /*Getter del radio del círculo*/
    public float getRadio(){
       return this.radio;
    }
    /*Getter del área del círculo*/
    public float getArea(){
       return this.area;
    }
    /*Getter del perímetro del círculo*/
    public float getPerimetro(){
       return this.perimetro;
    }
    /**
     * Setter del radio del círculo
     * @param: float radio del círculo
     **/
    public void setRadio(float radio){
      this.radio = radio;
      this.perimetro = calculaPerimetro();
      this.area = calculaArea();
    }
    /**
     * Setter del centro
     * @param: Punto para el nuevo centro del círculo
     **/
    public void setCentro(Punto a){
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
             "Área: "+this.area+"\n"+
             "Perímetro: "+this.perimetro;
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
    public void circulinsky(int n){
        if(n == 0) return;
        else{
            //El cícrulo tiene un vector que es el centro del mismo y tiene un radio
            Punto norte = new Punto(this.centro.getX(), this.centro.getY()-this.radio);
            Punto sur   = new Punto(this.centro.getX(), this.centro.getY()+this.radio);
            Punto este  = new Punto(this.centro.getX()+this.radio, this.centro.getY());
            Punto oeste = new Punto(this.centro.getX()-this.radio, this.centro.getY());

            Circulo cir1 = new Circulo(norte.puntoMedio(this.centro), this.radio/2);
            Circulo cir2 = new Circulo(sur.puntoMedio(this.centro), this.radio/2);
            Circulo cir3 = new Circulo(este.puntoMedio(this.centro), this.radio/2);
            Circulo cir4 = new Circulo(oeste.puntoMedio(this.centro), this.radio/2);
    
            fill(random(0,255),random(0,255),random(0,255));
            ellipse(this.centro.getX(), this.centro.getY(), this.radio, this.radio);
            cir1.circulinsky(n-1);
            cir2.circulinsky(n-1);
            cir3.circulinsky(n-1);
            cir4.circulinsky(n-1);
        }
    }

}
