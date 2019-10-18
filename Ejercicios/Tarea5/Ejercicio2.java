/**
* Clase Ejercicio2
* @author: Diego Arturo Velázquez Trejo
* @version : 1.0
**/
public class Ejercicio2{
  /* arreglo de enteros de la clase*/
  private int[] arreglo;

  /**
  * Constructor de la clase Ejercicio2
  * @param : array de enteros
  **/
  public Ejercicio2(int[] arreglo){
    this.arreglo = new int[arreglo.length];
    for(int i = 0; i < arreglo.length; i++)
      this.arreglo[i] = arreglo[i];
  }
  /**
  * Método que calcula el porcentaje de igualdad de dos arreglos.
  * @param : arreglo de enteros.
  * @return : double -> porcentaje de igualdad.
  **/
  public double porcentajeDeIgualdad(int[] n){
    if(n.length != arreglo.length) return 0.0;
    double suma = 0;
    for(int i = 0; i < this.arreglo.length; i++)
      suma = suma + (arreglo[i]-n[i]);
    return suma/n.length;
  }
  /**
  * Método que te dice si la suma de la mitad izquierda de un arreglo es igual a la suma de la mitad derecha del arreglo.
  * @param : arreglo de enteros.
  * @return : boolean -> true si sus mitades son iguales / false si no son iguales.
  **/
  public boolean mitadesIguales(int[] arreglo){
    int mitad = arreglo.length/2;
    int suma1 = 0;
    int suma2 = 0;
    for(int i = 0; i < mitad; i++)
      suma1 = suma1 + arreglo[i];
    for(int i = arreglo.length-1; i >= mitad; i--)
      suma2 = suma2 + arreglo[i];
    return suma1 == suma2;
  }
  /**
  * Método que calcula la reversa de un arreglo.
  * @param : arreglo de enteros.
  * @return : arreglo de entros.
  **/
  public int[] reversa(){
    int[] arr = new int[arreglo.length];
    int a = 0;
    for(int i = arreglo.length-1; i >=0; i--)
      arr[i] = arreglo[a++];
    return arr;
  }
  /**
  * Método que inserta N ceros entre los números de un arreglo de enteros.
  * @param : int número de ceros.
  * @return : arreglo  de enteros.
  **/
  public int[] insertaNCeros(int entero){
    int[] arregloCeros = new int[arreglo.length + entero * (this.arreglo.length -1)];
    int cero = 0;
    int a = 0;
    for(int i = 0; i < arregloCeros.length; i++){
      if(cero == 0) arregloCeros[i] = arreglo[a++];
      else if(cero != 0) arregloCeros[i] = 0;
      if(cero == entero) cero = 0;
      else cero++;
    }
    return arregloCeros;
  }
  public int[] getArreglo(){
    return arreglo;
  }
  /* Método main de la clase Ejercicio2*/
  public static void main(String[] args){

    // Inicializando los arreglos para las pruebas
    int[] numeroCuenta = {3,1,7,2,2,7,2,5,7};
    int[] arregloIgual = {3,1,1,6,4,8,2,0,9};
    int[] arr = {1,3,8,9,0};
    int [] arr1 = {7,1,0,1,7};
    int[] arr2 = {3,6,5,0,9};

    // Instanciando un objeto de tipo Ejercicio2
    Ejercicio2 ej2 = new Ejercicio2(numeroCuenta);

    // Prueba para porcentajeDeIgualdad
    System.out.println(ej2.porcentajeDeIgualdad(arregloIgual));

    // Prueba para las mitades iguaels
    System.out.println(ej2.mitadesIguales(arr));
    System.out.println(ej2.mitadesIguales(arr1));
    System.out.println(ej2.mitadesIguales(arr2));

    // Prueba para la reversa de un arreglo
    int[] rev = ej2.reversa();
    for(int i = 0; i < rev.length; i++)
      System.out.print(rev[i] + " ");
    System.out.print("\n");

    // Pruebas para el método insertaNCeros
    int[] ceros1 = ej2.insertaNCeros(2);
    for(int i = 0; i < ceros1.length; i++)
      System.out.print(ceros1[i] + " ");

    System.out.println("\n");
    int[] ceros2 = ej2.insertaNCeros(6);
    for(int i = 0; i < ceros2.length; i++)
      System.out.print(ceros2[i] + " ");
  }
}
