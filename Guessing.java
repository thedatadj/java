import java.util.Scanner;
public class Guessing {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // Choose number to be guessed
        int target = (int) (Math.random()*100) + 1;

        // Ask user for first input
        System.out.print("Guess a number between 0 and 100: ");
        int guess = scan.nextInt(); // Get input
        
        // Hints logic
        while (guess != target) {
            
            if (guess < target) {
                System.out.println("Your number is too low!");
            } 
            else if (guess > target) {
                System.out.println("Your number is too high!");
            }

            // Get new input
            System.out.print("Guess a number between 0 and 100: ");
            guess = scan.nextInt();
        }

        // If the user guesses the correct number.
        System.out.println("You got it! Congratulations!");

        scan.close();
    }
}
