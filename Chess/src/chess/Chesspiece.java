/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import javax.swing.ImageIcon;

/**
 *
 * @author jeffrey
 */
public class Chesspiece {
    private String name;
    private ImageIcon image;
    private String[] startingPositions;
    private String currentPosition;
    
    public Chesspiece(String name, ImageIcon image, String[] startingPositions){
        this.name = name;
        this.image = image;
        this.startingPositions = startingPositions;
    }
    
    public String getName(){
        return name;
    }
    
    public ImageIcon getImage(){
        return image;
    }
    
    public String[] getPositions(){
        return startingPositions;
    }
    
    public String getCurPosition(){
        return currentPosition;
    }
    
    public void setPosition(Tile t){
        currentPosition = t.getPosition();
        t.setChessPiece(this);
    }
}
