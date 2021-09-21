package piggame;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int turnScore = 0;
        int p1TotalScore = 0;
        int p2TotalScore = 0;
        String again = "";
        String wantsToPlay = "";
        String newGame = "";
        Dice die = new Dice();

        System.out.println("Welcome to the game of Pigs!");
        System.out.println("Do you want to start a new game? (y/n)");
        newGame = scan.next();
        if (newGame.charAt(0) == 'n') {
            System.out.println("Sad :( you didn't to play!");
        } else {
            Player player1 = new Player();
            Player player2 = new Player();
            while (p1TotalScore <= 100 && p2TotalScore <= 100) {
                System.out.println("Player 1, Do you wish to play? (y/n)");
                wantsToPlay = scan.next();
                if (wantsToPlay.charAt(0) == 'n') {

                    // Empty body - program should just exit

                } else {
                    while (true) {
                        die.roll();
                        int side = die.roll();
                        System.out.println("You rolled a: " + side);
                        if (side != 1) {
                            turnScore += side;
                        } else {
                            System.out.println("You rolled a one! Turn over.");
                            turnScore = 0;
                            break;
                        }

                        System.out.println("Turn score: " + turnScore);
                        System.out.println("Do you want to roll again? (y/n)");
                        again = scan.next();
                        if (again.charAt(0) == 'n') {
                            p1TotalScore += turnScore;
                            if (p1TotalScore >= 100) {
                                System.out.println(player1.getName() + " reached 100 points and WINS!");
                                break;
                            }
                            turnScore = 0;
                            System.out.println("You ended your turn, your total score so far is: " + p1TotalScore);
                            break;
                        }

                    }
                }
                System.out.println("Player 2, do you want to play? (y/n)");
                wantsToPlay = scan.next();
                if (wantsToPlay.charAt(0) == 'n') {

                    // Program exits - needs to go to player 1 again.

                } else {
                    while (true) {
                        die.roll();
                        int side = die.roll();
                        System.out.println("You rolled a: " + side);
                        if (side != 1) {
                            turnScore += side;
                        } else {
                            System.out.println("You rolled a one! Turn over.");
                            turnScore = 0;
                            break;
                        }

                        System.out.println("Turn score: " + turnScore);
                        System.out.println("Do you want to roll again? (y/n)");
                        again = scan.next();
                        if (again.charAt(0) == 'n') {
                            p2TotalScore += turnScore;
                            if (p2TotalScore >= 100) {
                                System.out.println(player2.getName() + " reached 100 and WINS!");
                                break;
                            }
                            turnScore = 0;
                            System.out.println("You ended your turn, your total score so far is: " + p2TotalScore);
                            break;
                        }
                    }
                }
            }
        }
    }
}
