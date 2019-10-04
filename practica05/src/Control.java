import java.util.Comparator;
import java.util.ArrayList;
/**
* @class : Control, práctica 5
* @author: Diego ARturo Velázquez Trejo
* @version: 1.0
**/

public class Control{
  /*COnstructor por omisión privado para evitar instanciar la clase ya que sus métodos serán estáticos*/
  private Control(){}

  /**
  * reversa te regresa la cadena reversa de una cadena.
  * @param : String cadena
  * @return : String cadena invertida
  **/
  private static String reversa(String palabra){
    String reversa = "";
    for(int i = palabra.length()-1; i>-1; i--)
      reversa = reversa+ palabra.charAt(i);
    return reversa;
  }
  /**
  * palíndromo : te dice si una cadena es palíndromo o no.
  * @param : String cadena
  * @return : boolean <p> true si es palíndromo </p> <p> false si no es palíndromo </p>
  **/
  public static boolean palindromo(String cadena){
    return cadena.equals(reversa(cadena));
  }

  private static <T extends  Comparable<T>> void quickSort(T[] arreglo){
    quickSort(arreglo, (a, b) -> a.compareTo(b), 0, arreglo.length - 1);
  }
  private static <T extends  Comparable<T>> void quickSort(T[] arreglo, Comparator<T> comparador, int a, int b){
    if(b<=a) return;
    int i = a + 1;
    int j = b;
    while(i<j){
      if(comparador.compare(arreglo[i], arreglo[a]) > 0 &&  comparador.compare(arreglo[a], arreglo[j]) >= 0){
        intercambia(arreglo, i, j);
        i = i +1;
        j = j -1;
      }else if(comparador.compare(arreglo[a], arreglo[i])>=0)
        i = i+1;
      else
        j = j -1;
    }
    if(comparador.compare(arreglo[i], arreglo[a]) >0)
      i = i-1;
    intercambia(arreglo, a, i);
    quickSort(arreglo, comparador, a, i-1);
    quickSort(arreglo, comparador, a+1, b);
  }
  private static <T extends  Comparable<T>> void intercambia(T[] arreglo, int a, int b){
    T elemento1 = arreglo[a];
    T elemento2 = arreglo[b];
    arreglo[a] = elemento2;
    arreglo[b] = elemento1;
  }
  /**
  * ordena va a ordenar un arreglo de cualquier tipo de clase que extienda a Comparable para poder comparar los elementos del arreglo usando el algoritmo quickSort.
  * @param : arreglo que se ordenará.
  **/
  public static  <T extends  Comparable<T>> void ordena(T[] arreglo){
    quickSort(arreglo);
  }
  /**
  * Búsqueda binaria en un arreglo
  * @param : arreglo en donde se buscará.
  * @param : elemento a buscar dentro del arreglo.
  * @return : boolean <p> true si el elemento se encuentra en el arreglo  </p> <p> false si no se encuentra en el arreglo </p>
  **/
  public static  <T extends  Comparable<T>> boolean busquedaBinaria(T[] arreglo, T elemento){
    return busquedaBinaria(arreglo, elemento,  (a, b) -> a.compareTo(b));
  }
  private static <T extends  Comparable<T>> boolean busquedaBinaria(T[] arreglo, T elemento, Comparator<T> comparador){
    quickSort(arreglo);
    int a = 0;
    int b = arreglo.length -1;
    while(a<=0){
      int mitad = (a+b) /2;
      if(comparador.compare(arreglo[mitad], elemento) == 0) return true;
      else if(comparador.compare(arreglo[mitad], elemento) >0){
        if(comparador.compare(arreglo[a], elemento) == 0) return true;
        b = mitad -1;
        a = a + 1;
      }
      else{
        if(comparador.compare(arreglo[b], elemento) == 0) return true;
        b = b-1;
        a = mitad +1;
      }
    }
    return false;
  }
  /**
  *  Método esPrimo -> dice si un número es primo o no.
  * @param : int número del cual se quieren saber si es primo o no.
  * @return : boolean <p> true -> si es primo </p> <p> false -> si no es primo </p>
  **/
  public static boolean esPrimo(int numero){
    if(numero == 1) return true;
    for(int i = 2; i<numero; i++){
      if(numero % i == 0) return false;
    }
    return true;
  }
  /**
  *  Método primos menores: Regresa los primos menores a un número N.
  * @param : int número del cual se quieren obtener los primos menores.
  * @return : arreglo con los primos menores
  **/
  public static int[] primosMenores(int numero){
    ArrayList<Integer> primos = new ArrayList<Integer>();
    for(int i = 1; i < numero+1; i++)
      if(esPrimo(i)) primos.add(i);
    int[] arregloPrimos = new int[primos.size()];
    for(int i = 0; i < primos.size(); i++)
      arregloPrimos[i] = primos.get(i);

    return arregloPrimos;
  }

  /**
  * suma verificará si el elemento ingresado es suma de los números de la lista
  * @param : arreglo con los números
  * @param : numero
  * @return : <p> true si el número es suma de elementos del arreglo </p> <p> false si no es suma </p>
  **/
  public static boolean suma(Integer[] arreglo, Integer num){
    int numero = num;
    int indice = 0;
    if(busquedaBinaria(arreglo, numero) && busquedaBinaria(arreglo, 0)) return true;
    while(indice < arreglo.length){
      if(busquedaBinaria(arreglo, (numero - arreglo[indice]))){
        numero = numero - arreglo[indice];
        if(busquedaBinaria(arreglo, numero))
          return true;
        else
          return false;
      }
      indice++;
    }
    return false;
  }


  /**
  * Método main para poder comprobar mis métodos. Lo eliminaré al terminar.
  **/
  public static void main(String args[]){
    Integer[] arreglo =  {10, 3, 7, 13, 4, 27, 6};
    System.out.print(suma(arreglo, 35));
  }

}
