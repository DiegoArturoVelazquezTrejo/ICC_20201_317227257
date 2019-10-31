package chess.pieces;
import chess.items.*;
import java.util.LinkedList;
/* Clase Peón que extiende de la clase Pieza*/
public class Peon extends Pieza{

  /* Constructor para la clase peón */
  public Peon(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.PEON;
  }


  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    if(this.movimientosLegales == null){
      LinkedList<Posicion> movimientosLegales = new LinkedList<Posicion>();
    }
    return this.movimientosLegales;
  }


  /** Método equals para la pieza de la Peon
  * @param : Object Peon
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Peon)) return false;
    @SuppressWarnings("unchecked") Peon pieza = (Peon) obj;
    if(pieza.getColor() == this.getColor() && this.getPosicion().equals(pieza.getPosicion())) return true;
    else return false;
  }
}
