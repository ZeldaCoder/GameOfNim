
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
        p1 = new Player();
        p2 = new Player();

        gameBoard = new Board();
    }

    public void NextTurn() {
        // Get the next pile
        int pileNum = turnNum % 3;
        ArrayList<Pile> piles = gameBoard.getPiles();

        // Determine whos turn it is
        if (turnNum % 2 == 0) {
            p1.TakePieces(piles.get(pileNum));

            int count = 0;

            for (Pile pile : piles) {
                if (pile.getPileAmount() == 0) {
                    count++;
                }
            }

            if (count == piles.size()) {
                System.out.println(p1.getName() + " has died with " + p1.getScore() + " points! " + p2.getName() + " is the winner!");
                gameOver = true;
            } else {
                System.out.println(p1.getName() + " has a score of " + p1.getScore() + ". It is now " + p2.getName() + "'s turn");
            }
        } else {
            p2.TakePieces(piles.get(pileNum));

            int count = 0;

            for (Pile pile : piles) {
                if (pile.getPileAmount() == 0) {
                    count++;
                }
            }

            if (count == piles.size()) {
                System.out.println(p2.getName() + " has died with " + p2.getScore() + " points! " + p1.getName() + " is the winner!");
                gameOver = true;
            } else {
                System.out.println(p2.getName() + " has a score of " + p2.getScore() + ". It is now " + p1.getName() + "'s turn");
            }
        }

        // Increase number of turns
        turnNum++;
    }

    public void play() {
        // Gameplay Loop
        while(gameOver == false) {
            NextTurn();
        }

        if (gameOver == true) {
            System.out.print("Do you want to play again (y/n)? ");
            String playAgain = scan.nextLine();

            if (playAgain.equals("y") || playAgain.equals("Y")) {
                gameOver = false;
                play();
            }

        }
    }
} 