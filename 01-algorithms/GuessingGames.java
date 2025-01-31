import java.util.Random;
import java.util.Scanner;

public class GuessingGames {

    public static void rockPaperScissors(){
        Random rand = new Random();
        int computerChoice = rand.nextInt(3) + 1;
        int check;
        Scanner scan = new Scanner(System.in);

        System.out.println("Rock (1), Paper (2) or Scissors (3)?");
        int playerChoice = scan.nextInt();
        check = (playerChoice - computerChoice + 3) % 3;
        scan.close();

        System.out.println("computer chose " + computerChoice);


        switch (check){
            case 0 -> System.out.println("It's a draw!");
            case 1 -> System.out.println("You win!");
            case 2 -> System.out.println("You lose!");
            default -> {
                System.out.println("this is a test!");
            }
        }
    }

    public static void guessTheNumber(){
        Random rand = new Random();
        int randNumber = rand.nextInt(100) + 1;
        int numberOfTries, guess;
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose your difficulty level between 1 (Easy) and 3 (Hard)");
        int selection = scan.nextInt();

        switch (selection){
            case 1 -> numberOfTries = 7;
            case 2 -> numberOfTries = 5;
            case 3 -> numberOfTries = 3;
            default -> {
                System.out.println("Select a level between 1 and 3");
                return;
            }
        }

        while (numberOfTries > 0){
            System.out.println("Guess a number");
            guess = scan.nextInt();
            if(guess == randNumber){
                System.out.println("Congrats, you win with " + numberOfTries + " try(ies) left!" );
                scan.close();
                return;
            } else if (guess > randNumber) {
                System.out.println("Your guess is too big, try again!");
                numberOfTries -= 1;
                System.out.println("Remaining guesses: " + numberOfTries);
            }else{
                System.out.println("Your guess is too small, try again!");
                numberOfTries -= 1;
                System.out.println("Remaining guesses: " + numberOfTries);
            }
        }
        scan.close();
        System.out.println("You lost!");
        System.out.println("The answer was " + randNumber);

    }

}
