package bowlingScorer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BowlingGame {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        // Game Setup
        System.out.println("Enter number of players:");
        int numPlayers = scnr.nextInt();
        scnr.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + " name:");
            String playerName = scnr.nextLine();
            players.add(new Player(playerName));
        }

        // Gametime
        for (int frameIndex = 0; frameIndex < 10; frameIndex++) {
            for (Player player : players) {
                Frame frame = player.getFrames().get(frameIndex);
                System.out.println(player.getName() + " - Frame " + (frameIndex + 1));
                
                int throw1 = 0;
                int throw2 = 0; 
                int throw3 = 0;

                while (true) {
                    try {
                        System.out.println("Enter first throw:");
                        throw1 = scnr.nextInt();
                        if (throw1 < 0 || throw1 > 10) {
                            throw new IllegalArgumentException("Please enter 10 pins or less");
                        }
                        break;
                    } catch (IllegalArgumentException | InputMismatchException e) {
                        System.out.println("Invalid input: " + e.getMessage());
                        scnr.nextLine();
                    }
                }
                if (throw1 < 10 || frameIndex == 9) {
                    while (true) {
                        try {
                            System.out.println("Enter second throw:");
                            throw2 = scnr.nextInt();
                            if (throw2 < 0 || throw2 > 10 || (throw1 + throw2 > 10 && frameIndex < 9)) {
                                throw new IllegalArgumentException("You're frame score can't be more than 10.");
                            }
                            break;
                        } catch (IllegalArgumentException | InputMismatchException e) {
                            System.out.println("Invalid input: " + e.getMessage());
                            scnr.nextLine();
                        }
                    }
                }

                frame.setThrows(throw1, throw2);

                // 10th Frame Special Handling
                if (frameIndex == 9 && (frame.isStrike() || frame.isSpare())) {
                    while (true) {
                        try {
                            System.out.println("Enter third throw:");
                            throw3 = scnr.nextInt();
                            if (throw3 < 0 || throw3 > 10) {
                                throw new IllegalArgumentException("The number of pins must be between 0 and 10.");
                            }
                            break;
                        } catch (IllegalArgumentException | InputMismatchException e) {
                            System.out.println("Invalid input: " + e.getMessage());
                            scnr.nextLine();
                        }
                    }
                    frame.setThirdThrow(throw3);
                }
            }

            for (Player player : players) {
                int totalScore = player.calculateTotalScore();
                System.out.println(player.getName() + "'s total score after frame " + (frameIndex + 1) + ": " + totalScore);
            }
        }

        // End of game
        System.out.println("\nFinal Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.calculateTotalScore());
        }

        scnr.close();
    }
}
