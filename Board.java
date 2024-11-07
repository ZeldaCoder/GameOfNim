import java.util.Random;

public class Board {
    private int maxPilesInPieces = 50;
    private int minPiecesInPieces = 10;

    public int pile_1;
    public int pile_2;
    public int pile_3;

    public Board() {
        // Create piles
        InitPiles();

        // Display amount of piles
        DisplayPiles();
    }

    public void InitPiles() {
        Random rand = new Random();
        pile_1 = rand.nextInt(minPiecesInPieces, maxPilesInPieces + 1);
        pile_2 = rand.nextInt(minPiecesInPieces, maxPilesInPieces + 1);
        pile_3 = rand.nextInt(minPiecesInPieces, maxPilesInPieces + 1);
    }

    public void DisplayPiles() {
        System.out.println("Pile 1 Has " + pile_1 + " Pieces");
        System.out.println("Pile 2 Has " + pile_2 + " Pieces");
        System.out.println("Pile 3 Has " + pile_3 + " Pieces");
    }
}