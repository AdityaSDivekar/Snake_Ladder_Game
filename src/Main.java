import java.util.Random;
public class Main {
    public static void main(String[] args) {


                final int START_POSITION = 0;
                final int WINNING_POSITION = 100;

                // Snakes and ladders configuration
                int[] snakeAndLadder = new int[101];

                snakeAndLadder[4] = 14;
                snakeAndLadder[9] = 31;
                snakeAndLadder[20] = 38;

                snakeAndLadder[17] = 7;
                snakeAndLadder[54] = 34;
                snakeAndLadder[62] = 19;
                snakeAndLadder[87] = 36;

                int playerPosition = START_POSITION;
                int diceRolls = 0;
                Random random = new Random();

                System.out.println("Starting the Snake and Ladder game!");

                while (playerPosition < WINNING_POSITION) {
                    diceRolls++;
                    int dieRoll = random.nextInt(6) + 1;
                    System.out.println("Rolled a " + dieRoll);

                    int newPosition = playerPosition + dieRoll;

                    if (newPosition > WINNING_POSITION) {
                        System.out.println("Move exceeds winning position. Player stays at position " + playerPosition);
                        continue;
                    }

                    if (snakeAndLadder[newPosition] != 0) {
                        if (newPosition < snakeAndLadder[newPosition]) {
                            System.out.println("Ladder! Climbing up from " + newPosition + " to " + snakeAndLadder[newPosition]);
                        } else {
                            System.out.println("Snake! Sliding down from " + newPosition + " to " + snakeAndLadder[newPosition]);
                        }
                        newPosition = snakeAndLadder[newPosition];
                    }

                    playerPosition = newPosition;
                    System.out.println("Player moved to position " + playerPosition);
                }

                System.out.println("Congratulations! Player reached position 100 in " + diceRolls + " dice rolls.");
            }
        }

