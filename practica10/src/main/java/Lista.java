import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Clase de Lista Genérica
* @author: Diego Arturo Velázquez Trejo
* @version : 1.0
**/

public class Lista<T extends Comparable> implements Iterable<T>{

  /* Lonitud de la lista */
  private int longitud;
  /* Cabeza de la lista */
  private Nodo cabeza;
  /* Cola de la lista */
  private Nodo cola;

  /**
  * Clase interna de Nodo para los nodos de la lista
  **/
  private class Nodo{
    /* Nodo anterior al nodo */
    private Nodo anterior;
    /* Nodo siguiente al nodo */
    private Nodo siguiente;
    /* Elemento que guarda el nodo */
    private T elemento;
    /**
    * Constructor de la clase Nodo
    * @param : T elemento
    **/
    public Nodo(T elemento){this.elemento = elemento; }
    /**
    * getter del atributo T elemento
    * @return : T elemento
    **/
    public T getElemento(){ return this.elemento; }
    /**
    * getter del atributo Nodo siguiente
    * @return : Nodo siguiente
    **/
    public Nodo getSiguiente(){return this.siguiente; }
    /**
    * getter del atributo Nodo anterior
    * @return : Nodo anterior
    **/
    public Nodo getAnterior(){ return this.anterior; }
  }

  /**
  * Clase privada Iterador para hacer a la lista Iterable
  **/
  private class Iterador implements Iterator<T>{
    /* Nodo anterior */
    private Nodo anterior;
    /* Nodo siguiente */
    private Nodo siguiente;
    /* Constructor de la clase Iterador */
    private Iterador(){
      siguiente = cabeza;
    }
    /* Regresa el elemento siguiente y mueve al iterador */
    public T next(){
      if(!hasNext()) throw new NoSuchElementException();
      else{
        T elem = siguiente.elemento;
        anterior = siguiente;
        siguiente = siguiente.siguiente;
        return elem;
      }
    }
    /* Regresa el elemento previo y mueve al iterador */
    public T previous(){
      if(!hasPrevious()) throw new NoSuchElementException();
      else{
        T elem = anterior.elemento;
        siguiente = anterior;
        anterior = anterior.anterior;
        return elem;
      }
    }
    /* Nos dice si hay un siguiente elemento */
    public boolean hasNext(){
      return siguiente != null;
    }
    /* Nos dice si hay un elemento anterior */
    public boolean hasPrevious(){
      return anterior != null;
    }
    /* Posiciona al iterador al inicio */
    public void start(){
      anterior = null;
      siguiente = cabeza;
    }
    /* Posiciona al iterador al final */
    public void end(){
      siguiente = null;
      anterior = cola;
    }
  }

  /* Constructor de la clase Lista */
  public Lista(){
    this.cabeza = this.cola = null;
    longitud = 0;
  }

  /** Getter del atributo longitud de la lista
  * @return : longitud de la lista
  **/
  public int getLongitud(){
    return this.longitud;
  }
  /**
  * Método que indica si la lista es vacía o no
  * @return : true si es vacía, false de lo contrario
  **/
  public boolean esVacia(){
    return this.longitud == 0;
  }

  /**
  * agrega un elemento a la lista
  * @param : indice donde se insertará el elemento
  * @param : T elemento a insertar 
  **/
  public void inserta(int indice, T elemento){}
  public void elimina(T elemento){}
  public int indiceDe(T elemento){}
  public T agregaFinal(T elemento){}
  public T agregaInicio(T elemento){}
  public void contiene(T elemento){}
  public Lista<T> copia(){}
  public Lista<T> reversa(){}
  public void eliminaPrimero(){}
  public void eliminaUltumo(){}
  public Nodo getCabeza(){}
  public Nodo getRabo(){}
  public void ordena(){}
  public T get(){}
  public T getPrimero(){}
  public T getUltimo(){}
  public void limpia(){}
  public Nodo buscaNodo(T elemento){}


  /**
   * Regresa un iterador para recorrer la lista en una dirección.
   * @return un iterador para recorrer la lista en una dirección.
   */
  public Iterator<T> iterator(){
    return new Iterador();
  }

}
