package lifegame.herramientas;

import lifegame.herramientas.Pixel;
import java.util.Iterator;
/**
* clase Matriz para el manejo de las imágenes con pixeles en java
* @author : Diego Velázquez
* @version : 1.0
**/
public class Matriz implements Iterable<Pixel>{
    /* arreglo de pixeles de la imágen */
    public Pixel[][] imagen;

    /* Tamaño de la imagen */
    private int size = 500;

    /* Indice en columnas de la matriz*/
    int columnas = 0;
    /* Indice en filas de la matriz */
    int filas = 0;

    /* Clase interna para el iterador de la matriz */
    public class Iterador implements Iterator {
      public  int posFila;
      public  int posCol;
      /* Constructor del Iterador */
      public Iterador() {
          posCol  = 0;
          posFila = 0;
      }
      /* Método hasNext indica si hay un siguiente elemento dentro de la matriz bidimensonal */
      @Override
      public boolean hasNext() {
          if(posCol == Matriz.this.imagen[posFila].length && posFila < Matriz.this.imagen.length){
            posCol = 0;
            posFila++;
          }
          return (posFila<Matriz.this.imagen.length) && (posCol<Matriz.this.imagen[posFila].length);
      }
      /* Posiciona al iterador un lugar adelante */
      @Override
      public Pixel next() {
          if (this.hasNext()) {
              Pixel p = Matriz.this.imagen[posFila][posCol];
              if(posCol < Matriz.this.imagen[posFila].length) posCol++;
              return p;
          }
          else return null;
      }
    }

    /**
    * Constructor por omisión
    **/
    public Matriz(){
      this.imagen = new Pixel[size][size];
    }
    /**
    * Constructor
    * @param : int n
    * @param : int m
    **/
    public Matriz(int n, int m){
      this.imagen = new Pixel[n][m];
    }
    /**
    * Constructor
    * @param : array
    **/
    public Matriz(int[][][] array){
      this.imagen = new Pixel[array.length][array[0].length];
      for(int i = 0; i < array.length; i++){
        for(int j = 0; j < array[0].length; j++){
          this.imagen[i][j] = new Pixel(array[i][j]);
        }
      }
    }

    /**
    * Método que calcula la suma de los colores RGB de los vecinos de un Pixel
    * @return int suma
    **/
    public int sumaVecinos(){
      if(this.filas == this.imagen.length){
        this.filas = 0;
        this.columnas = 0;
      }
      int i = filas;
      int j = columnas;
      int suma = 0;
      try{
        suma = suma + this.imagen[i-1][j-1].sumaColores();
      }catch(Exception e){}
      try{
        suma = suma + this.imagen[i-1][j].sumaColores();
      }catch(Exception e){}
      try{
        suma = suma + this.imagen[i-1][j+1].sumaColores();
      }catch(Exception e){}
      try{
        suma = suma + this.imagen[i][j-1].sumaColores();
      }catch(Exception e){}
      try{
        suma = suma + this.imagen[i][j+1].sumaColores();
      }catch(Exception e){}
      try{
        suma = suma + this.imagen[i+1][j-1].sumaColores();
      }catch(Exception e){}
      try{
        suma = suma + this.imagen[i+1][j].sumaColores();
      }catch(Exception e){}
      try{
        suma = suma + this.imagen[i+1][j+1].sumaColores();
      }catch(Exception e){}
      finally{

        this.columnas++;
        if(this.columnas == imagen[this.filas].length){
          this.columnas = 0;
          this.filas++;
        }
        return suma;
      }
    }

    /**
    * Método que regresa una copia de la Matriz
    * @return : Matriz copiada
    **/
    public Matriz copia(){
      Matriz copia = new Matriz();
      for(int i = 0; i < this.imagen.length; i++){
        for(int j = 0; j < this.imagen[i].length; j++){
          copia.setPixel(i,j, this.imagen[i][j]);
        }
      }
      return copia;
    }

    /**
    * Setter de un pixel dentro de la imagen
    * @param : int indice i
    * @param : int indice j
    * @param : Pixel nuevo pixel
    **/
    public void setPixel(int i, int j, Pixel pixel){
      if(i<this.imagen.length && j < this.imagen[i].length)
        this.imagen[i][j] = pixel;
    }

    /**
    * Getter de un pixel dentro de la imagen
    * @param : int indice i
    * @param : int indice j
    * @return : Pixel dentro de la imagen
    **/
    public Pixel getPixel(int i, int j){
      if(i<this.imagen.length && j < this.imagen[i].length)
        return this.imagen[i][j];
      return null; 
    }
    /* regresa la imagen de la matriz*/
    public Pixel[][] getImagen(){
      return imagen;
    }
    /* Método para regresar un iterador */
    public Iterator<Pixel> iterator(){
      return new Iterador();
    }
    /* Imprime la suma de los colores por pixel de la imagen */
    public void imprimeSumaPixeles(){
      for(int i = 0; i < this.imagen.length; i++){
        for(int j = 0; j <this.imagen[i].length; j++){
          int suma = this.imagen[i][j].sumaColores();
          System.out.print("["+suma+"],");
        }
        System.out.print("\n");
      }
    }
}
