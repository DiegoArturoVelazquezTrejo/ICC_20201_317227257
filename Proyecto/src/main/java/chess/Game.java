package chess;
import chess.items.*;
import chess.pieces.*;
import java.util.LinkedList;
/**
* Clase para evaluar los métodos de las piezas
* @author : Diego Velázquez
* @version : 1.0
**/
public class Game{
  /* Método main */
  public static void main(String args[]){
    Torre torre = new Torre(new Posicion(4,4), ColorEnum.BLANCO);
    System.out.print(torre.obtenerMovimientosLegales());
    Reina reina = new Reina(new Posicion(1,1), ColorEnum.NEGRO);
    System.out.print(reina.obtenerMovimientosLegales());
  }
}
