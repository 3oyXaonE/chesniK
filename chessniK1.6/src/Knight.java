import java.util.ArrayList;

public class Knight extends Piece{
    @Override
    ArrayList<Integer> posMoves(int pos, int[] board, boolean wTurn) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(pos);
        int x = pos % 8;
        int y = pos / 8;
        if (x > 0) {
            if (y > 1) {
                if (!isSame(pos - 17, board, wTurn)) res.add(pos - 17);
            }
            if (y < 6) {
                if (!isSame(pos + 15, board, wTurn)) res.add(pos + 15);
            }

            if (x > 1) {
                if (y > 0) {
                    if (!isSame(pos - 10, board, wTurn)) res.add(pos - 10);
                }
                if (y < 7) {
                    if (!isSame(pos + 6, board, wTurn)) res.add(pos + 6);
                }
            }
        }
        if (x < 7) {
            if (y > 1) {
                if (!isSame(pos - 15, board, wTurn)) res.add(pos - 15);
            }
            if (y < 6) {
                if (!isSame(pos + 17, board, wTurn)) res.add(pos + 17);
            }

            if (x < 6) {
                if (y > 0) {
                    if (!isSame(pos - 6, board, wTurn)) res.add(pos - 6);
                }
                if (y < 7) {
                    if (!isSame(pos + 10, board, wTurn)) res.add(pos + 10);
                }
            }
        }

        return res;
    }
}
