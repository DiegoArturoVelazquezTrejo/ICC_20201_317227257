/**
* Clase Main
* @author: Diego Velázquez
* @version : 1.0
**/
public class Main{
  public static void main(String args[]){
    // Creando un objeto de la clase Calculadora
    Calculadora calc = new Calculadora(true, false, true);
    // Creando un objeto de la clase ComputadoraEscritorio
    ComputadoraEscritorio escritorio = new ComputadoraEscritorio(4,2,true,15,"HP",true);
    // Creando un objeto de la clase Laptop
    Laptop laptop = new Laptop(256,3,false,15,499,true,true,true);
    // Creando un objeto de la clase ConsolaDeVideojuegos
    ConsolaDeVideojuegos consola = new ConsolaDeVideojuegos(32,2,true,"Nintendo",true);

    System.out.println("----------------------------------------");
    System.out.println("Calculadora Casio FX-991EZ");
    System.out.println(calc.imprimeEspecificaciones());
    System.out.println("----------------------------------------");
    System.out.println("Computadora HP Escritorio ");
    System.out.println(escritorio.imprimeEspecificaciones());
    System.out.println("----------------------------------------");
    System.out.println("Laptop Huawei ");
    System.out.println(laptop.imprimeEspecificaciones());
    System.out.println("----------------------------------------");
    System.out.println("Consola Nindento ");
    System.out.println(consola.imprimeEspecificaciones());
    System.out.println("----------------------------------------");
  }
}
