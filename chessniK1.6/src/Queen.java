import java.util.ArrayList;

public class Queen extends Piece{
    @Override
    ArrayList<Integer> posMoves(int pos, int[] board, boolean wTurn) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i: new Bishop().posMoves(pos, board, wTurn)) {
            res.add(i);
        }
        for (int i: new Rook().posMoves(pos, board, wTurn)) {
            res.add(i);
        }
        // lmao easy fix
        return res;
    }
}
