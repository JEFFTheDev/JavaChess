/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private static Chesspiece queen = new Chesspiece("Queen", new ImageIcon(imagePath + "queen.png"), new String[]{"8e", "1e"});
    private static Chesspiece horse = new Chesspiece("Horse", new ImageIcon(imagePath + "horse.png"), new String[]{"8b", "1b", "8g", "1g"});
    private static Chesspiece tower = new Chesspiece("Tower", new ImageIcon(imagePath + "tower.png"), new String[]{"1a", "8a", "1h", "8h"});
    private static Chesspiece pawn = new Chesspiece("Pawn", new ImageIcon(imagePath + "pawn.png"), new String[]{"7a", "7b", "7c", "7d","7e","7f","7g","7h","2a","2b","2c","2d","2e","2f","2g","2h"});
    private static Chesspiece bishop = new Chesspiece("Bishop", new ImageIcon(imagePath+"bishop.png"), new String[]{"8c","8f","1c","1f"});
    
    private static ArrayList<Chesspiece> chessPieces = new ArrayList<Chesspiece>();

    public static void main(String[] args) {

        chessPieces.add(king);
        chessPieces.add(horse);
        chessPieces.add(tower);
        chessPieces.add(pawn);
        chessPieces.add(bishop);
        chessPieces.add(queen);

        

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

            final JButton chessTile = new JButton();
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

            if (columnNumber <= alphArray.length && numberOfRow <= rowArray.length) {
                String position = rowArray[numberOfRow] + alphArray[columnNumber] + "";
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

            chessTile.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    System.out.print(findPieceFromImage(chessTile.getIcon()).getName()+"\n");
                    System.out.print(findTileFromButton(chessTile).getPosition()+"\n");
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                   
                }
            });

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

                int oldWidth = f.getWidth();
                int oldHeight = f.getHeight();

                for (int i = 0; i < chessTileList.size(); i++) {
                    int newWidth = f.getWidth() / oldWidth;
                    int newHeight = f.getHeight() / oldHeight;

                    oldWidth = newWidth;
                    oldHeight = newHeight;

                    //TODO make image scale with screen size
                    
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

    //Put all the pieces on the correct tile
    private static void setupGame() {
        //Chesspieces = i
        //Tiles = number
        //Positions = count

        for (int i = 0; i < chessPieces.size(); i++) {
            for (String position : chessPieces.get(i).getPositions()) {
                for (int number = 0; number < chessTileList.size(); number++) {
                    if (chessTileList.get(number).getPosition().equals(position)) {
                        chessTileList.get(number).setChessPiece(chessPieces.get(i));
                    }
                }
            }
        }
    }

    //TODO refactor getPossiblePosition into move class
    private static ArrayList<String> getPossiblePosition(Chesspiece chessPiece, String position) {
        ArrayList<String> positions = new ArrayList<String>();

        String[] yArray = "1 2 3 4 5 6 7 8".split(" ");
        String[] xArray = "a b c d e f g h".split(" ");

        switch (chessPiece.getName()) {
            case "King":

                break;
            case "Horse":
                String y = position.substring(0, 1);
                String x = position.substring(1, 2);

                if (Arrays.asList(xArray).contains(x) && Arrays.asList(yArray).contains(y)) {
                    String newX = "";
                    String newY = "";

                    for (int i = 0; i < xArray.length; i++) {
                        if (xArray[i].equals(x)) {
                            newX = xArray[i + 1];
                        }

                        if (yArray[i].equals(y)) {
                            newY = yArray[i + 2];
                        }
                    }
                            
                    String possiblePosition = newY + newX;
                    positions.add(possiblePosition);
                    System.out.println(possiblePosition);

                }
                break;
        }
        return positions;
    }
    
    private static Chesspiece findPieceFromImage(Icon image){
        Chesspiece c =  new Chesspiece("Empty", new ImageIcon(), new String[]{""});
        for(int i = 0; i< chessPieces.size(); i++){
            if(chessPieces.get(i).getImage() == image){
               c = chessPieces.get(i);
            }
        }
        return c;
    }
    
    private static Tile findTileFromButton(JButton b){
        Tile c =  new Tile();
        for(int i = 0; i< chessTileList.size(); i++){
            if(chessTileList.get(i).getTile().equals(b)){
               c = chessTileList.get(i);
            }
        }
        return c;
    }
}