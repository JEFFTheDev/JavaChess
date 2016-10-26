/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;

/**
 *
 * @author jeffrey
 */
public class AI {
    private Chesspiece[] priorities;
    private ArrayList<Tile> chessBoard;
    
    
    public AI(Chesspiece[] priorities, ArrayList<Tile> chessBoard){
        this.priorities = priorities;
        this.chessBoard = chessBoard;
    }
    
    public String nextStep(){
        //Calculate next step based on priorities and chessboard
        String position = "";
        return position;
    }
}