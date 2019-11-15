package gui;

import chess.items.Tablero;
import chess.items.Posicion;
import chess.items.ColorEnum;
import chess.pieces.EnumPieza;
import chess.pieces.Pieza;
import processing.core.PApplet;
import processing.core.PImage;

public class ChessGUI extends PApplet{
    int PIXEL_SIZE = 70;
    Tablero board = Tablero.getInstance();
    PImage torre_negra, torre_blanca;
    PImage alfil_negro, alfil_blanco;
    PImage peon_blanco, peon_negro;
    PImage caballo_negro, caballo_blanco;
    PImage rey_blanco, rey_negro;
    PImage reina_negro, reina_blanco;

    public static void main(String[] args) {
        PApplet.main("gui.ChessGUI");
    }

    @Override
    public void settings(){
        size(550,550);
    }

    @Override
    public void setup(){
        System.out.println(board.toString());
        torre_blanca   = loadImage(getClass().getResource("/white-rook-50.png").getPath());
        torre_negra    = loadImage(getClass().getResource("/black-rook-50.png").getPath());
        caballo_blanco = loadImage(getClass().getResource("/white-knight-50.png").getPath());
        caballo_negro= loadImage(getClass().getResource("/black-knight-50.png").getPath());
        alfil_negro  = loadImage(getClass().getResource("/black-bishop-50.png").getPath());
        alfil_blanco = loadImage(getClass().getResource("/white-bishop-50.png").getPath());
        reina_negro  = loadImage(getClass().getResource("/black-queen-50.png").getPath());
        reina_blanco = loadImage(getClass().getResource("/white-queen-50.png").getPath());
        rey_negro    = loadImage(getClass().getResource("/black-king-50.png").getPath());
        rey_blanco   = loadImage(getClass().getResource("/white-king-50.png").getPath());
        peon_negro   = loadImage(getClass().getResource("/black-pawn-50.png").getPath());
        peon_blanco  = loadImage(getClass().getResource("/white-pawn-50.png").getPath());
    }

    @Override
    public void draw(){
        drawBoard();
    }

    public void drawBoard(){
        for (int i = 0; i < board.getSize();i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if(i%2==0){
                    if(j%2==0)fill(45,45,45);
                    else fill(255,255,255);
                }else{
                    if(j%2==0)fill(255,255,255);
                    else fill(45,45,45);
                }
                rect(i*PIXEL_SIZE,j*PIXEL_SIZE,PIXEL_SIZE,PIXEL_SIZE);
                Pieza p = board.getPieza(new Posicion(i, j), 0);
                drawPiece(p);
            }
        }
    }

    public void drawPiece(Pieza p){
        int x = p.getPosicion().getY();
        int y = p.getPosicion().getX();
        switch (p.getTipo()){
            case TORRE:
                if(p.getColor().equals(ColorEnum.BLANCO))
                    image(torre_blanca,x*PIXEL_SIZE,y*PIXEL_SIZE);
                if(p.getColor().equals(ColorEnum.NEGRO))
                    image(torre_negra,x*PIXEL_SIZE,y*PIXEL_SIZE);
                break;

            case CABALLO:
              if(p.getColor().equals(ColorEnum.BLANCO))
                  image(caballo_blanco,x*PIXEL_SIZE,y*PIXEL_SIZE);
              if(p.getColor().equals(ColorEnum.NEGRO))
                  image(caballo_negro,x*PIXEL_SIZE,y*PIXEL_SIZE);
                  break;

            case ALFIL:
              if(p.getColor().equals(ColorEnum.BLANCO))
                  image(alfil_blanco,x*PIXEL_SIZE,y*PIXEL_SIZE);
              if(p.getColor().equals(ColorEnum.NEGRO))
                  image(alfil_negro,x*PIXEL_SIZE,y*PIXEL_SIZE);
              break;

            case REINA:
              if(p.getColor().equals(ColorEnum.BLANCO))
                  image(reina_blanco,x*PIXEL_SIZE,y*PIXEL_SIZE);
              if(p.getColor().equals(ColorEnum.NEGRO))
                  image(reina_negro,x*PIXEL_SIZE,y*PIXEL_SIZE);
              break;

            case REY:
              if(p.getColor().equals(ColorEnum.BLANCO))
                  image(rey_blanco,x*PIXEL_SIZE,y*PIXEL_SIZE);
              if(p.getColor().equals(ColorEnum.NEGRO))
                  image(rey_negro,x*PIXEL_SIZE,y*PIXEL_SIZE);
              break;

            case PEON:
              if(p.getColor().equals(ColorEnum.BLANCO))
                  image(peon_blanco,x*PIXEL_SIZE,y*PIXEL_SIZE);
              if(p.getColor().equals(ColorEnum.NEGRO))
                  image(peon_negro,x*PIXEL_SIZE,y*PIXEL_SIZE);
              break;

            default:
                break;
        }
    }

    @Override
    public void mouseClicked(){
      int x = mouseX / PIXEL_SIZE;
      int y = mouseY / PIXEL_SIZE;
      Posicion p = new Posicion(y,x);
      System.out.println(p);
      Pieza pieza = board.getPieza(p);
      dibujaMovimientosPosibles(pieza);
    }

    public void dibujaMovimientosPosibles(Pieza pieza){
      stroke(255,0,0);
      fill(144,144,144,100);
      for(Posicion p : pieza.obtenerMovimientosLegales()){
        int x = p.getY();
        int y = p.getX();
        rect(x*PIXEL_SIZE, y*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
      }
      stroke(0,0,0);
    }

}
