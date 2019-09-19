package shapesSVG;

public class Main{
    public static void main(String args[]){

        String inicio = "<svg height='700' width='700'>";
        System.out.println(inicio);

      	Circulo circulo = new Circulo (100, 100, 100);
      	Rectangulo rectangulo = new Rectangulo(200, 200, 200, 200);
      	Vector2 a = new Vector2(100,10);
      	Vector2 b = new Vector2(190, 190);
      	Vector2 c = new Vector2(10, 190);
        Vector2 l = new Vector2(400, 200);
        Vector2 l1 = new Vector2(700, 700);
      	Triangulo triangulo = new Triangulo(a, b, c);
      	Linea linea = new Linea(l, l1);

      	System.out.println(circulo.toSVG());
      	System.out.println(rectangulo.toSVG());
      	System.out.println(triangulo.toSVG());
      	System.out.println(linea.toSVG());

        String cierre = "</svg>";
        System.out.println(cierre);
    }
}
