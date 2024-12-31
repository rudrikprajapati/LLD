package tictactoe;

import java.util.ArrayList;

class Board {
    ArrayList<ArrayList<Symbol>> board = new ArrayList<>();
    Board() {
        for(int i = 0; i < 3; i++) {
            board.add(new ArrayList<>());
            for(int j = 0; j < 3; j++) {
                board.get(i).add(Symbol.E);
            }
        }
    }

    void printBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(board.get(i).get(j));
            }
            System.out.print("\n");
        }
    }

    boolean canMove(int row, int column) {
        return board.get(row).get(column) == Symbol.E;
    }

    boolean isWin(Symbol s) {
        for(int i = 0; i < 3; i++) {
            if(board.get(i).get(0) == s && board.get(i).get(1) == s && board.get(i).get(2) == s) {
                return true;
            }

            if(board.get(0).get(i) == s && board.get(1).get(i) == s && board.get(2).get(i) == s) {
                return true;
            }
        }

        if(board.get(0).get(0) == s && board.get(1).get(1) == s && board.get(2).get(2) == s) {
            return true;
        }

        return board.get(2).get(0) == s && board.get(1).get(1) == s && board.get(0).get(2) == s;
    }
}