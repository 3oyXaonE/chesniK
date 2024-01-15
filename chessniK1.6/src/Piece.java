import java.util.ArrayList;

public abstract class Piece {

    abstract ArrayList<Integer> posMoves(int pos, int[] board, boolean wTurn);

    boolean isOp(int ind, int[]board, boolean wTurn) {
        if (wTurn) return isB(ind, board);
        return isW(ind, board);
    }
    boolean isSame(int ind, int[]board, boolean wTurn) {
        if (wTurn) return isW(ind, board);
        return isB(ind, board);
    }
    boolean isW(int ind, int[] board) {
        return board[ind] > 0;
    }
    boolean isB(int ind, int[] board) {
        return board[ind] < 0;
    }

}
