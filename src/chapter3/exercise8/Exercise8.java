package chapter3.exercise8;

public class Exercise8 {
    int[] aRow;
    int[] aCol;
    int[] bRow;
    int[] bCol;

    int aDiagonal1;
    int bDiagonal1;
    int aDiagonal2;
    int bDiagonal2;

    int round;

    public Exercise8() {
        initialize();
    }

    public void initialize() {
        aRow = new int[3];
        aCol = new int[3];
        bRow = new int[3];
        bCol = new int[3];

        aDiagonal1 = 0;
        bDiagonal1 = 0;
        aDiagonal2 = 0;
        bDiagonal2 = 0;

        round = 0;
    }

    public String makeMove(int[] moves) {
        if (round > 8)
            return "Please restart the game";
        int r = moves[0], c = moves[1];
        if (round % 2 == 1) {
            if (++bRow[r] == 3 || ++bCol[c] == 3 || (r == c && ++bDiagonal1 == 3) || (r + c == 2 && ++bDiagonal2 == 3))
                return "B";
        } else {
            if (++aRow[r] == 3 || ++aCol[c] == 3 || (r == c && ++aDiagonal1 == 3) || (r + c == 2 && ++aDiagonal2 == 3))
                return "A";
        }
        round++;
        return round == 9 ? "Draw" : "Pending";
    }
}
