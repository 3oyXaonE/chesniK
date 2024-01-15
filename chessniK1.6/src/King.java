import java.util.ArrayList;

public class King extends Piece{
    @Override
    ArrayList<Integer> posMoves(int pos, int[] board, boolean wTurn) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(pos);
        int x = pos % 8;
        int y = pos / 8;
        if (x > 0) {
            if (!isSame(pos - 1, board, wTurn)) res.add(pos - 1);
            if (y > 0 && !isSame(pos - 9, board, wTurn)) res.add(pos - 9);
            if (y < 7 && !isSame(pos + 7, board, wTurn)) res.add(pos + 7);
        }
        if (x < 7) {
            if (!isSame(pos + 1, board, wTurn)) res.add(pos - 1);
            if (y > 0 && !isSame(pos - 7, board, wTurn)) res.add(pos - 7);
            if (y < 7 && !isSame(pos + 9, board, wTurn)) res.add(pos + 9);
        }
        if (y > 0 && !isSame(pos - 8, board, wTurn)) res.add(pos - 8);
        if (y < 7 && !isSame(pos + 8, board, wTurn)) res.add(pos + 8);
        return res;
    }
}
