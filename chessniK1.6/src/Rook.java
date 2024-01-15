import java.util.ArrayList;

public class Rook extends Piece{
    @Override
    ArrayList<Integer> posMoves(int pos, int[] board, boolean wTurn) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(pos);
        int tmp = pos;

        while (tmp % 8 > 0) {
            if (board[tmp - 1] == 0) {
                res.add(--tmp);//i see
                continue;
            }
            if (isOp(tmp - 1, board, wTurn)) res.add(tmp - 1);
            break;
        }
        tmp = pos;

        while (tmp % 8 < 7) {
            if (board[tmp + 1] == 0) {
                res.add(++tmp);
                continue;
            }
            if (isOp(tmp + 1, board, wTurn)) res.add(++tmp);
            break;
        }
        tmp = pos;

        while (tmp / 8 > 0) {
            if (board[tmp - 8] == 0) {
                res.add(tmp - 8);
                tmp -= 8;
                continue;
            }
            if (isOp(tmp - 8, board, wTurn)) res.add(tmp - 8);
            break;
        }
        tmp = pos;
        while (tmp / 8 < 7) {
            if (board[tmp + 8] == 0) {
                res.add(tmp + 8);
                tmp += 8;
                continue;
            }
            if (isOp(tmp + 8, board, wTurn)) res.add(tmp + 8);
            break;
        }

        return res;
    }
}
