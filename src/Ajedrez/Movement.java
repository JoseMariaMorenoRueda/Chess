package Ajedrez;

import java.io.IOException;

public class Movement {
    public Piece piece;
    public char columnOriginal;
    public int rowOriginal;
    public char columnDestination;
    public int rowDestination;

    public Movement(Piece p,char co, int ro, char cd, int rd) {
        this.piece = p;
        //Así se pasa el caracter a mayusculas
        this.columnOriginal = Character.toUpperCase(co);
        //this.rowOriginal = ro - 1;
        this.rowOriginal = ro;
        this.columnDestination = Character.toUpperCase(cd);
        //this.rowDestination = rd -1;
        this.rowDestination = rd;
    }

    @Override
    public String toString(){
        //return piece + " from " + columnOriginal + (rowOriginal + 1) + " to " + columnDestination + (rowDestination + 1);
        return piece + " from " + columnOriginal + rowOriginal + " to " + columnDestination + rowDestination;
    }

    public static void main(String[] args) throws IOException {
        Board testMovement = new Board();
        Movement movement = new Movement(testMovement.KW1, 'd', 8, 'c', 7);

        System.out.println(movement);
    }
}

