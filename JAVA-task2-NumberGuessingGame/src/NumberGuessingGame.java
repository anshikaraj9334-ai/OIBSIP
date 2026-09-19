package src;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        String playAgain = "yes";
        int round = 0;
        int wonRounds = 0;

        while (playAgain.equalsIgnoreCase("yes")) {

            round++;

            System.out.println("\nChoose Difficulty:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            int maxNumber;
            int maxAttempts;

            if (choice == 1) {
                maxNumber = 50;
                maxAttempts = 10;
            } 
            else if (choice == 2) {
                maxNumber = 100;
                maxAttempts = 7;
            } 
            else {
                maxNumber = 200;
                maxAttempts = 5;
            }

            int number = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean won = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess the number between 1 and " + maxNumber);

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess > number) {
                    System.out.println("Too High!");
                } 
                else if (guess < number) {
                    System.out.println("Too Low!");
                } 
                else {
                    System.out.println("Correct!");
                    System.out.println("You guessed it in " + attempts + " attempts.");
                    won = true;
                    wonRounds++;
                    break;
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!won) {
                System.out.println("You Lost!");
                System.out.println("The correct number was: " + number);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = sc.next();
        }

        System.out.println("\n===== GAME SUMMARY =====");
        System.out.println("Total Rounds: " + round);
        System.out.println("Rounds Won: " + wonRounds);
        System.out.println("Rounds Lost: " + (round - wonRounds));

        System.out.println("Thanks for playing!");

        sc.close();
    }
}