/**
* Clase Ejercicio1
* @author: Diego Arturo Velázquez Trejo
* @version : 1.0
**/

public class Ejercicio1{

  /*atributo entero de la clase */
  private int entero;
  /* atributo de enetros de la clase*/
  private int[] enteros;

  /**
  * Constructor de la clase
  * @param : array[] de enteros
  * @param : entero
  **/
  public Ejercicio1(int[] enteros, int entero){
    this.entero = entero;
    this.enteros = new int[enteros.length];
    for(int i = 0; i < enteros.length; i++)
      this.enteros[i] = enteros[i];
  }
  /**
  * Método que multiplica por dos un entero
  * @param : entero
  * @return : entero
  **/
  public int multiplicaIntPor2(int numero){
    return numero * 2;
  }
  /**
  * Método que multiplica por dos los elementos de un arreglo.
  * @param : array de eneros
  * @return : array de enteros
  **/
  public int[] multiplicaArregloPor2(int[] n){
    int[] arreglo = n;
    for(int i = 0; i < arreglo.length; i++)
      arreglo[i] = arreglo[i] * 2;
    return arreglo;
  }
  /* Getter del atributo de arreglo de enteros*/
  public int[] getEnteros(){
    return this.enteros;
  }
  /**
  * Método main para probar la clase de Ejercicio1
  **/
  public static void main(String[] args){
    int[] numeroCuenta = {3,1,7,2,2,7,2,5,7};
    Ejercicio1 ej1 = new Ejercicio1(numeroCuenta, 10);

    // Prueba para el método de multiplicaIntPor2
    System.out.println(ej1.multiplicaIntPor2(ej1.entero));
    System.out.println(ej1.entero);

    // Prueba para el método de multiplicaArregloPor2
    int[] arreglo = ej1.multiplicaArregloPor2(ej1.enteros);
    for(int i = 0; i < arreglo.length; i++)
      System.out.print(arreglo[i] + " ");
    System.out.print("\n");
    for(int i = 0; i < ej1.getEnteros().length; i++)
      System.out.print(ej1.getEnteros()[i] + " ");
  }
}
