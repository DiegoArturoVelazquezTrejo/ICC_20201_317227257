package ciencias.icc;
import ciencias.icc.Matrix;

import java.util.Random;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
* Clase para pruebas unitarias de la {@clase Matrix}
**/
public class MatrizTest{

    @Rule public Timeout expiracion = Timeout.seconds(5);

    /* Generados de números aleatorios. */
    private static Random random;
    /**
    * generaArreglo genera un nuevo arreglo con las dimensiones esperadas.
    * @param : int m
    * @param : int n
    * @return array[n][m]
    **/
    public double[][] generaArreglo(int m, int n){
      double[][] matriz = new double[m][n];
      for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++)
          matriz[i][j] = random.nextDouble();
      }
      return matriz;
    }
    public void copiaMatrices(Matrix a, Matrix b){
      for(int i = 0; i < a.getMatriz().length; i++){
        for(int j = 0; j < a.getMatriz()[i].length; j++){
          a.setElement(i,j,b.getElement(i,j));
        }
      }
    }
    /**
    * generaMatrix genera una nueva Matrix
    * @return Matrix
    **/
    private Matrix generaMatrix(int n, int m){
      return new Matrix(generaArreglo(n, m));
    }
    private Matrix generaMatrixCeros(int n, int m){
      return new Matrix(n, m);
    }

    /* prueba para el producto escalar */
    @Test public void scalarProduct_test(){
        Matrix matriz = generaMatrix(2,2);
        Matrix matriz2 = generaMatrix(2,2);
        copiaMatrices(matriz, matriz2);
        double scalar = 2;
        Assert.assertTrue(matriz.equals(matriz2));
        matriz2.scalarProduct(scalar);
        Assert.assertFalse(matriz.equals(matriz2));
        matriz.scalarProduct(scalar);
        Assert.assertTrue(matriz.equals(matriz2));
    }
    /* prueba para la suma de matrices*/
    @Test public void add_test(){
      Matrix matriz = generaMatrixCeros(5,5);
      Matrix matriz2 =generaMatrix(5,5);
      Assert.assertFalse(matriz.equals(matriz2));
      matriz = matriz.add(matriz2);
      Assert.assertTrue(matriz.equals(matriz2));
    }
    /* prueba para el producto de dos matrices*/
    @Test public void matrixProduct_test(){
      Matrix matriz = generaMatrix(20,20);
      Matrix matriz2 = generaMatrixCeros(20, 20);
      Assert.assertFalse(matriz.equals(matriz2));
      matriz= matriz2.matrixProduct(matriz);
      Assert.assertTrue(matriz.equals(matriz2));
    }
    /* prueba para el setElement de matrices*/
    @Test public void setElement_test(){
      Matrix matriz = generaMatrix(20,20);
      Matrix matriz2 = generaMatrix(20,20);
      copiaMatrices(matriz, matriz2);
      matriz.setElement(1,1,200);
      matriz2.setElement(5,5,290);
      Assert.assertFalse(matriz2.equals(matriz));
      matriz2.setElement(1,1,200);
      matriz.setElement(5,5,290);
      Assert.assertTrue(matriz.equals(matriz2));
    }
    /* prueba para el getElement de matrices*/
    @Test public void getElement_test(){
      Matrix matriz = generaMatrixCeros(5,5);
      Assert.assertTrue(matriz.getElement(0,0) == 0.0);
      matriz.setElement(0,0,89.0);
      Assert.assertFalse(matriz.getElement(0,0) == 0.0);
      Assert.assertTrue(matriz.getElement(0,0) == 89.0);
    }
    public void determinant_test(){
        System.out.println("Determinant failed");
    }
    /* prueba para el equals de matrices*/
    @Test public void equals_test(){
      Matrix matriz = generaMatrixCeros(5,5);
      Matrix matriz2 =generaMatrix(5,5);
      Assert.assertFalse(matriz.equals(matriz2));
      copiaMatrices(matriz, matriz2); 
      Assert.assertTrue(matriz.equals(matriz2));
      Matrix matriz3 = generaMatrix(9,9);
      Assert.assertFalse(matriz3.equals(matriz2));
    }

    /**
    * Inicializa el generador de números aleatorios.
    **/
    static{
      random = new Random();
    }
}
