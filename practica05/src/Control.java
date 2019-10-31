package src;

import java.util.Comparator;
import java.util.ArrayList;

/**
* @class : Control, práctica 5
* @author: Diego ARturo Velázquez Trejo
* @version: 1.0
**/

public class Control{
  /*Constructor por omisión*/
  public Control(){}

  /**
  * reversa te regresa la cadena reversa de una cadena.
  * @param : String cadena
  * @return : String cadena invertida
  **/
  private static String reversa(String pal){
    String reversa = "";
    String palabra = pal.toLowerCase();
    for(int i = palabra.length()-1; i>-1; i--)
      reversa = reversa+ palabra.charAt(i);
    return reversa;
  }
  /**
  * palíndromo : te dice si una cadena es palíndromo o no.
  * @param : String cadena
  * @return : boolean <p> true si es palíndromo </p> <p> false si no es palíndromo </p>
  **/
  public boolean problema1(String cadena){
    return cadena.equals(reversa(cadena));
  }

  /**
  * suma verificará si el elemento ingresado es suma de los números de la lista
  * @param : arreglo con los números
  * @param : numero
  * @return : <p> true si el número es suma de elementos del arreglo </p> <p> false si no es suma </p>
  **/
  public boolean problema2(Integer[] arreglo, Integer num){
    quickSort(arreglo);
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
  * quicksort  de arreglos con elementos comparables
  * @param : arreglo de tipo T
  **/
  private static <T extends  Comparable<T>> void quickSort(T[] arreglo){
    quickSort(arreglo, (a, b) -> a.compareTo(b), 0, arreglo.length - 1);
  }
  /**
  * Usando el polimorfismo, defino un método quickSort que usa un comparador, y los índices para ordenar al arreglo.
  * @param : arreglo de tipo T
  * @param : comparador para comparar los elementos del arreglo.
  * @param : <p> int a -> indice ṕrimero</p>
  * @param : <p> int b -> indice último</p>
  **/
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
  /**
  *Método intercambia que intercambiará elementos dentro de un arreglo de acuerdo a sus índices.
  * @param : arreglo de tipo T
  * @param : <p>int -> índice primero</p>
  * @param : <p>int -> índice segundo</p>
  ***/
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
  public  <T extends  Comparable<T>> void problema3(T[] arreglo){
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
  /**
  * Búsqueda binaria en un arreglo
  * @param : arreglo en donde se buscará.
  * @param : elemento a buscar dentro del arreglo.
  * @param : comparador para comparar los elementos del arreglo.
  * @return : boolean <p> true si el elemento se encuentra en el arreglo  </p> <p> false si no se encuentra en el arreglo </p>
  **/
  private static <T extends  Comparable<T>> boolean busquedaBinaria(T[] arreglo, T elemento, Comparator<T> comparador){
    int a = 0;
    int b = arreglo.length -1;
    while(a<=b){
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
  public boolean problema5(int numero){
    if(numero == 1) return true;
    for(int i = 2; i<numero; i++){
      if((numero % i) == 0) return false;
    }
    return true;
  }
  /**
  *  Método primos menores: Regresa los primos menores a un número N.
  * @param : int número del cual se quieren obtener los primos menores.
  * @return : arreglo con los primos menores
  **/
  public Integer[] problema6(int numero){
    ArrayList<Integer> primos = new ArrayList<Integer>();
    for(int i = 2; i < numero+1; i++)
      if(problema5(i)) primos.add(i);
    Integer[] arregloPrimos = new Integer[primos.size()];
    for(int i = 0; i < primos.size(); i++)
      arregloPrimos[i] = primos.get(i);

    return arregloPrimos;
  }

}
