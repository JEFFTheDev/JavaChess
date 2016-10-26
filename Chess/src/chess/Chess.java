/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import javax.swing.Icon;
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
    private static final String imagePath = "src/resources/chess pieces/";
    private static final ArrayList<Tile> chessTileList = new ArrayList<>();

    //Pawn moves
    final private static Move oneForward = new Move(0, -1, 0);
    final private static Move oneBackward = new Move(0, 1, 0);

    //Horse moves
    final private static Move oneRighttwoForward = new Move(1, -2, 0);
    final private static Move twoRightoneForward = new Move(2, -1, 0);

    //Bishop moves
    final private static Move diaMove = new Move(0, 0, 8);

    //Tower moves
    final private static Move fullForward = new Move(0, -8, 0);
    final private static Move fullBackward = new Move(0, 8, 0);
    final private static Move fullLeft = new Move(-8, 0, 0);
    final private static Move fullRight = new Move(8, 0, 0);

    final public static Chesspiece king = new Chesspiece("King", new int[]{14, 84}, new Move[]{oneForward});
    final private static Chesspiece queen = new Chesspiece("Queen", new int[]{15, 85}, new Move[]{oneForward});
    final private static Chesspiece horse = new Chesspiece("Horse", new int[]{82, 87, 12, 17}, new Move[]{oneForward, oneRighttwoForward, twoRightoneForward});
    final private static Chesspiece tower = new Chesspiece("Tower",  new int[]{88, 81, 18, 11}, new Move[]{oneForward});
    final private static Chesspiece pawn = new Chesspiece("Pawn", new int[]{71, 72, 73, 74, 75, 76, 77, 78, 21, 22, 23, 24, 25, 26, 27, 28}, new Move[]{oneForward});
    final private static Chesspiece bishop = new Chesspiece("Bishop", new int[]{83, 86, 13, 16}, new Move[]{oneForward});

    private static ArrayList<Chesspiece> chessPieces = new ArrayList<Chesspiece>();

    private static JButton tileSel;

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

            if (columnNumber <= rowArray.length && numberOfRow <= rowArray.length) {
                String positionString = rowArray[numberOfRow] + "" + rowArray[columnNumber];
                int position = Integer.parseInt(positionString);

                chessTileList.add(new Tile(chessTile, position, chessTile.getBackground()));
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

                ArrayList<Integer> posList;

                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    System.out.print("Chesspiece: " + findPieceFromImage(chessTile.getIcon()).getName() + "\nPosition: " + findTileFromButton(chessTile).getPosition() + "\nSide: " + chessTile.getIcon().toString() + "\n");

                    posList = getPosPositions(findTileFromButton(chessTile));

                    for (int i = 0; i < posList.size(); i++) {
                        findTileFromPosition(posList.get(i)).getTile().setBackground(Color.DARK_GRAY);
                    }
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {

                    //if (tileSel != chessTile && tileSel != null) {
                        revertColors();
                    //}

                }
            });

            chessTile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    ArrayList<Integer> posList = getPosPositions(findTileFromButton(chessTile));

                    for (int i = 0; i < posList.size(); i++) {
                        //findTileFromPosition(posList.get(i)).getTile().setBackground(Color.DARK_GRAY);
                    }
                    
                    //tileSel = chessTile;
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

            @Override
            public void componentResized(ComponentEvent e) {
                //Resize tile images
                int oldWidth = f.getWidth();
                int oldHeight = f.getHeight();

                for (Tile chessTileList1 : chessTileList) {
                    int newWidth = f.getWidth() / oldWidth;
                    int newHeight = f.getHeight() / oldHeight;

                    oldWidth = newWidth;
                    oldHeight = newHeight;

                    //TODO make image scale with screen size
                    //hessTileList.get(i).getChessPiece().getImage().getImage().getScaledInstance(chessTileList.get(i).getChessPiece().getImage().getIconWidth() * newWidth, chessTileList.get(i).getChessPiece().getImage().getIconHeight() * newHeight, Image.SCALE_SMOOTH);
                    /*BufferedImage bi = new BufferedImage(chessTileList.get(i).getChessPiece().getImage().getImage().getWidth(null), chessTileList.get(i).getChessPiece().getImage().getImage().getHeight(null), BufferedImage.TYPE_INT_ARGB);
                    Graphics g = bi.createGraphics();
                    g.drawImage(chessTileList.get(i).getChessPiece().getImage().getImage(), 0, 0, WIDTH, HEIGHT, null);
                    
                    chessTileList.get(i).getChessPiece().setImage(chessTileList.get(i).getChessPiece().getImage().getImage().getScaledInstance(WIDTH, HEIGHT, WIDTH));
                    ImageIcon newIcon = new ImageIcon(bi); */
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
            for (int position : chessPieces.get(i).getPositions()) {
                for (int number = 0; number < chessTileList.size(); number++) {
                    if (chessTileList.get(number).getPosition() == position) {
                        int bOrW= 0;
                        
                        if(position <= 48){
                            bOrW = 1;
                        }
                        
                        System.out.print(bOrW);
                        chessTileList.get(number).setChessPiece(chessPieces.get(i), bOrW);
                    }
                }
            }
        }
    }

    private static ArrayList<Integer> getPosPositions(Tile t) {
        ArrayList<Integer> positions = new ArrayList<>();

        int p = t.getPosition();

        if (t.getChessPiece() != null) {
            for (Move move : t.getChessPiece().getMoves()) {
                //Split position in 2

                String posYString = String.valueOf(p).substring(0, 1);
                String posXString = String.valueOf(p).substring(1, 2);

                int posY = Integer.parseInt(posYString);
                int posX = Integer.parseInt(posXString);

                //Calculate new x and y
                int plusMin;

                if (t.getTile().getIcon().toString().contains("_w")) {
                    plusMin = -1;
                } else {
                    plusMin = 1;
                }

                posY += move.getY() * plusMin;
                posX += move.getX() * plusMin;

                /*if(posY > 8){
                posY *= -1;
            }
            
            if(posX > 8){
                posX *= -1;
            }*/
                String newPossiblePositionString = posY + "" + posX;
                int possiblePos = Integer.parseInt(newPossiblePositionString);

                if (findTileFromPosition(possiblePos).getChessPiece() == null) {
                    positions.add(possiblePos);
                }

                System.out.print("POSSIBLE POSITION: " + possiblePos + "\n");
            }
        }
        return positions;
    }

    private static Chesspiece findPieceFromImage(Icon image) {
        Chesspiece c = new Chesspiece("Empty", new int[]{}, new Move[]{});
        for (int i = 0; i < chessPieces.size(); i++) {
            for(int count = 0; count < 1; count ++){
                if (chessPieces.get(i).getImage()[count] == image) {
                 c = chessPieces.get(i);
                }
            }
        }
        return c;
    }

    private static Tile findTileFromButton(JButton b) {
        Tile c = new Tile();
        for (int i = 0; i < chessTileList.size(); i++) {
            if (chessTileList.get(i).getTile().equals(b)) {
                c = chessTileList.get(i);
            }
        }
        return c;
    }

    private static Tile findTileFromPosition(int pos) {
        Tile t = new Tile();
        for (int i = 0; i < chessTileList.size(); i++) {
            if (chessTileList.get(i).getPosition() == pos) {
                t = chessTileList.get(i);
            }
        }
        return t;
    }

    private void setChessPiece(Chesspiece c, Tile tile, int newPos) {
        tile.getTile().setIcon(null);
        findTileFromPosition(newPos).setChessPiece(c, 0);
    }

    //Check if a position is out of bounds
    private boolean outOfBounds(int pos) {
        boolean outOfBound;

        String posXString = String.valueOf(pos).substring(0, 1);
        String posYString = String.valueOf(pos).substring(1, 2);

        int posX = Integer.parseInt(posXString);
        int posY = Integer.parseInt(posYString);

        outOfBound = posX > 8 || posY > 8;

        return outOfBound;
    }
    
    private static void revertColors(){
        for(int i = 0; i< chessTileList.size(); i++){
            Tile t = chessTileList.get(i);
            t.getTile().setBackground(t.getColor());
        }
    }
}