package shapsSVG;
import java.util.Random;
/**
* Clase que define el comportamiento del algoritmo Simulated Annealing
* junto con la función de optimización y el método para graficar los puntos.
**/
public class SimulatedAnnealing{

    /**
    * Constructor privado por omisión para evitar que la clase se instancíe.
    **/
    private SimulatedAnnealing(){}

    /**
     * Algoritmo de Simulated Annealing
     */
    public static double[] simulatedAnnealing(double[] espacioBusqueda, double temperatura, int generaciones){
      Random ran = new Random();
      int indice = ran.nextInt(espacioBusqueda.length);
      double inicio = espacioBusqueda[indice];
      double eval = funcionOptimizacion(inicio);
      int i = 0;
      while(i < 1000){
        // Código del algoritmo
        i++;
      }
      return null; 
    }
    /**
     * Función que se optimizará en el algoritmo de simulated Annealing
     */
    public static double  funcionOptimizacion(double valor){
      if(valor<-1 || valor >1) return 0;
      return Math.sin(50*valor)+Math.cos(20*valor);
    }
    /**
    * Método Sigmoide que permite acotar un valor entre el valor de 0 y 1.
    * @param: Valor a ser acotado
    **/
    public static double sigmoide(double x){
      return (1 / (1+Math.pow(Math.E, -1 * x)));
    }

}
