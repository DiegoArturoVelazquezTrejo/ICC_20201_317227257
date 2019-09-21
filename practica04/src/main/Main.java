package shapesSVG;

public class Main{
    public static void main(String args[]){

        String inicio = "<svg height='700' width='1000'>";
        System.out.println(inicio);

      	Circulo circulo = new Circulo (400, 400, 400);
      	Rectangulo rectangulo = new Rectangulo(200, 200, 200, 200);

      	Vector2 a = new Vector2(650,30);
      	Vector2 b = new Vector2(375, 350);
      	Vector2 c = new Vector2(900, 350);

        Vector2 a1 = new Vector2(450,30);
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


      	System.out.println(circulo.circulinsky(6));
        System.out.println(rectangulo.cuadros(10));
      	//System.out.println(rectangulo.toSVG());
        //System.out.println(linea.toSVG());

      	System.out.println(triangulo.serpinsky(10));
        //System.out.println(triangulo2.serpinsky(7));
        //System.out.println(triangulo3.serpinsky(7));

        String cierre = "</svg>";
        System.out.println(cierre);
    }
}
