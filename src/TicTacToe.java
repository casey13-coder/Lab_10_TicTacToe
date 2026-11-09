import java.util.Arrays;
import java.util.Scanner;

/*
 * Tic Tac Toe Pseudocode

 * Start

 * Declare Scanner
 * Declare player as String
 * Declare row, col as int
 * Declare moveCount as int
 * Declare playAgain as boolean

 * playAgain = true

 * WHILE playAgain is true
 * {
 *  clearBoard()

 *  player = "X"
 *  moveCount = 0

 *  WHILE game is not over
 *  {
 *      display()

 *      OUTPUT "Player " + player + " enter row (1-3): "
 *      INPUT row
 *
 *      OUTPUT "Player " + player + " enter column (1-3): "
 *      INPUT col

 *      row = row - 1
 *      col = col - 1
 *
 *      WHILE isValidMove(row, col) is false
 *      {
 *          OUTPUT "Invalid move. Try again."
 *
 *          INPUT row
 *          INPUT col
 *
 *          row = row - 1
 *          col = col - 1
 *      }
 *
 *      board[row][col] = player
 *
 *      moveCount = moveCount + 1
 *
 *      IF moveCount >= 5
 *      {
 *          IF isWin(player)
 *          {
 *              display()
 *              OUTPUT "Player " + player + " wins!"
 *              BREAK
 *          }
 *
 *          IF isTie()
 *          {
 *              display()
 *              OUTPUT "It's a tie!"
 *              BREAK
 *          }
 *      }
 *
 *      IF player equals "X"
 *          player = "O"
 *      ELSE
 *          player = "X"
 *  }
 *
 *  playAgain = getYNConfirm("Play again?")
 * }
 *
 * OUTPUT "Thanks for playing!"

 * Stop
 */
public class TicTacToe {

    private static final int ROWS = 3;

    private static final int COLS = 3;

    private static String board [][] = new String[ROWS][COLS];
    static void main() {
        boolean gameFinished = false;
        boolean playAgain;
        Scanner scanner = new Scanner(System.in);
        String player = "X";
        int rowMove;
        int colMove;
        clearBoard();
        do {
            while (true) {
                rowMove = SafeInput.getRangedInt(scanner, "Player " + player + ": Input row", 1, 3);
                colMove = SafeInput.getRangedInt(scanner, "Player " + player + ": Input column", 1, 3);

                if (isValidMove(rowMove, colMove)) {
                    board[rowMove - 1][colMove - 1] = player;
                    break;
                } else {
                    System.out.println("\nInvalid Move");
                }
            }

            display();
            if(isWin(player)) {
                System.out.printf("\nPlayer %s Won!", player);
                scanner.nextLine();
                playAgain = SafeInput.getYNConfirm(scanner, "\nPlay again");
                if(playAgain) {
                    clearBoard();
                    player = "O";
                }
                else {
                    gameFinished = true;
                    System.out.println("Thanks For Playing!");
                }
            } else if (isTie()) {
                System.out.print("\nIts a tie!");
                scanner.nextLine();
                playAgain = SafeInput.getYNConfirm(scanner, "\nPlay again");
                if(playAgain) {
                    clearBoard();
                    player = "O";
                }
                else {
                    gameFinished = true;
                    System.out.println("Thanks For Playing!");
                }
            }
            if (player.equalsIgnoreCase("X")) {
                player = "O";
            } else {
                player = "X";
            }

        } while (!gameFinished);

    }
    private static void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = " ";
            }
        }
    }
    private static void display() {
        for (String[] row : board) {
            System.out.print("|");
            for (String cell : row) {
                System.out.printf(" %s |", cell);
            }
            System.out.println();
        }
    }
    private static boolean isValidMove(int row, int col) {
        return board[row-1][col-1].equalsIgnoreCase(" ");
    }
    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }
    private static boolean isColWin(String player) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player) {
        for (int i = 0; i < board.length; i++) {
            if (Arrays.equals(board[i], new String[]{player, player, player})) {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player) {
        return Arrays.equals(new String[]{board[0][0], board[1][1], board[2][2]}, new String[]{player, player, player}) || Arrays.equals(new String[]{board[0][2], board[1][1], board[2][0]}, new String[]{player, player, player});
    }
    private static boolean isTie() {
        for (String[] strings : board) {
            for (int j = 0; j < board.length; j++) {
                if (strings[j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
