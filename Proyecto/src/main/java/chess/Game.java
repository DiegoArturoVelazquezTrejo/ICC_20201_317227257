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
    Tablero tablero = Tablero.getInstance();
    System.out.print(tablero.toString());
    Pieza pieza = tablero.getPieza(new Posicion(1,0));
    System.out.print(pieza.obtenerMovimientosLegales());
    //Reina reina = new Reina(new Posicion(1,1), ColorEnum.NEGRO);
    //System.out.print(reina.obtenerMovimientosLegales());
  }
}
