package stategame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GameCharacter ch = new GameCharacter("Marcus");

        while (!(ch.getState() instanceof MasterState)) {
            ch.showStatus();

            System.out.print("Choose action (train/meditate/fight/quit): ");
            String action = sc.nextLine().trim().toLowerCase();

            if (action.equals("quit")) {
                System.out.println("Bye!");
                break;
            }

            if (action.equals("train")) ch.train();
            else if (action.equals("meditate")) ch.meditate();
            else if (action.equals("fight")) ch.fight();
            else System.out.println("Invalid action.");

            if (ch.getHp() == 0 && !(ch.getState() instanceof MasterState)) {
                System.out.println("HP is 0. You should meditate or stop.");
            }
        }

        if (ch.getState() instanceof MasterState) {
            System.out.println("\n*** Congratulations! You reached MASTER. Game ends. ***");
        }

        sc.close();
    }
}
