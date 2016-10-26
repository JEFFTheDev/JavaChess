/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author jeffrey
 */
public class Move {
    
    private int x;
    private int y;
    private int dia;
    
    public Move(int x, int y, int dia){
        this.x = x;
        this.y = y;
        this.dia = dia;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getDia(){
        return dia;
    }
}
