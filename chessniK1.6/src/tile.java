import javax.swing.*;

public class tile extends JButton {
    int ind;
    Piece piece;


    public tile(int ind) {
        super();
        this.ind = ind;
        this.piece = null;
    }

    public void tileSetUp(int i) {
        switch (i) {
            case 0: piece = null;
                this.setText(null);
                break;
            case 1: piece = new Pawn();
                this.setText("wPAWN");
                break;
            case 2: piece = new Knight();
                this.setText("wKNIGHT");
                break;
            case 3: piece = new Bishop();
                this.setText("wBISHOP");
                break;
            case 4: piece = new Rook();
                this.setText("wROOK");
                break;
            case 5: piece = new Queen();
                this.setText("wQUEEN");
                break;
            case 6: piece = new King();
                this.setText("wKING");
                break;
            case -1: piece = new Pawn();
                this.setText("bPAWN");
                break;
            case -2: piece = new Knight();
                this.setText("bKNIGHT");
                break;
            case -3: piece = new Bishop();
                this.setText("bBISHOP");
                break;
            case -4: piece = new Rook();
                this.setText("bROOK");
                break;
            case -5: piece = new Queen();
                this.setText("bQUEEN");
                break;
            case -6: piece = new King();
                this.setText("bKING");
                break;
            default:
                this.setText("def");

        }
    }
}

