package tictactoe;

import java.util.Scanner;

class Game {
    Player currentPlayer;
    Player p1;
    Player p2;
    Board b;
    Game(Player p1, Player p2) {
        this.b = new Board();
        this.currentPlayer = p1;
        this.p1 = p1;
        this.p2 = p2;
    }

    void toggleCurrentPlayer() {
        currentPlayer = currentPlayer == p1 ? p2 : p1;
    }

    private int getValidInput(String message) {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input! Please enter a number between 0 and 2.");
        }
    }

    String startGame() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("tictactoe.Player 1: " + p1.getName() + " (" + p1.getSymbol() + ")");
        System.out.println("tictactoe.Player 2: " + p2.getName() + " (" + p2.getSymbol() + ")");
        System.out.println("Let's begin!\n");
        for(int i = 0; i < 9; i++) {
            b.printBoard();
            int row;
            int column;
            System.out.println("It's " + currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ").");
            while(true) {
                row = getValidInput("Enter row (0-2): ");
                column = getValidInput("Enter column (0-2): ");

                if (b.canMove(row, column)) {
                    break;
                } else {
                    System.out.println("That position is already taken. Try a different spot.");
                }
            }

            b.board.get(row).set(column, currentPlayer.getSymbol());

            if(b.isWin(currentPlayer.getSymbol())) {
                b.printBoard();
                return("Congratulations " + currentPlayer.getName() + "! You have won the game!");
            }
            toggleCurrentPlayer();
        }

        b.printBoard();
        return "The game is a draw! Well played both players.";
    }
}