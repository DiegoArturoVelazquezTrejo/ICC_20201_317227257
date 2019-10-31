package chess.pieces;
import chess.items.*;
import java.util.LinkedList;

/* Clase para la pieza Caballo que extiende de la clase abstracta Pieza*/
public class Caballo extends Pieza{

  /* Constructor para la clase Caballo*/
  public Caballo(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.CABALLO;
  }

  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    if(this.movimientosLegales == null){
      LinkedList<Posicion> movimientosLegales = new LinkedList<Posicion>();
    }
    return this.movimientosLegales;
  }


  /** Método equals para la pieza de la caballo
  * @param : Object Caballo
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Caballo)) return false;
    @SuppressWarnings("unchecked") Caballo pieza = (Caballo) obj;
    if(pieza.getColor() == this.getColor() && this.getPosicion().equals(pieza.getPosicion())) return true;
    else return false;
  }

}
