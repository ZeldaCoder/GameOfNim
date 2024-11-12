
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Scanner scan;

    private Player p1;
    private Player p2;

    private Board gameBoard;

    private int turnNum;
    private Boolean gameOver;

    public Game() {
        scan = new Scanner(System.in);
        p1 = new Player(scan);
        p2 = new Player(scan);

        gameOver = false;

        gameBoard = new Board();
    }

    public void NextTurn() {
        if (gameOver == false) {
            // Get the next pile
            int pileNum = turnNum % 3;
            ArrayList<Pile> piles = gameBoard.getPiles();

            System.out.print(piles.get(pileNum).getPileName() + " Pile: ");

            // Determine whos turn it is
            if (turnNum % 2 == 0) {
                System.out.println("Before");
                p1.TakePieces(piles.get(pileNum));
                System.out.println("After");
                
                int count = 0;

                for (Pile pile : piles) {
                    if (pile.getPileAmount() == 0) {
                        count++;
                    }
                }

                if (count == piles.size()) {
                    System.out.println(p1.getName() + " has died with " + p1.getScore() + " points! " + p2.getName()
                            + " is the winner!");
                    gameOver = true;
                } else {
                    System.out.println(
                            p1.getName() + " has a score of " + p1.getScore() + ". It is now " + p2.getName() + "'s turn");
                }
            } else {
                System.out.println("Before");
                p2.TakePieces(piles.get(pileNum));
                System.out.println("After");

                int count = 0;

                for (Pile pile : piles) {
                    if (pile.getPileAmount() == 0) {
                        count++;
                    }
                }

                if (count == piles.size()) {
                    System.out.println(p2.getName() + " has died with " + p2.getScore() + " points! " + p1.getName()
                            + " is the winner!");
                    gameOver = true;
                } else {
                    System.out.println(
                            p2.getName() + " has a score of " + p2.getScore() + ". It is now " + p1.getName() + "'s turn");
                }
            }

            // Increase number of turns
            turnNum++;

            System.out.println("Turn Number: " + turnNum);

            gameBoard.DisplayPiles();
        }
    }

    public void Reset() {
        p1.setScore(0);
        p2.setScore(0);
        gameBoard.InitPiles();
        turnNum = 0;
    }

    public void play() {
        // Gameplay Loop
        while (true) {
            // Start a new game if gameOver is true (user wants to play again)
            if (gameOver == true) {
                System.out.print("Do you want to play again (y/n)? ");

                String playAgain = scan.nextLine();


                if (playAgain.equals("y") || playAgain.equals("Y")) {
                    gameOver = false; // Reset gameOver
                    Reset();
                } else {
                    System.out.println("Thanks for playing!");
                    scan.close();
                    break; // Exit the game loop
                }
            }
            // Play the next turn if the game is not over
            if (gameOver == false) {
                NextTurn();
            }
        }
    }
}