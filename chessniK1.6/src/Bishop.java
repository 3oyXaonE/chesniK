import java.util.ArrayList;

public class Bishop extends Piece{
    @Override
    ArrayList<Integer> posMoves(int pos, int[] board, boolean wTurn) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(pos);
        int tmp = pos;
        while (tmp % 8 > 0 && tmp / 8 > 0) {
            // nvm i dont need a debugger xd
            if (board[tmp - 9] == 0) {
                res.add(tmp - 9);
                tmp -= 9;
                continue;
            }
            if (isOp(tmp - 9, board, wTurn)) res.add(tmp - 9);
            break;
        }
        tmp = pos;

        while (tmp % 8 < 7 && tmp / 8 < 7) {
            if (board[tmp + 9] == 0) {
                res.add(tmp + 9);
                tmp += 9;
                continue;
            }
            if (isOp(tmp + 9, board, wTurn)) res.add(tmp + 9);
            break;
        }
        tmp = pos;

        // could do it the horse way but "variety woo" right?
        // also if you "keep a standard" me mf this is my
        // 1st project im trying to try all the shit i can out
        // fuck around to the MAX
        while (tmp % 8 > 0 && tmp / 8 < 7) {
            if (board[tmp + 7] == 0) {
                res.add(tmp + 7);
                tmp += 7;
                continue;
            }
            if (isOp(tmp + 7, board, wTurn)) res.add(tmp + 7);
            break;
        }
        tmp = pos;

        while (tmp % 8 < 7 && tmp / 8 > 0) {
            if (board[tmp - 7] == 0) {
                res.add(tmp - 7);
                tmp -= 7;
                continue;
            }
            if (isOp(tmp - 7, board, wTurn)) res.add(tmp - 7);
            break;
        }
        tmp = pos;

        return res;

    }
}
