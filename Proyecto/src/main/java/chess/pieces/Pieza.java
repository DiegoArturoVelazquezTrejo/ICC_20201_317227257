package chess.pieces;
import chess.items.Posicion;
/**
* Clase Abstracta para las piezas de ajedrez
**/
public abstract class Pieza{
  /* Posición de la pieza*/
  private Posicion posicion;
  /* Tipo de pieza*/
  private EnumPieza tipoPieza;
  /* Color de la pieza */
  private ColorEnum colorPieza;
  /* Lista con los movimientos legales para las piezas*/
  private LinkedList<Posicion> movimientosLegales;

  /** Constructor para la pieza
  * @param : int[][] posicion de la pieza
  * @param : EnumPieza tipo de pieza que es
  * @param : ColorEnum color de la pieza
  **/
  public Pieza(Posicion posicion, EnumPieza tipoPieza, ColorEnum color){
    this.posicion = posicion;
    this.tipoPieza = tipoPieza;
    this.colorPieza = color;
  }

  /* Método para mover la pieza */
  abstract public void moverPieza(Posicion posicion);

  /* Método para validar el movimiento de la pieza */
  public boolean esMovimientoLegal(Posicion movimiento){
    return movimientosLegales.contains(movimiento) ? true : false;
  }
  /* Método que compara piezas */
  @Override
  public boolean equals(Object o){
    if((o instanceof Pieza)) return false;
    @SuppressWarnings("unchecked") Pieza pieza = (Pieza) o;
    if(pieza.getPosicion() != this.posicion || pieza.getTipo() != this.tipoPieza) return false;
  }
  /* Método para obtener la posición de la pieza */
  public Posicion getPosicion(){
    return this.posicion;
  }
  /* Método para obtener los métodos legales que tiene la pieza*/
  public LinkedList<Posicion> getMovimientosLegales(){
    return this.movimientosLegales;
  }
  /* Método para obtener el tipo de pieza*/
  public EnumPieza getTipo(){
    return this.tipoPieza;
  }
  /* Método para obtener el color de la pieza*/
  public ColorEnum getColor(){
    return this.colorPieza;
  }
}