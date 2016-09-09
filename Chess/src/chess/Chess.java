/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author jeffrey
 */
public class Chess extends JFrame {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        
        ArrayList<JButton> chessTileList= new ArrayList<JButton>();
        
        JFrame f = new Chess();

        Chessboard chessboard = new Chessboard();

        JPanel p = new JPanel();
        p.setSize(10, 10);
        p.setVisible(true);

        JButton chessboardButton = new JButton("Chessboard");

        chessboardButton.setVisible(true);

        p.setLayout(chessboard.getChessboardLayout());

        boolean b = false;

        int count = 0;
        for (int i = 0; i < 64; i++) {
            
            JButton chessTile = new JButton();
            if (b) {
                chessTile.setBackground(Color.white);
               
                count ++;
                //check if number is table of 8 so boolean b can be switched.
                if(count % 8 !=0){
                    b = false;
                }
                
            } else {
                chessTile.setBackground(Color.black);

                count ++;
                 //check if number is table of 8 so boolean b can be switched.
                 if(count % 8 !=0){
                    b = true;
                }

            }
            chessTileList.add(chessTile);
            p.add(chessTile);
        }

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 400);
        f.setVisible(true);

        p.setSize(10, 10);
        p.setVisible(true);

        f.add(p);
    }
}
