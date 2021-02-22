import java.lang.Math;

public class Board {
    private static int pieces;

    public static void populate() {
        pieces = (int)(Math.random() * (50 - 10 + 1) + 10);
    }

    public static int getNumPieces() {
        return pieces;
    }

    public static void removePieces(int numPieces) {
        pieces = getNumPieces() - numPieces;
    }
}
