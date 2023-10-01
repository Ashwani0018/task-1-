import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalRounds = 3;
        int totalScore = 0;
        
        System.out.println("Welcome to Guess the Number!");
        System.out.println("You have " + totalRounds + " rounds to play.");
        
        for (int round = 1; round <= totalRounds; round++) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.println("\nRound " + round + " - Guess a number between " + minRange + " and " + maxRange + ".");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number within the specified range.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Higher! Try again.");
                    attempts++;
                } else if (userGuess > targetNumber) {
                    System.out.println("Lower! Try again.");
                    attempts++;
                } else {
                    int roundScore = maxAttempts - attempts;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("Round Score: " + roundScore);
                    break;
                }
                
                if (attempts == maxAttempts) {
                    System.out.println("Out of attempts. The correct number was " + targetNumber + ".");
                }
            }
        }
        
        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + totalScore);
        
        
    }
}
