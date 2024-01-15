import java.util.ArrayList;

public class Pawn extends Piece{

    @Override
    ArrayList<Integer> posMoves(int pos, int[] board, boolean wTurn) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(pos);
        int x = pos % 8;
        int y = pos / 8;
        if (board[wTurn ? (pos - 8):(pos + 8)] == 0) {
            res.add(wTurn ? (pos - 8):(pos + 8));
            if (wTurn ? (y == 6 && board[pos - 16] == 0):(y == 1 && board[pos + 16] == 0)) res.add(wTurn ? (pos - 16):(pos + 16));
        }
        if (x > 0) {
            if (isOp(wTurn ? (pos - 9):(pos + 7), board, wTurn)) res.add(wTurn ? (pos - 9):(pos + 7));
        }
        if (x < 7) {
            if (isOp(wTurn ? (pos - 7):(pos + 9), board, wTurn)) res.add(wTurn ? (pos - 7):(pos + 9));
        }
        return res;
    }
}
