package chess.pieces;
import chess.items.*;

/* Clase para la pieza Rey que extiende de la clase abstracta Pieza*/
public class Rey extends Pieza{

  /* Constructor para la clase Rey*/
  public Rey(Posicion posicion, EnumPieza tipoPieza, ColorEnum color){
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
