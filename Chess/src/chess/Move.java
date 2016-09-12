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
    
    int[] x;
    int[] y;
    int[] dia;
    
    public Move(int[] x, int[] y, int [] dia){
        this.x = x;
        this.y = y;
        this.dia = dia;
    }
}
