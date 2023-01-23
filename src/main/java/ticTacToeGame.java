import java.util.Random;
import java.util.Scanner;

public class ticTacToeGame {

    static int playerScore = 0;
    static int computerScore = 0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        char[][] gameBoard = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};
        printBoard(gameBoard);
        boolean gameOver = false;
        boolean playAgain = true;

        while (playAgain){
            while (!gameOver) {
                playerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }

                computerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }
            }
            System.out.println("Player Score: " +playerScore);
            System.out.println("Computer Score: " +computerScore);
            System.out.println("Would you like to play again? Y/N");
            input.nextLine();
            String result = input.nextLine();

            switch (result){
                case "Y":
                case "y":
                    System.out.println("Dope! Let's play again");
                    resetBoard(gameBoard);
                    //we need to reset the game board!
                    gameOver = false;
                    printBoard(gameBoard);
                    break;

                case "N":
                case "n":
                    playAgain = false;
                    System.out.println("Thanks for playing!");
                    break;
                default:
                    break;
            }

        }
    }

    public static void printBoard(char[][] gameBoard) {

        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void updateBoard(int position, int player, char[][] gameBoard) {

        char character;

        if (player == 1) {
            character = 'X';
        } else {
            character = 'O';
        }

        switch (position) {

            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                printBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;
            default:
                break;
        }
    }

    public static void playerMove(char[][] gameBoard) {

        System.out.println("Please make a move. (1-9)");


        int move = input.nextInt();

        boolean result = isValidMove(move, gameBoard);

        while (!result) {
            System.out.println("Sorry! Is a invalid move. Try again");
            move = input.nextInt();
            result = isValidMove(move, gameBoard);
        }

        System.out.println("Player moved at position" + move);
        updateBoard(move, 1, gameBoard);

    }

    public static boolean isValidMove(int move, char[][] gameboard) {

        switch (move) {
            case 1:
                return gameboard[0][0] == '_';
            case 2:
                return gameboard[0][2] == '_';
            case 3:
                return gameboard[0][4] == '_';
            case 4:
                return gameboard[1][0] == '_';
            case 5:
                return gameboard[1][2] == '_';
            case 6:
                return gameboard[1][4] == '_';
            case 7:
                return gameboard[2][0] == ' ';
            case 8:
                return gameboard[2][2] == ' ';
            case 9:
                return gameboard[2][4] == ' ';
            default:
                return false;
        }
    }

    public static void computerMove(char[][] gameBoard) {

        Random rand = new Random();
        int move = rand.nextInt(9) + 1;

        boolean result = isValidMove(move, gameBoard);

        while (!result) {
            move = rand.nextInt(9) + 1;
            result = isValidMove(move, gameBoard);
        }

        System.out.println("Computer moved at position " + move);
        updateBoard(move, 2, gameBoard);
    }

    public static boolean isGameOver(char[][] gameBoard) {

        //horizontal player win
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[1][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[1][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }

        //Vertical Wins
        if (gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameBoard[0][4] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[0][4] == 'O' && gameBoard[1][4] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }

        //diagonal wins
        if (gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[0][4] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameBoard[2][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[2][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }

        if(gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' && gameBoard[1][0] !='_' &&
            gameBoard[1][2] != '_' && gameBoard[1][4] != '_' && gameBoard[2][0] != '_' && gameBoard[2][2] != '_'
            && gameBoard[2][4] != '_'){
            System.out.println("Its a tie");
            return true;
        }
    return false; }

    public  static void resetBoard(char[][] gameBoard) {
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';


    }
}




