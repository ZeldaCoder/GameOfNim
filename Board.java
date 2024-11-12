import java.util.Random;
import java.util.ArrayList;

public class Board {
    // Variales for random generation
    private int maxPilesInPieces = 50;
    private int minPiecesInPieces = 10;

    // each int represents each pile
    private Pile pile_1;
    private Pile pile_2;
    private Pile pile_3;

    private ArrayList<Pile> listOfPiles = new ArrayList<Pile>();
 
    public Board() {
        // Create piles
        InitPiles();

        // Display amount of piles
        DisplayPiles();
    }

    public void InitPiles() {
        // init the piles
        Random rand = new Random();
        if (pile_1 == null) {
            pile_1 = new Pile(rand.nextInt(minPiecesInPieces, maxPilesInPieces + 1), "Pile 1");
        } else {
            pile_1.setPileAmount(rand.nextInt(minPiecesInPieces, maxPilesInPieces + 1));
        }

        if (pile_2 == null) {
            pile_2 = new Pile(rand.nextInt(minPiecesInPieces, maxPilesInPieces + 1), "Pile 2");
        } else {
            pile_2.setPileAmount(rand.nextInt(minPiecesInPieces, maxPilesInPieces + 1));
        }

        if (pile_3 == null) {
            pile_3 = new Pile(rand.nextInt(minPiecesInPieces, maxPilesInPieces + 1), "Pile 3");
        } else {
            pile_3.setPileAmount(rand.nextInt(minPiecesInPieces, maxPilesInPieces + 1));
        }

        // Add init the list
        listOfPiles.add(pile_1);
        listOfPiles.add(pile_2);
        listOfPiles.add(pile_3);
    }

    public void DisplayPiles() {
        System.out.println(pile_1.getPileName() + " Has " + pile_1.getPileAmount() + " Pieces");
        System.out.println(pile_2.getPileName() +  " Has " + pile_2.getPileAmount() + " Pieces");
        System.out.println(pile_3.getPileName() +  " Has " + pile_3.getPileAmount() + " Pieces");
    }

    public ArrayList<Pile> getPiles() {
        return listOfPiles;
    }
}