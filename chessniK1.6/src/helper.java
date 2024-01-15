import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class helper implements ActionListener {
    private JFrame frame;
    private tile[] board;
    private int[] digBoard;
    private boolean wTurn = true;
    private boolean isClicked;
    private int clickedP;

    public helper() {
        frame = new JFrame("chessniK");
        board = createBoard();
        digBoard = new int[64];
        isClicked = false;
        wTurn = true;
        frameSetUp();
        pieceSetup();
    }
    private void frameSetUp() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.add(createMainPanel(board), BorderLayout.CENTER);
    }
    private tile[] createBoard() {
        tile[] res = new tile[64];
        for (int i=0; i<64; i++) {
            tile button = new tile(i);
            button.setPreferredSize(new Dimension(64, 64));
            if ((i / 8) % 2 == 1) {
                button.setBackground(i % 2 == 0 ? new Color(59, 41, 10):new Color(225, 210, 180));
            } else {
                button.setBackground(i % 2 == 0 ? new Color(225, 210, 180):new Color(59, 41, 10));
            }
            if (i < 48) button.setEnabled(false);
            button.setBorder(null);
            button.addActionListener(this);
            res[i] = button;
        }
        return res;
    }
    private JPanel createMainPanel(tile[] board) {
        JPanel panel = new JPanel(new GridLayout(8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        for (int i=0; i<64; i++) panel.add(board[i]);
        return panel;
    }
    private void pieceSetup() {
        for (int i = 0; i < 8; i++) {
            digBoard[8 + i] = -1;
            digBoard[48 + i] = 1;
            board[8 + i].tileSetUp(-1);
            board[48 + i].tileSetUp(1);
        }
        digBoard[0] = digBoard[7] = -4;
        digBoard[1] = digBoard[6] = -2;
        digBoard[2] = digBoard[5] = -3;
        digBoard[3] = -5;
        digBoard[4] = -6;

        digBoard[63] = digBoard[56] = 4;
        digBoard[62] = digBoard[57] = 2;
        digBoard[61] = digBoard[58] = 3;
        digBoard[59] = 5;
        digBoard[60] = 6;


        board[0].tileSetUp(-4);
        board[7].tileSetUp(-4);
        board[1].tileSetUp(-2);
        board[6].tileSetUp(-2);
        board[2].tileSetUp(-3);
        board[5].tileSetUp(-3);
        board[3].tileSetUp(-5);
        board[4].tileSetUp(-6);

        board[63].tileSetUp(4);
        board[56].tileSetUp(4);
        board[62].tileSetUp(2);
        board[57].tileSetUp(2);
        board[61].tileSetUp(3);
        board[58].tileSetUp(3);
        board[59].tileSetUp(5);
        board[60].tileSetUp(6);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tile src = (tile) e.getSource();
        if(!isClicked) {
            isClicked = true;
            clickedP = src.ind;
            flicker(src.piece.posMoves(clickedP, digBoard, wTurn));
            return;
        }
        int tmp = src.ind;
        if (tmp == clickedP) {
            setupTurn(wTurn);
            isClicked = false;
            return;
        }
        if (digBoard[tmp] != 0 && digBoard[tmp] % 6 == 0) {
            board[tmp].tileSetUp(digBoard[tmp]);
            board[clickedP].tileSetUp(0);
            ending(wTurn);
            return;
        }
        digBoard[tmp] = digBoard[clickedP];
        digBoard[clickedP] = 0;
        board[tmp].tileSetUp(digBoard[tmp]);
        board[clickedP].tileSetUp(0);
        isClicked = false;
        wTurn = !wTurn;
        setupTurn(wTurn);
    }

    private void setupTurn(boolean wTurn) {
        for (int i = 0; i < 64; i++) {
            if (board[i].getBackground() == Color.cyan) {
                if ((i / 8) % 2 == 1) {
                    board[i].setBackground(i % 2 == 0 ? new Color(59, 41, 10):new Color(225, 210, 180));
                } else {
                    board[i].setBackground(i % 2 == 0 ? new Color(225, 210, 180):new Color(59, 41, 10));
                }if ((i / 8) % 2 == 1) {
                    board[i].setBackground(i % 2 == 0 ? new Color(59, 41, 10):new Color(225, 210, 180));
                } else {
                    board[i].setBackground(i % 2 == 0 ? new Color(225, 210, 180):new Color(59, 41, 10));
                }
            }
            if (wTurn ? digBoard[i] > 0 : digBoard[i] < 0) board[i].setEnabled(true);
            else board[i].setEnabled(false);
        }
    }

    private void flicker(ArrayList<Integer> pos) {
        for (tile t:board) t.setEnabled(false);
        for (Integer i: pos) {
            board[i].setEnabled(true);
            board[i].setBackground(Color.cyan);
        }
    }

    private void ending(boolean wTurn) {
        for (int i = 0; i < 64; i++) {
            if (board[i].getBackground() == Color.cyan) {
                if ((i / 8) % 2 == 1) {
                    board[i].setBackground(i % 2 == 0 ? new Color(59, 41, 10):new Color(225, 210, 180));
                } else {
                    board[i].setBackground(i % 2 == 0 ? new Color(225, 210, 180):new Color(59, 41, 10));
                }
            }
            board[i].setEnabled(false);
        }
        board[27].setBackground(wTurn ? Color.WHITE:Color.BLACK);
        board[28].setBackground(wTurn ? Color.WHITE:Color.BLACK);
        board[27].setText(wTurn ? "WHITE":"BLACK");
        board[28].setText("WINS");

    }














}
