package chess;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author jeffrey
 */
public class Tile {

    private Chesspiece chessPiece;
    private JButton tile;
    private int position;
    private Color c;

    public Tile(JButton tile, int position, Color c) {
        this.tile = tile;
        this.position = position;
        this.c = c;
    }

    public Tile() {

    }

    public void setChessPiece(Chesspiece chessPiece, int i) {
        tile.setIcon(chessPiece.getImage()[i]);
        System.out.print(chessPiece.getImage()[i]+"\n");
        this.chessPiece = chessPiece;
    }

    public Chesspiece getChessPiece() {
        return chessPiece;
    }

    public JButton getTile() {
        return tile;
    }

    public int getPosition() {
        return position;
    }
    
    public Color getColor(){
        return c;
    }
}
