
/**
* clase Matrix para el manejo de arreglos en java
* @author : Diego Velázquez
* @version : 1.0
**/
public class Matrix{

    /* matriz del arreglo*/
    private double[][] matriz;
    /**
    * Constructor
    * @param : int n
    * @param : int m
    **/
    public Matrix(int n, int m){
      this.matriz = new double[n][m];
      for(int i = 0; i < n; i++){
        for(int o = 0; o < m ; o++)
          this.matriz[i][o] = 0.0;
      }
    }
    /**
    * Constructor
    * @param : array
    **/
    public Matrix(double[][] array){
      this.matriz = new double[array.length][array[0].length];
      for(int i = 0; i < array.length; i++){
        for(int o = 0; o < array[i].length; o++)
          this.matriz[i][o] = array[i][o];
      }
    }
    /**
    * Producto escalar de una matriz
    * @param : double scalar
    **/
    public void scalarProduct(double scalar){
      for(int i = 0; i < matriz.length; i++){
        for(int o = 0; o < matriz[i].length; o++){
          this.matriz[i][o] = (this.matriz[i][o] * scalar);
        }
      }
    }
    /**
    * Suma de una matriz
    * @param : Matrix m
    **/
    public void add(Matrix m){
      for(int i = 0; i < matriz.length; i++){
        for(int o = 0; o < matriz[i].length; o++){
          this.matriz[i][o] = this.matriz[i][o] + m.getElement(i, o);
        }
      }
    }
    /**
    * Producto de dos matrices
    * @param : Matrix m
    **/
    public void matrixProduct(Matrix m){
      for(int i = 0; i < matriz.length; i++){
        for(int o = 0; o < matriz[i].length; o++){
          this.matriz[i][o] = (this.matriz[i][o] * m.getElement(i, o));
        }
      }
    }
    /**
    * Obtiene un elemento de la matrix
    * @param : int i
    * @param : int j
    * @return double
    **/
    public double getElement(int i, int j){return this.matriz[i][j];}
    /**
    * Pone el elemento a un índice de la matrix
    * @param : int i
    * @param : int j
    * @param : elemento
    **/
    public void setElement(int i, int j,double e){this.matriz[i][j] = e;}

    /**
    * Calcula el determinante de una matriz.
    * @return : double determinante.
    **/
    public double determinant(){
      return determinant(matriz);
    }
    /**
    * Calcula el determinante de una matriz nxn
    * @return : double -> determinante
    **/
    public double determinant(double[][] matrix){
  		double determinante = 0.0;
  		int filas = matrix.length;
  		int columnas = matrix[0].length;
  		if ((filas==1) && (columnas==1)) return matrix[0][0];
  		int signo=1;
  		for (int columna=0;columna<columnas;columna++){
  			double[][] submatriz = getSubmatriz(matrix, filas, columnas, columna);
  			determinante = determinante + signo*matrix[0][columna]*determinant(submatriz);
  			signo*=-1;
  		}
  		return determinante;
  	}

    private double[][] getSubmatriz(double[][] matriz, int filas,int columnas, int columna){
  		double [][] submatriz = new double[filas-1][columnas-1];
  		int contador=0;
  		for (int j=0;j<columnas;j++){
  			if (j==columna) continue;
  			for (int i=1;i<filas;i++)
  				submatriz[i-1][contador]=matriz[i][j];
  			contador++;
  		}
  		return submatriz;
  	}


    /**
    * Compara si dos matrices son iguales
    * @param : Object matrix
    * @return : true si son iguales / false si no son iguales
    **/
    @Override
    public boolean equals(Object o){
      if(!(o instanceof Matrix)) return false;
      Matrix matrix = (Matrix) o;
      for(int i = 0; i < matriz.length; i++){
        for(int u = 0; u < matriz[i].length; u++){
          if(this.matriz[i][u] != matrix.getElement(i,u)) return false;
        }
      }
      return true;
    }
    /* regresa la matriz la matrix*/
    public double[][] getMatriz(){
      return matriz;
    }
}
