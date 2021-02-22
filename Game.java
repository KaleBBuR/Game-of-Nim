import java.util.Scanner;
import java.lang.Math;

public class Game {
    private Player player1;
    private Player player2;
    private boolean playAgain;

    public Game() {
        this.playAgain = true;
    }

    public void play() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Player 1, enter your name: ");
        String player1Name = myScanner.nextLine();
        System.out.println("Player 2, enter your name: ");
        String player2Name = myScanner.nextLine();
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        Player currPlayer;
        int currPlayerNum = 0;
        int randFirstPlayer = (int) (Math.random() * (2 - 1 + 1) + 1);
        if (randFirstPlayer == 1) { currPlayerNum = 1; } else { currPlayerNum = 2; }
        while (true) {
            if (currPlayerNum == 1) {
                currPlayer = this.player1;
            } else {
                currPlayer = this.player2;
            }
            System.out.printf(
                "There are %d pieces\n%s how many pieces do you want to remove? ",
                Board.getNumPieces(), currPlayer.getName()
            );
            int removePiecesAmount = myScanner.nextInt();
            if (removePiecesAmount > (int) (Board.getNumPieces() / 2)) {
                System.out.println("You can't remove more than half the pieces.");
                continue;
            }

            if (removePiecesAmount < 1) {
                System.out.println("You can't remove less than one piece.");
                continue;
            }

            Board.removePieces(removePiecesAmount);

            if (currPlayerNum == 1) {
                currPlayer = this.player2;
            } else {
                currPlayer = this.player1;
            }

            if (Board.getNumPieces() == 0) {
                currPlayer.incrScore();
                System.out.printf(
                    "Oops! Game over!\n%s has won the game and has %d score!\nWould you like to play again?",
                    currPlayer.getName(),
                    currPlayer.getScore()
                );
                while (true) {
                    String playAgainStr = myScanner.nextLine();
                    if (playAgainStr.equalsIgnoreCase("yes")) {
                        this.playAgain = true;
                        break;
                    } else if (playAgainStr.equalsIgnoreCase("no")) {
                        this.playAgain = false;
                        break;
                    } else {
                        System.out.println("Sorry, I didn't quite get that. Yes or no? ");
                    }
                }
            }

            if (!this.playAgain) {
                break;
            }
        }
    }
}
