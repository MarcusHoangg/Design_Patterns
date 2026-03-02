package templategame;

import java.util.Random;

public class DiceRaceGame extends Game {

    private int[] scores;
    private int numberOfPlayers;
    private int winnerIndex = -1;

    private final int TARGET = 20;
    private final Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.scores = new int[numberOfPlayers];

        System.out.println("=== Dice Race Game ===");
        System.out.println("Players: " + numberOfPlayers);
        System.out.println("Target score: " + TARGET);
        System.out.println("Each turn: roll 1-6 and add to your score.\n");
    }

    @Override
    public boolean endOfGame() {
        return winnerIndex != -1;
    }

    @Override
    public void playSingleTurn(int player) {
        int roll = 1 + random.nextInt(6);
        scores[player] += roll;

        System.out.println("Player " + (player + 1) + " rolled " + roll
                + " -> score = " + scores[player]);

        if (scores[player] >= TARGET) {
            winnerIndex = player;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("\n=== Game Over ===");
        System.out.println("Winner: Player " + (winnerIndex + 1));
        System.out.println("Final scores:");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player " + (i + 1) + ": " + scores[i]);
        }
    }
}