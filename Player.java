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

    public void TakePieces(int pile) {
        int maxTakePieces = pile / 2;

    }
}