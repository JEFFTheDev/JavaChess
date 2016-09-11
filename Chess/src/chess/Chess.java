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
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

/**
 *
 * @author jeffrey
 */
public class Chess extends JFrame {

    /**
     * @param args the command line arguments
     */
    private static String imagePath = "src/resources/chess pieces/";
    private static ArrayList<Tile> chessTileList = new ArrayList<Tile>();
    private static Chesspiece king = new Chesspiece("King", new ImageIcon(imagePath + "king.png"), new String[]{"8d", "1d"});
    private static Chesspiece horse = new Chesspiece("Horse", new ImageIcon(imagePath + "horse.png"), new String[]{"8b", "1b", "8g", "1g"});

    private static ArrayList<Chesspiece> chessPieces = new ArrayList<Chesspiece>();

    public static void main(String[] args) {

        chessPieces.add(king);
        chessPieces.add(horse);

        final JFrame f = new Chess();

        Chessboard chessboard = new Chessboard();

        JPanel p = new JPanel();
        p.setSize(10, 10);
        p.setVisible(true);

        JButton chessboardButton = new JButton("Chessboard");

        chessboardButton.setVisible(true);

        p.setLayout(chessboard.getChessboardLayout());

        boolean b = false;

        int count = 0;

        String[] alphArray = "a b c d e f g h".split(" ");

        int[] rowArray = {1, 2, 3, 4, 5, 6, 7, 8};

        int columnNumber = 0;
        int numberOfRow = 0;
        for (int i = 0; i < 64; i++) {

            JButton chessTile = new JButton();
            if (b) {
                chessTile.setBackground(Color.white);

                count++;
                //check if number is table of 8 so boolean b can be switched.
                if (count % 8 != 0) {
                    b = false;
                }

            } else {
                chessTile.setBackground(Color.black);

                count++;
                //check if number is table of 8 so boolean b can be switched.
                if (count % 8 != 0) {
                    b = true;
                }
            }

            //ImageIcon image = new ImageIcon("src/resources/chess pieces/king.png");
            //image.getImage().getScaledInstance(image.getIconWidth(), image.getIconHeight(), Image.SCALE_SMOOTH);
            //chessTile.setIcon(image);
            if (columnNumber <= alphArray.length && numberOfRow <= rowArray.length) {
                String position = rowArray[numberOfRow] + alphArray[columnNumber] + "";
                System.out.print(position + "\n");

                chessTileList.add(new Tile(chessTile, position));
            }

            if (columnNumber == 7) {
                if (numberOfRow <= rowArray.length) {
                    numberOfRow++;
                    columnNumber = 0;
                }
            } else {
                columnNumber++;
            }

            //chessTileList.get(i).setChessPiece(image);
            p.add(chessTile);
        }

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 400);
        f.setVisible(true);

        p.setSize(10, 10);
        p.setVisible(true);

        f.add(p);

        setupGame();

        f.addComponentListener(new ComponentListener() {

            public void componentResized(ComponentEvent e) {
                //Resize tiles
                System.err.println("resize");

                int oldWidth = f.getWidth();
                int oldHeight = f.getHeight();

                for (int i = 0; i < chessTileList.size(); i++) {
                    int newWidth = f.getWidth() / oldWidth;
                    int newHeight = f.getHeight() / oldHeight;

                    oldWidth = newWidth;
                    oldHeight = newHeight;

                    //TODO make image scale with screen size
                    //chessTileList.get(i).getChessPiece().getImage().getScaledInstance(chessTileList.get(i).getChessPiece().getIconWidth() * newWidth, chessTileList.get(i).getChessPiece().getIconHeight() * newHeight, Image.SCALE_SMOOTH);
                    //chessTileList.get(i).getChessPiece().getImage().
                    //setSize(chessTileList.get(i).getWidth() * newWidth, chessTileList.get(i).getHeight() * newHeight);
                }
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }

        });
    }

    private static void setupGame() {
        //Chesspieces = i
        //Tiles = number
        //Positions = count
       
        for (int i = 0; i < chessPieces.size(); i++) {
            for (int count = 0; count < chessPieces.get(i).getPositions().length; count++) {
                for(int number =0; number< chessTileList.size(); number++){
                    System.err.println(chessTileList.get(number).getPosition()+"//"+chessPieces.get(i).getPositions()[count]);
                      if(chessTileList.get(number).getPosition().equals(chessPieces.get(i).getPositions()[count])){
                           chessTileList.get(number).setChessPiece(chessPieces.get(i));
                      }
                }
            }
        }
    }
}
