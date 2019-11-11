import shapesSVG.*;
public class Main{
    public static void main(String args[]){

      	Circulo circulo = new Circulo (400, 400, 400);
        Circulo circulo1 = new Circulo (500,500,500);
      	Rectangulo rectangulo = new Rectangulo(200, 200, 200, 200);
        Rectangulo rectangulo1 = new Rectangulo(200,200,200,200);

      	Vector2 a = new Vector2(650,30);
      	Vector2 b = new Vector2(375, 350);
      	Vector2 c = new Vector2(900, 350);

        Vector2 a1 = new Vector2(100,30);
      	Vector2 b1 = new Vector2(200, 350);
      	Vector2 c1 = new Vector2(700, 350);

        Vector2 a2 = new Vector2(200,30);
      	Vector2 b2 = new Vector2(0, 350);
      	Vector2 c2 = new Vector2(400, 350);

        Vector2 l = new Vector2(400, 200);
        Vector2 l1 = new Vector2(700, 700);
        Linea linea = new Linea(l, l1);


      	Triangulo triangulo = new Triangulo(a, b, c);
        Triangulo triangulo2 = new Triangulo(a1, b1, c1);
        Triangulo triangulo3 = new Triangulo(a2,b2,c2);

        System.out.println("Aplicando funciones anónimas");
        System.out.println(triangulo);
        
        triangulo.transformacion( (Vector2 vector) -> ( new Vector2(vector.getX() + 10, vector.getY() + 10) ));


        System.out.println(triangulo);
        System.out.println("Comparando figuras: ");
      	System.out.println(circulo1.compareTo(circulo));
        System.out.println(rectangulo.compareTo(rectangulo1));
        System.out.println(triangulo.compareTo(triangulo3));
        System.out.println(triangulo2.compareTo(triangulo));

    }
}
