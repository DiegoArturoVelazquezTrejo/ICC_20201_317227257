package src;
import src.Control;
import java.util.Arrays;
/**
* Clase Main para evaluar a la clase Control
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0
* @date :
**/
public class Main{
  /**
  * Método main para poder comprobar mis métodos. Lo eliminaré al terminar.
  **/
  public static void main(String[] args) {
        Control control = new Control();
        String resultado = "";
        Integer[] desordenado = {9,8,7,6,5,4,3,2,1};
        Integer[] ordenado    = {1,2,3,4,5,6,7,8,9};
        Integer[] primos10 = {2,3,5,7};
        if(control.problema1("oso")==true && control.problema1("palabra")==false)resultado+="P1 bien\n";else resultado+="P1 mal\n";
        if(control.problema2(desordenado, 17)==true) resultado+="P2 bien\n";else resultado+="P2 mal\n";
        control.problema3(desordenado);
        if(Arrays.equals(desordenado,ordenado))resultado+="P3 bien\n";else resultado+="P3 mal\n";
        if(Control.busquedaBinaria(desordenado,2)== true && Control.busquedaBinaria(desordenado,18)== false)resultado+="P4 bien\n";else resultado+="P4 mal\n";
        if(control.problema5(7)==true && control.problema5(6)==false)resultado+="P5 bien\n";else resultado+="P5 mal\n";
        if(Arrays.equals(control.problema6(10), primos10) == true)resultado+="P6 bien\n";else resultado+="P6 mal\n";
        System.out.println(resultado);
    }
}
