/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.applet.Applet;
import java.awt.Button;
import java.awt.GridLayout;

/**
 *
 * @author jeffrey
 */
public class Chessboard extends Applet{
    
    private GridLayout chessBoard;
    
    public Chessboard(){
        this.chessBoard = new GridLayout(8,8);
    
        
    }
    
    public GridLayout getChessboardLayout(){
        return chessBoard;
    }
    
    
    
    
}
