import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
    };
    
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                placeMove(row, col);
                printBoard();

                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isDraw()) {
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("This move is invalid. Try again.");
            }
        }

        scanner.close();
    }

    static void printBoard() {
        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    static boolean isValidMove(int row, int col) {
        int boardRow = row * 2;
        int boardCol = col * 2;

        return boardRow < 5 && boardCol < 5 && board[boardRow][boardCol] == ' ';
    }

    static void placeMove(int row, int col) {
        int boardRow = row * 2;
        int boardCol = col * 2;
        board[boardRow][boardCol] = currentPlayer;
    }

    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    static boolean checkWin() {
        // Rows and columns
        for (int i = 0; i < 3; i++) {
            if (checkLine(i, 0, i, 1, i, 2) || checkLine(0, i, 1, i, 2, i)) return true;
        }
        // Diagonals
        return checkLine(0, 0, 1, 1, 2, 2) || checkLine(0, 2, 1, 1, 2, 0);
    }

    static boolean checkLine(int r1, int c1, int r2, int c2, int r3, int c3) {
        char a = board[r1 * 2][c1 * 2];
        char b = board[r2 * 2][c2 * 2];
        char c = board[r3 * 2][c3 * 2];
        return a == currentPlayer && a == b && b == c;
    }

    static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i * 2][j * 2] == ' ') return false;
            }
        }
        return true;
    }
}
