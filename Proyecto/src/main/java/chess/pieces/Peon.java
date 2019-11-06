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

  public void verificar(Posicion posicion, LinkedList<Posicion> lista){
    Tablero tablero = Tablero.getInstance();
    if(this.estaDentroTablero(posicion)) {
      Pieza pieza = tablero.getPieza(posicion);
      if(pieza.getColor() != this.getColor()){
        lista.add(posicion);
      }
    }
    return;
  }
  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    Tablero tablero = Tablero.getInstance();
    if (this.movimientosLegales == null) {
        this.movimientosLegales = new LinkedList<Posicion>();
        // Moviéndose para adelante
        if(this.getColor() == ColorEnum.NEGRO){
          Posicion siguientePosLegal = new Posicion(this.posicion.getX()+1, this.posicion.getY());
          verificar(siguientePosLegal, this.movimientosLegales);
          if(this.posicion.getX() == 1){
            verificar(new Posicion(this.posicion.getX()+2, this.posicion.getY()), this.movimientosLegales);
          }
        }
        else if(this.getColor() == ColorEnum.BLANCO){
          Posicion siguientePosLegal = new Posicion(this.posicion.getX()-1, this.posicion.getY());
          verificar(siguientePosLegal, this.movimientosLegales);
          if(this.posicion.getX() == 6){
            verificar(new Posicion(this.posicion.getX()-2, this.posicion.getY()), this.movimientosLegales);
          }
        }
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
