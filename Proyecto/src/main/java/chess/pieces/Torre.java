package chess.pieces;
import java.util.LinkedList;
import chess.items.*;

/* Clase para la pieza Torre que extiende de la clase abstracta Pieza*/
public class Torre extends Pieza{


  /* Constructor para la clase Torre*/
  public Torre(Posicion posicion, ColorEnum color){
    super(posicion, color); 
    this.tipoPieza = EnumPieza.TORRE;
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
      this.movimientosLegales = new LinkedList<Posicion>();
      /* Recorriendo los posibles movimientos de la pieza */
      for(int i = this.posicion.getX(); i < 8; i++){
        this.movimientosLegales.add(new Posicion(i, this.posicion.getY()));
      }
      for(int i = this.posicion.getX(); i >= 0; i--){
        this.movimientosLegales.add(new Posicion(i, this.posicion.getY()));
      }
      for(int i = this.posicion.getY(); i < 8; i++){
        this.movimientosLegales.add(new Posicion(this.posicion.getX(), i));
      }
      for(int i = this.posicion.getY(); i >= 0; i--){
        this.movimientosLegales.add(new Posicion(this.posicion.getX(), i));
      }
    }
    return this.movimientosLegales;
  }

  /** Método equals para la pieza de la torre
  * @param : Object Torre
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Torre)) return false;
    @SuppressWarnings("unchecked") Torre torre = (Torre) obj;
    if(torre.getColor() == this.getColor() && this.getPosicion().equals(torre.getPosicion())) return true;
    else return false;
  }

}
