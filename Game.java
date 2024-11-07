public class Game {
    private Player p1;
    private Player p2;

    private Board gameBoard;

    private int turnNum;


    public Game() {
        p1 = new Player();
        p2 = new Player();

        gameBoard = new Board();
    }

    public void NextTurn() {
        if (turnNum % 2 == 0) {
            p1.TakePieces(gameBoard.pile_1);
        } else {
            p2.TakePieces(gameBoard.pile_1);
        }
    } 
} 