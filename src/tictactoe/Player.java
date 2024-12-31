package tictactoe;

public class Player {
    private final String name;
    private final Symbol symbol;

    Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    String getName() {
        return this.name;
    }

    Symbol getSymbol() {
        return this.symbol;
    }
}