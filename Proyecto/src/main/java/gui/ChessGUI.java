package gui;
import chess.items.Tablero;
import chess.items.Posicion;
import chess.items.ColorEnum;
import chess.pieces.EnumPieza;
import chess.pieces.Pieza;
import processing.core.PApplet;
import processing.core.PImage;

public class ChessGUI extends PApplet{
    int PIXEL_SIZE = 50;
    Tablero board = Tablero.getInstance();
    PImage black_rook;
    PImage white_rook;
    public static void main(String[] args) {
        PApplet.main("gui.ChessGUI");
    }

    @Override
    public void settings(){
        size(400,400);
    }

    @Override
    public void setup(){
        System.out.println(board.toString());
        black_rook = loadImage(getClass().getResource("/black-rook-50.png").getPath());
        white_rook = loadImage(getClass().getResource("/white-rook-50.png").getPath());
    }

    @Override
    public void draw(){
        drawBoard();

    }

    public void drawBoard(){
        for (int i = 0; i < board.getSize();i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if(i%2==0){
                    if(j%2==0)fill(10,108,3);
                    else fill(255,255,255);
                }else{
                    if(j%2==0)fill(255,255,255);
                    else fill(10,108,3);
                }
                rect(i*PIXEL_SIZE,j*PIXEL_SIZE,PIXEL_SIZE,PIXEL_SIZE);
                Pieza p = board.getPieza(new Posicion(i, j));
                drawPiece(p);
            }
        }
    }

    public void drawPiece(Pieza p){
        int x = p.getPosicion().getX();
        int y = p.getPosicion().getY();
        switch (p.getTipo()) {
            case EnumPieza.TORRE:
                if(p.getColor().equals(ColorEnum.BLANCO))
                    image(white_rook,x*PIXEL_SIZE,y*PIXEL_SIZE);
                if(p.getColor().equals(ColorEnum.NEGRO))
                    image(black_rook,x*PIXEL_SIZE,y*PIXEL_SIZE);
                break;
            case EnumPieza.EMPTY:
                break;
            default:
                break;
        }
    }

}
