import java.util.Random;
public class Main {
    public static void main(String[] args) {


                final int START_POSITION = 0;
                final int WINNING_POSITION = 100;

                // Snakes and ladders configuration
                int[] snakeAndLadder = new int[101];



                int playerPosition = START_POSITION;
                int diceRolls = 0;
                Random random = new Random();

                System.out.println("Starting the Snake and Ladder game!");

                while (playerPosition < WINNING_POSITION) {
                    diceRolls++;
                    int dice = random.nextInt(6) + 1;
                    System.out.println("Rolled a " + dice);

                    int option = random.nextInt(3); // Random number between 0 and 2
                    switch (option) {
                        case 0: // No Play
                            System.out.println("No Play! Player stays at position " + playerPosition);
                            break;
                        case 1: // Ladder
                            int newPositionLadder = playerPosition + dice;
                            if (newPositionLadder > WINNING_POSITION) {
                                System.out.println("Move exceeds winning position. Player stays at position " + playerPosition);
                            } else {
                                System.out.println("Ladder! Moving ahead by " + dice + " steps to position " + newPositionLadder);
                                playerPosition = newPositionLadder;
                            }
                            break;
                        case 2: // Snake
                            int newPositionSnake = playerPosition - dice;
                            if (newPositionSnake < 0) {
                                newPositionSnake = 0; // Reset to start position
                            }
                            System.out.println("Snake! Moving back by " + dice + " steps to position " + newPositionSnake);
                            playerPosition = newPositionSnake;
                            break;
                    }




                    System.out.println("Player moved to position " + playerPosition);
                }

                System.out.println("Congratulations! Player reached position 100 in " + diceRolls + " dice rolls.");
            }
        }

