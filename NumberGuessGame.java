import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int score = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        String playAgain;

        do {
            int target = rand.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrect = false;

            System.out.println("\nI'm thinking of a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " chances to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == target) {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempt(s).");
                    guessedCorrect = true;
                    score += (maxAttempts - attempts + 1); // higher score for fewer attempts
                    break;
                } else if (guess < target) {
                    System.out.println("Too low! 🔽");
                } else {
                    System.out.println("Too high! 🔼");
                }
            }

            if (!guessedCorrect) {
                System.out.println("❌ You've used all your attempts. The number was: " + target);
            }

            rounds++;
            System.out.print("\nDo you want to play another round? (yes/no): ");
            sc.nextLine(); // clear buffer
            playAgain = sc.nextLine();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n📊 Game Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Your Total Score: " + score);

        sc.close();
    }
}

