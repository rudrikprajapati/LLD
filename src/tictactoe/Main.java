package tictactoe;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Rudrik", Symbol.O);
        Player p2 = new Player("Dhruv", Symbol.X);
        Game g1 = new Game(p1, p2);

        String res = g1.startGame();

        System.out.println(res);
    }
}
