package ai;
/**
* Clase para árbol binario
* Nos permitirá poder manenjar posibilidades en el ajedrez para el algoritmo de IA.
**/
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
    private Nodo(T elemento){
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
