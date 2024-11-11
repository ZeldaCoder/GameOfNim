import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private Scanner scan;

    public Player() {
        scan = new Scanner(System.in);
        System.out.print("Enter username: ");

        String userName = scan.nextLine();  // Read user input
        System.out.println("Welcome " + userName + "!"); 
    }

    public void TakePieces(Pile pile) {
        // Maximum amount of pieces you can take in one turn
        int maxTakePieces = pile.getPileAmount() / 2;

        System.out.print("How many pieces do you want to take out of " + pile.getPileName() + ": ");
        String piecesInput = scan.nextLine(); // read input

        // convert input to int and take the amount of pieces away
        int pieces = Integer.parseInt(piecesInput);

        int newAmount = pile.getPileAmount() - pieces;
        pile.setPileAmount(newAmount);

        // update score to reflect how many pieces you took
        score += pieces;

    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}