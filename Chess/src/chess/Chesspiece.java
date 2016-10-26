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
    private ImageIcon[] image;
    private int[] startingPositions;
    private Move[] moves;
    private String imagePath= "src/resources/chess pieces/";

    public Chesspiece(String name, int[] startingPositions, Move[] m) {
        this.name = name;
        this.startingPositions = startingPositions;
        this.moves = m;
        
        this.image = new ImageIcon[]{new ImageIcon(imagePath + name+"_w.png"), new ImageIcon(imagePath+name+"_b.png")};
    }

    public String getName() {
        return name;
    }

    public ImageIcon[] getImage() {
        return image;
    }

    public int[] getPositions() {
        return startingPositions;
    }

    public Move[] getMoves() {
        return moves;
    }
    
    public void setImage(ImageIcon[] img){
        
        this.image = img;
    }
}
