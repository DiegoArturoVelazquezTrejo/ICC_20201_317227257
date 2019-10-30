package chess.pieces;
import chess.items.*;
import java.util.LinkedList;

/* Clase para la pieza Reina que extiende de la clase abstracta Pieza*/
public class Reina extends Torre{

  /* Constructor para la clase Reina*/
  public Reina(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.REINA;
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
  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    if(this.movimientosLegales == null){
      LinkedList<Posicion> movimientosLegales = super.obtenerMovimientosLegales();
      /* Recorriendo los posibles movimientos de la pieza */
      for(int i = this.posicion.getX(); i < 8; i++){
        this.movimientosLegales.add(new Posicion(this.posicion.getX()+i, this.posicion.getY()+i));
      }
      for(int i = this.posicion.getX(); i >= 0; i--){
        this.movimientosLegales.add(new Posicion(this.posicion.getX()-i, this.posicion.getY()+i));
      }
      for(int i = this.posicion.getY(); i < 8; i++){
        this.movimientosLegales.add(new Posicion(this.posicion.getX()-i, this.posicion.getY()-i));
      }
      for(int i = this.posicion.getY(); i >= 0; i--){
        this.movimientosLegales.add(new Posicion(this.posicion.getX()+i, this.posicion.getY()-i));
      }
    }
    return this.movimientosLegales;
  }

  /** Método equals para la pieza de la Reina
  * @param : Object Reina
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Reina)) return false;
    @SuppressWarnings("unchecked") Reina pieza = (Reina) obj;
    if(pieza.getColor() == this.getColor() && this.getPosicion().equals(pieza.getPosicion())) return true;
    else return false;
  }

}
