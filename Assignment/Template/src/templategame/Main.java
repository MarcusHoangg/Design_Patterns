package templategame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players (2-4 recommended): ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Need at least 2 players. Using 2 players.");
            n = 2;
        }

        Game game = new DiceRaceGame();
        game.play(n);

        sc.close();
    }
}