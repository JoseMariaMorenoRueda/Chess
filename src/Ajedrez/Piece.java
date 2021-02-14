package Ajedrez;

import java.io.Serializable;

public class Piece implements Serializable {
    public enum TypeOfPiece {PAWN, TOWER, KNIGHT, BISHOP, QUEEN, KING}
    public enum Color {BLACK, WHITE}

    TypeOfPiece type;
    Color color;

    public Piece(TypeOfPiece t, Color c) {
        this.type = t;
        this.color = c;
    }

    @Override
    public String toString() {
        return this.color.toString() + " " + this.type.toString();
    }

    public static void main(String[] args) {
        Piece myPiece = new Piece(TypeOfPiece.KNIGHT, Color.BLACK);
        System.out.println(myPiece.toString());
    }
}

