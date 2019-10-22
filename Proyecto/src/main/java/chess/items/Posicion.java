package chess.items;

/* Clase posición para determinar la posición de las piezas dentro de la matriz del tablero*/
public class Posicion{
  /* Componente x de la matriz*/
  private int x;
  /* Componente y de la matriz*/
  private int y;

  /* Constructor de la clase Posicion */
  public Posicion(int x, int y){
    this.x = x;
    this.y = y;
  }
  /**
  * Método para comparar dos posiciones
  * @param : Object posicion 
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Posicion)) return false;
    @SuppressWarnings("unchecked") Posicion pos = (Posicion) obj;
    if(pos.getX() == this.getX() && this.getY() == pos.getY()) return true;
    return false;
  }
  /* Getter para el atributo x*/
  public int getX(){ return x; }
  /* Getter para el atrobuto y*/
  public int getY(){ return y; }
}
