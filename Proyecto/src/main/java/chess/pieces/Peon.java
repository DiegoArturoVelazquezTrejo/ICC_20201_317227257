package chess.pieces;
import chess.items.*;
import java.util.LinkedList; 
/* Clase Peón que extiende de la clase Pieza*/
public class Peon extends Pieza{

  /* Constructor para la clase peón */
  public Peon(Posicion posicion, EnumPieza tipoPieza, ColorEnum color){
    super(posicion, tipoPieza, color);
  }

  /* Escribiendo los movimientos legales para el peón */
  @Override
  public LinkedList<Posicion> getMovimientosLegales(){
    if(this.movimientosLegales == null){
      this.movimientosLegales = new LinkedList<Posicion>();
      Posicion n = new Posicion(this.getPosicion().getX(), this.getPosicion().getY() +1);
      this.movimientosLegales.add(n);
    }
    return this.movimientosLegales;
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
