package chess.pieces;
import chess.items.*;

/* Clase para la pieza Alfil que extiende de la clase abstracta Pieza*/
public class Alfil extends Pieza{

  /* Constructor para la clase Alfil*/
  public Alfil(Posicion posicion, EnumPieza tipoPieza, ColorEnum color){
    super(posicion, tipoPieza, color);
  }

  /* Método para mover la pieza */
  @Override
  public void moverPieza(Posicion p){
    if(this.esMovimientoLegal(p)){
      this.posicion = p;
      this.movimientosLegales = null;
    }
    return;
  }

}
