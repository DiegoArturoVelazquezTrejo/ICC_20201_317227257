
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator; 

public class Lista<T>{
    
    /*Clase privada de Nodo */
    private class Nodo{

	/*Elemento del nodo*/
	private T elemento;
	
	/*El nodo siguiente*/
	private Nodo siguiente;

	/*El nodo anterior*/
	private Nodo anterior;

	/*Construyendo un nodo con un elemento*/
	private Nodo(T elemento){
	    this.elemento = elemento; 
	}
    }
    /*Clase privada para los iteradores*/
    private class Iterador implements IteradorLista<T>{
	/*Nodo anterior*/
	private Nodo anterior;
	/*Nodo siguiente*/
	private Nodo siguiente;
	private Iterador(){
	    siguiente = cabeza; 
	}
	/*Nos dice si hay un elemento siguiente*/
	@Override public boolean hasNext(){
	    return siguiente != null; 
	}
	/*Nos da el elemento siguiente*/
	@Override public T next(){
	    if(!hasNext()) throw new NoSuchElementException();
	    else{
		T elem = siguiente.elemento;
		anterior = siguiente;
		siguiente = siguiente.siguiente; 
		return elem; 
	    } 
	}
	/*Nos dice si hay un elemento anterior*/
	@Override public boolean hasPrevious(){
	    return anterior != null; 
	}
	/*Nos da el elemento anterior*/
	@Override public T previous(){
	    if(!hasPrevious()) throw new NoSuchElementException();
	    else{
		T elem = anterior.elemento;
		siguiente = anterior; 
		anterior = anterior.anterior;
		return elem; 
	    }
	}
	/*Nos coloca al iterador al inicio de la lista*/
	@Override public void start(){
	    anterior = null;
	    siguiente = cabeza; 
	}
	/*Nos coloca al iterador al final de la lista */
	@Override public void end(){
	    siguiente = null;
	    anterior = rabo; 
	}
    }
    /*Primer elemento de la lista*/
    private Nodo cabeza;
    /*último elemento de la lista*/
    private Nodo rabo;
    /*Número de elementos de la lista*/
    private int longitud;

    /*Nos regresa la longitud de la lista*/
    public int getLongitud(){
	return longitud; 
    }
    /*Nos dice si la lista es vacía o no*/
    public boolean esVacia(){
	return longitud == 0; 
    }
    /*Agrega un nodo al final de la lista */
    public void agregaFinal(T elem){
	if(elem == null)throw new NoSuchElementException();
	Nodo nodo = new Nodo(elem);
	if(esVacia()){
	    cabeza = nodo;
	    rabo = cabeza;
	    cabeza.anterior = null;
	    rabo.siguiente = null; 
	}
	else{
	    nodo.anterior = rabo;
	    rabo.siguiente = nodo;
	    rabo = nodo; 
	}
	longitud++; 
    }
    /*Agrega al inicio de la lista*/
    public void agregaInicio(T elem){
	if(elem == null) throw new NoSuchElementException();
	Nodo nodo = new Nodo(elem);
	if(esVacia()) cabeza = rabo = nodo;
	else{
	    nodo.siguiente = cabeza;
	    cabeza.anterior = nodo;
	    cabeza = nodo;
	}
	longitud++; 
    }
    /*Agrega un elemento en el índice que se especifique*/
    public void inserta(int indice, T elem){
	if(elem == null) throw new NoSuchElementException();
	else if(longitud == 1)agregaInicio(elem);
	else if(longitud <= indice)agregaFinal(elem);
	else{
	    Nodo nuevoNodo = new Nodo(elem); 
	    Nodo nodo = buscaNodo(get(indice));
	    
	    nodo.anterior.siguiente = nuevoNodo;
	    nuevoNodo.anterior = nodo.anterior;
	    nodo.anterior = nuevoNodo; 
	    nuevoNodo.siguiente = nodo;
	    longitud++; 
	}
    }
    /*Busca el nodo que contenga al elemento en el parámetro de entrada*/
    public Nodo buscaNodo(T e){
	Nodo n = cabeza;
	if(e == null)throw new NoSuchElementException();
	while(n!= null){
	    if(n.elemento.equals(e)) return n;
	    n = n.siguiente; 
	}
	return null; 
    }
    /*Te regresa el nodo en el índice i*/
    public T get(int i){
	if(i<0 || i>=longitud) throw new IllegalArgumentException(); 
	Nodo nodo = cabeza;
	while(i-- >0)
	    nodo = nodo.siguiente;
	return nodo.elemento; 
    }
    /*Método que limpia la lista*/
    public void limpia(){
	cabeza = rabo = null;
	longitud = 0;	
    }
    /*Eliminará el primer elemento de la lista */
    public T eliminaPrimero(){
	if(esVacia()) throw new NoSuchElementException();
	Nodo nodo = cabeza; 
	if(longitud == 1) limpia(); 
	else{
	    cabeza = cabeza.siguiente; 
	    cabeza.anterior = null;
	    longitud--; 
	}
	return nodo.elemento; 
    }
    /*Eliminará el último elemento de la lista*/
    public T eliminaUltimo(){
	if(esVacia()) throw new NoSuchElementException();
	Nodo nodo = rabo;
	if(longitud == 1) limpia();
	else{
	    rabo = rabo.anterior;
	    rabo.siguiente = null;
	    longitud--;
	}
	return nodo.elemento; 
    }
    /*Elimina el elemento de la lista que se especifique*/
    public void elimina(T elemento){
	eliminaNodo(buscaNodo(elemento)); 
    }
    /*Elimina el nodo de la lista*/
    public void eliminaNodo(Nodo nodo){
	if(nodo == null) throw new IllegalArgumentException();
	if(longitud == 1 && cabeza.elemento.equals(nodo.elemento)) limpia();
	else if(buscaNodo(nodo.elemento) == null) return;
	else if(nodo.equals(rabo)) eliminaUltimo();
	else if(nodo.equals(cabeza)) eliminaPrimero();
	else{
	    nodo.anterior.siguiente = nodo.siguiente;
	    nodo.siguiente.anterior = nodo.anterior; 
	    longitud--; 
	}
    }
    /*Contiene nos dice si la lista contiene al elemento */
    public boolean contiene(T elemento){
	return buscaNodo(elemento) != null; 
    }

    /*Get cabeza*/
    public Nodo getCabeza(){
	return cabeza; 
    }
    /*Get rabo*/
    public Nodo getRabo(){
	return rabo; 
    }
    /*Reversa*/
    public Lista reversa(){
	Lista<T> reversa = new Lista<T>();
	Nodo nodo = rabo;
	while(nodo != null){
	    reversa.agregaFinal(nodo.elemento); 
	    nodo = nodo.anterior; 
	}
	return reversa; 
    }
    /*Método equals*/
    @Override
    public boolean equals(Object objeto){
	if(objeto == null || getClass()!= objeto.getClass()) return false;
	@SuppressWarnings("unchecked") Lista<T> lista = (Lista<T>)objeto;
	if(lista == null) return false;
	else if(lista.getLongitud() != longitud) return false;
	else if(lista.getLongitud() == 0  && longitud == 0) return true;
	Nodo nodo = cabeza;
	int i = 0;
	while(nodo != null){
	    if(nodo.elemento.equals(lista.get(i)) == false) return false;
	    nodo = nodo.siguiente;
	    i++; 
	}
	return true; 
    }
}
