import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private Scanner scan;

    public Player(Scanner singleScan) {
        scan = singleScan;
        System.out.print("Enter name: ");

        String userName = scan.nextLine(); // Read user input
        System.out.println("Welcome " + userName + "!");
        name = userName;

    }

    public void TakePieces(Pile pile) {
        if (pile.getPileAmount() > 0) {
            // Maximum amount of pieces you can take in one turn
            int maxTakePieces = pile.getPileAmount() / 2;

            System.out.print("How many pieces does " + name + " want to take out of " + pile.getPileName() + ": ");
            String piecesInput = scan.nextLine(); // read input

            System.out.println(piecesInput);
            // convert input to int and take the amount of pieces away
            if (piecesInput.matches("[0-9]+")) {
                int pieces = Integer.parseInt(piecesInput);

                if (pieces > maxTakePieces && pile.getPileAmount() != 1) {
                    System.out.println("You can't take more than " + maxTakePieces + " pieces!");
                } else {
                    int newAmount = pile.getPileAmount() - pieces;
                    pile.setPileAmount(newAmount);

                    // update score to reflect how many pieces you took
                    score += pieces;
                }
            } else {
                System.out.println("Please enter a number!");
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int newScore) {
        score = newScore;
    }
}