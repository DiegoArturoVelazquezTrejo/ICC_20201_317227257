
package ai;
/**
* Clase para árbol binario
* Nos permitirá poder manenjar posibilidades en el ajedrez para el algoritmo de IA.
**/
'''
public class ArbolBinario<T> implements Coleccion<T>{

  /* Clase interna para nodos del árbol binario. */
  private class Vertice implements VerticeArbolBinario<T>{
    /* Padre del nodo */
    private Vertice padre;
    /* Hijo derecho del nodo*/
    private Vertice hijoDerecho;
    /* Hijo izquierdo del nodo */
    private Vertice hijoIzquierdo;
    /* El elemento del nodo */
    private T elemento;
    /* Construye un nodo con un elemento*/
    private Vertice(T elemento){
      this.elemento = elemento;
    }
    @Override public boolean hayPadre(){ return padre != null; }
    @Override public boolean hayIzquierdo(){return hijoIzquierdo != null; }
    @Override public boolean hayDerecho(){return hijoDerecho != null; }
    @Override public VerticeArbolBinario<T> padre(){return padre; }
    @Override public VerticeArbolBinario<T> izquierdo(){return hijoIzquierdo; }
    @Override public VerticeArbolBinario<T> derecho(){return hijoDerecho; }
    @Override public int altura(){return altura; }
    @Override public int profundidad(){return profundidad; }
    @Override public T get(){return elemento; }
  }
  /* Raíz del arbol binario */
  private Vertice raiz;
  /* Número de nodos que tiene el arbol binario */
  private int elementos;
  /**
   * Constructor sin parámetros. Tenemos que definirlo para no perderlo.
   */
  public ArbolBinario() {}
  /**
   * Construye un árbol binario a partir de una colección. El árbol binario
   * tendrá los mismos elementos que la colección recibida.
   * @param coleccion la colección a partir de la cual creamos el árbol
   *        binario.
   */
  public ArbolBinario(Coleccion<T> coleccion) {

  }
  /**
  * Regresa la cantidad de nodos del arbol binario
  * @return la cantidad de nodos del arbol
  **/
  public int getCantidadNodos(){return cantidadNodos; }
  /**
  * Nos dice si el arbol binario es vacío o no.
  * @return true si es vacío, false si no es vacío.
  **/
  public boolean esVacio(){return cantidadNodos == 0; }
  /**
  * Agrega un nodo al arbol binario
  * @param : T elemento que se agregara al Arbol binario.
  **/
  public void agregaInicio(T elemento){
    if(elemento == null) throw new IllegalArgumentException("Elemento null");
    Nodo nodo = new Nodo(elemento);
    if(esVacio()) raíz = nodo;
    else{

    }
  }
}
'''
