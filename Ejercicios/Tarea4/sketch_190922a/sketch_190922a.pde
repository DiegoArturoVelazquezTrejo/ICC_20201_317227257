Punto a = new Punto(500, 250); 
Punto b = new Punto(250, 510); 
Punto c = new Punto(750, 510); 

int aumento = 10; 

Punto d = new Punto(50, 50);
Punto z = new Punto(400, 50); 
Triangulo triangulo = new Triangulo(a,b,c); 
Circulo circulo = new Circulo(d, 100); 
Circulo circulo1 = new Circulo(z, 100);
Circulo circulo2 = new Circulo(300, 300, 100);
Circulo circulo3 = new Circulo(700, 300, 100); 

void setup() {
       size(1000, 1000);
       stroke(255,255,255);
       background(34, 210, 190);
       println("Area del triangulo: "+triangulo.getArea());
       println("Perimetro del triangulo: "+triangulo.getPerimetro()); 
       println("Area del círculo: "+circulo.getArea());
       println("Perimetro del círculo: "+circulo.getPerimetro());
      
} 

void draw() { 
       background(random(0,255),random(0,255),random(0,255)); 
       triangulo.serpinsky(6); 
       circulo.circulinsky(5); 
       circulo1.circulinsky(5); 
       circulo2.circulinsky(5); 
       circulo3.circulinsky(5); 
       
       circulo.getCentro().setX((circulo.getCentro().getX()+aumento)); 
       circulo.getCentro().setY((circulo.getCentro().getY()+aumento)); 
       
       circulo1.getCentro().setX((circulo1.getCentro().getX()-aumento)); 
       circulo1.getCentro().setY((circulo1.getCentro().getY()-aumento)); 
       aumento = aumento+10; 
       
       if(aumento > 500){
         circulo.getCentro().setX(10); 
         circulo.getCentro().setY(10); 
         circulo1.getCentro().setX(900); 
         circulo1.getCentro().setY(900); 
         aumento = 0; 
       } 
}
