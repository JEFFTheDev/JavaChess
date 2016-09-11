/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author jeffrey
 */
public class Tile {
    
    private Chesspiece chessPiece;
    private JButton tile;
    private String position;
    
    public Tile(JButton tile, String position){
        this.tile = tile;
        this.position = position;
    }
    
    public void setChessPiece(Chesspiece chessPiece){
        tile.setIcon(chessPiece.getImage());
        this.chessPiece = chessPiece;
    }
    
    public Chesspiece getChessPiece(){
        return chessPiece;
    }
    
    public JButton getTile(){
        return tile;
    }
    
    public String getPosition(){
        return position;
    }
    
}
