import java.util.Random;
public class Main {
    public static void main(String[] args) {
                final int START_POSITION = 0;
                final int WINNING_POSITION = 100;
        int player1Position = START_POSITION;
        int player2Position = START_POSITION;
        int player1DiceRolls = 0;
        int player2DiceRolls = 0;

        boolean isPlayer1Turn = true;
                Random random = new Random();
                System.out.println("Starting the Snake and Ladder game!");
        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
                    int dice = random.nextInt(6) + 1;
            String currentPlayer = isPlayer1Turn ? "Player 1" : "Player 2";
            System.out.println("\n" + currentPlayer + " rolled a " + dice);
            if (isPlayer1Turn) {
                player1DiceRolls++;
            } else {
                player2DiceRolls++;
            }
                    int option = random.nextInt(3); // Random number between 0 and 2
                    switch (option) {
                        case 0: // No Play
                            System.out.println("No Play! " + currentPlayer + " stays at the same position.");
                            break;
                        case 1: // Ladder
                            if (isPlayer1Turn) {
                                int newPosition = player1Position + dice;
                                if (newPosition <= WINNING_POSITION) {
                                    player1Position = newPosition;
                                    System.out.println("Ladder! " + currentPlayer + " moves ahead to position " + player1Position);
                                } else {
                                    System.out.println("Move exceeds winning position. " + currentPlayer + " stays at position " + player1Position);
                                }
                                System.out.println(currentPlayer + " gets another turn!");
                                continue; // Player gets another turn
                            } else {
                                int newPosition = player2Position + dice;
                                if (newPosition <= WINNING_POSITION) {
                                    player2Position = newPosition;
                                    System.out.println("Ladder! " + currentPlayer + " moves ahead to position " + player2Position);
                                } else {
                                    System.out.println("Move exceeds winning position. " + currentPlayer + " stays at position " + player2Position);
                                }
                                System.out.println(currentPlayer + " gets another turn!");
                                continue; // Player gets another turn
                            }

                        case 2: // Snake
                            if (isPlayer1Turn) {
                                int newPosition = player1Position - dice;
                                player1Position = Math.max(newPosition, START_POSITION); // Ensure position does not go below 0
                                System.out.println("Snake! " + currentPlayer + " moves back to position " + player1Position);
                            } else {
                                int newPosition = player2Position - dice;
                                player2Position = Math.max(newPosition, START_POSITION); // Ensure position does not go below 0
                                System.out.println("Snake! " + currentPlayer + " moves back to position " + player2Position);
                            }
                            break;
                    }
            System.out.println(currentPlayer + " is now at position " + (isPlayer1Turn ? player1Position : player2Position));
            isPlayer1Turn = !isPlayer1Turn;
                    }
        if (player1Position == WINNING_POSITION) {
            System.out.println("\nCongratulations! Player 1 won the game.");
            System.out.println("Player 1 reached position 100 in " + player1DiceRolls + " rolls.");
            System.out.println("Player 2 was at position " + player2Position + " after " + player2DiceRolls + " rolls.");
        } else {
            System.out.println("\nCongratulations! Player 2 won the game.");
            System.out.println("Player 2 reached position 100 in " + player2DiceRolls + " rolls.");
            System.out.println("Player 1 was at position " + player1Position + " after " + player1DiceRolls + " rolls.");
        }
                }
            }


