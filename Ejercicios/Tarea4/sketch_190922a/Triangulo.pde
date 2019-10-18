/**
 * @author: Diego Arturo Velázquez Trejo
 * @version: 1.0
 * @date: 17 septiembre 2019
 * @class Triángulo
 * Clase que define a un triángulo
 **/

class Triangulo{

    /*Puntos de un triángulo*/
    Punto a, b, c;
    /*Perímetro del triángulo*/
    double perimetro;
    /*Área del triángulo*/
    double area;

    /**
     * Constructor de la clase Triangulo
     * @param: Vectores de los tres lados del triángulo
     **/
    public Triangulo(Punto a, Punto b, Punto c){
      this.a = a;
      this.b = b;
      this.c = c;
      this.perimetro = calculaPerimetro();
      this.area = calculaArea();
    }
    /**
     * Constructor de la clase triángulo
     * @param: 6 puntos float para los tres lados del triángulo
     **/
    public Triangulo(float x1, float y1, float x2, float y2, float x3, float y3 ){
        a = new Punto(x1, y1);
        b = new Punto(x2, y2);
        c = new Punto(x3, y3);
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
    /**
    * calculaAREA -> calcula el área del triángulo
    **/
    public double calculaArea(){
      double lado1 = a.distancia(b);
      double lado2 = b.distancia(c);
      double lado3 = c.distancia(a);
      double semiPerimetro = (lado1+lado2+lado3)/2;
      return Math.sqrt(Double.valueOf(semiPerimetro*(semiPerimetro-lado1)*(semiPerimetro-lado2)*(semiPerimetro-lado3)));
    }
    /*Getter del punto a del triángulo*/
    public Punto getA(){
       return this.a;
    }
    /*Getter del punto b del triángulo*/
    public Punto getB(){
       return this.b;
    }
    /*Getter del punto c del triángulo*/
    public Punto getC(){
       return this.c;
    }
    /*Getter del perímetro del triángulo*/
    public double getPerimetro(){
       return this.perimetro;
    }
    /*Getter para el área del triángulo*/
    public double getArea(){
      return this.area;
    }
    /**
     * Setter del punto a del triángulo
     * @param: Punto nuevo punto
     **/
    public void setA(Punto a){
      this.a = a;
      this.perimetro = calculaPerimetro();
      this.area = calculaArea();
    }
    /**
     * Setter del punto b del triángulo
     * @param: Punto nuevo punto
     **/
    public void setB(Punto a){
        this.b = a;
        this.perimetro = calculaPerimetro();
        this.area = calculaArea();
    }
    /**
     * Setter del punto c del triángulo
     * @param: Punto nuevo punto                                                                                                          **/
    public void setC(Punto a){
        this.c = a;
        this.perimetro = calculaPerimetro();
        this.area = calculaArea();
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
             "Area: "+this.area+", Perímetro: "+this.perimetro;
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
    public void serpinsky(int n){
      if(n == 0) return;
      Triangulo aux1 = new Triangulo(a, a.puntoMedio(b), a.puntoMedio(c));
      Triangulo aux2 = new Triangulo(a.puntoMedio(b), b, b.puntoMedio(c));
      Triangulo aux3 = new Triangulo(a.puntoMedio(c), c.puntoMedio(b), c);
      triangle(a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY()); 
      aux1.serpinsky(n-1); 
      aux2.serpinsky(n-1); 
      aux3.serpinsky(n-1);
    }

}
