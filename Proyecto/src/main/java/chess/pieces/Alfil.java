package chess.pieces;
import chess.items.*;
import java.util.LinkedList;

/* Clase para la pieza Alfil que extiende de la clase abstracta Pieza*/
public class Alfil extends Pieza{

  /* Constructor para la clase Alfil*/
  public Alfil(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.ALFIL;
  }

  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    if(this.movimientosLegales == null){
      LinkedList<Posicion> movimientosLegales = new LinkedList<Posicion>();
    }
    return this.movimientosLegales;
  }

  /** Método equals para la pieza de la Alfil
  * @param : Object Alfil
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Alfil)) return false;
    @SuppressWarnings("unchecked") Alfil pieza = (Alfil) obj;
    if(pieza.getColor() == this.getColor() && this.getPosicion().equals(pieza.getPosicion())) return true;
    else return false;
  }

}
