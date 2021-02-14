package Ajedrez;

import java.io.*;

public class Board {
    static Piece[][] myBoard= new Piece [8][8];
    static Piece  tb1, kb1, bb1, qub, kib, bb2, kb2, tb2, pb1, pb2, pb3, pb4, pb5, pb6, pb7, pb8;
    static Piece TW1, KW1, BW1, QUW, KIW, BW2, KW2, TW2, PW1, PW2, PW3, PW4, PW5, PW6, PW7, PW8;
    private String dataFileTxt = "C:\\Users\\Jose\\Desktop\\outputChess.txt";
    static String dataFileObject = "C:\\Users\\Jose\\Desktop\\outputChess";

    private String[] arrayString = new String[64];

    public Board() throws IOException {
        myBoard[0][0] = TW1 = new Piece(Piece.TypeOfPiece.TOWER, Piece.Color.WHITE);
        myBoard[0][1] = KW1 = new Piece(Piece.TypeOfPiece.KNIGHT, Piece.Color.WHITE);
        myBoard[0][2] = BW1 = new Piece(Piece.TypeOfPiece.BISHOP, Piece.Color.WHITE);
        myBoard[0][3] = QUW = new Piece(Piece.TypeOfPiece.QUEEN, Piece.Color.WHITE);
        myBoard[0][4] = KIW = new Piece(Piece.TypeOfPiece.KING, Piece.Color.WHITE);
        myBoard[0][5] = BW2 = new Piece(Piece.TypeOfPiece.BISHOP, Piece.Color.WHITE);
        myBoard[0][6] = KW2 = new Piece(Piece.TypeOfPiece.KNIGHT, Piece.Color.WHITE);
        myBoard[0][7] = TW2 = new Piece(Piece.TypeOfPiece.TOWER, Piece.Color.WHITE);

        myBoard [1][0] = PW1 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.WHITE);
        myBoard [1][1] = PW2 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.WHITE);
        myBoard [1][2] = PW3 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.WHITE);
        myBoard [1][3] = PW4 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.WHITE);
        myBoard [1][4] = PW5 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.WHITE);
        myBoard [1][5] = PW6 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.WHITE);
        myBoard [1][6] = PW7 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.WHITE);
        myBoard [1][7] = PW8 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.WHITE);

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                myBoard[i][j] = null;
            }
        }

        myBoard[6][0] = pb1 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.BLACK);
        myBoard[6][1] = pb2 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.BLACK);
        myBoard[6][2] = pb3 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.BLACK);
        myBoard[6][3] = pb4 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.BLACK);
        myBoard[6][4] = pb5 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.BLACK);
        myBoard[6][5] = pb6 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.BLACK);
        myBoard[6][6] = pb7 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.BLACK);
        myBoard[6][7] = pb8 = new Piece(Piece.TypeOfPiece.PAWN, Piece.Color.BLACK);

        myBoard[7][0] = tb1 = new Piece(Piece.TypeOfPiece.TOWER, Piece.Color.BLACK);
        myBoard[7][1] = kb1 = new Piece(Piece.TypeOfPiece.KNIGHT, Piece.Color.BLACK);
        myBoard[7][2] = bb1 = new Piece(Piece.TypeOfPiece.BISHOP, Piece.Color.BLACK);
        myBoard[7][3] = qub = new Piece(Piece.TypeOfPiece.QUEEN, Piece.Color.BLACK);
        myBoard[7][4] = kib = new Piece(Piece.TypeOfPiece.KING, Piece.Color.BLACK);
        myBoard[7][5] = bb2 = new Piece(Piece.TypeOfPiece.BISHOP, Piece.Color.BLACK);
        myBoard[7][6] = kb2 = new Piece(Piece.TypeOfPiece.KNIGHT, Piece.Color.BLACK);
        myBoard[7][7] = tb2 = new Piece(Piece.TypeOfPiece.TOWER, Piece.Color.BLACK);
        this.archiveTXT();
        this.archiveObject();
    }

    public boolean movePiece(Movement myMovement) throws IOException {
        boolean b = true;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;


        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFileObject)));
            Object  str;
            String str2 = myMovement.columnOriginal + String.valueOf(myMovement.rowOriginal);
            Piece myPie;
            Object myP;
            try {
                while (true) {
                    str = in.readObject();
                    myP = in.readObject();
                    if (myP != null) {
                        if (str.toString().equals(str2)) {
                            myPie = (Piece) myP;
                    } else {
                        b = false;
                    }


                }
            }
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (EOFException eof) {
                System.exit(0);
            } finally {
            if (in != null)
                in.close();
        }





            String line = in.readLine();
            int counter = 0;
            while (line != null) {
                if (counter < 64) {
                    arrayString[counter] = line;
                }
                line = in.readLine();
                counter++;
            }

            for (int i = 0; i < 64; i++) {
                String[] s1 = arrayString[i].split(",");
                String s2 = myMovement.columnOriginal + String.valueOf(myMovement.rowOriginal);
                Piece myPiece = null;
                if (s1[0].equals(s2)) {
                    //myPiece =
                }
            }


        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }



        return b;
    }

    public void archiveTXT() {
        PrintWriter outputStream = null;
        char column = 'A';

        try {
            outputStream = new PrintWriter(new FileWriter(dataFileTxt));

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (i) {
                        case 0:
                            column = 'A';
                            break;
                        case 1:
                            column = 'B';
                            break;
                        case 2:
                            column = 'C';
                            break;
                        case 3:
                            column = 'D';
                            break;
                        case 4:
                            column = 'E';
                            break;
                        case 5:
                            column = 'F';
                            break;
                        case 6:
                            column = 'G';
                            break;
                        case 7:
                            column = 'H';
                            break;
                    }
                    outputStream.print(column);
                    outputStream.print( (j + 1) + ", ");
                    outputStream.println(this.myBoard[i][j]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void archiveObject() throws IOException {
        // Para poder escribir objetos en un archivo hay que hacer la clase Piece Serializable
        // implementando esa Interface con  implements Serializable
        ObjectOutputStream objectOut = null;
        char column = 'A';

        try {
            objectOut = new ObjectOutputStream((new FileOutputStream(dataFileObject)));
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (i) {
                        case 0:
                            column = 'A';
                            break;
                        case 1:
                            column = 'B';
                            break;
                        case 2:
                            column = 'C';
                            break;
                        case 3:
                            column = 'D';
                            break;
                        case 4:
                            column = 'E';
                            break;
                        case 5:
                            column = 'F';
                            break;
                        case 6:
                            column = 'G';
                            break;
                        case 7:
                            column = 'H';
                            break;
                    }
                    String s = column + String.valueOf(j + 1);
                    objectOut.writeObject(s);
                    objectOut.writeObject(this.myBoard[i][j]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOut != null)
                objectOut.close();
        }


    }

    public static void main(String[] args) throws IOException {
        Board myBoardExam = new Board();
        Movement movement = new Movement(TW1, 'd', 4, 'd', 6);
        myBoardExam.movePiece(movement);

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFileObject)));
            Object  str;
            Object myP;
            try {
                while (true) {
                    str = in.readObject();
                    myP = in.readObject();
                    if (myP != null) {
                        System.out.format("Cell: %s piece: %s %n", str.toString(), myP.toString());
                    } else {
                        System.out.format("Cell: %s piece: null %n", str.toString());
                    }


                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (EOFException eof) {
                System.exit(0);
            }
        } finally {
            if (in != null)
                in.close();

        }

        /*for (int i = 0; i < 64; i++) {
            System.out.println(myBoardExam.arrayString[i]);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println(myBoardExam.myBoard[i][j]);
            }
        }
        myBoardExam.archiveTXT();
        myBoardExam.archiveObject();
*/

    }
}

