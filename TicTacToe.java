import java.util.Scanner; // Import the Scanner class for user input

public class TicTacToe {
    // Represents the Tic-Tac-Toe board
    // The board is 5x5 to accommodate the | and - separators
    static char[][] board = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
    };
    
    static char currentPlayer = 'X'; // Keeps track of the current player, starts with 'X'

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input
        boolean gameEnded = false; // Flag to control the game loop

        printBoard(); // Display the initial empty board

        // Main game loop
        while (!gameEnded) {
            // Prompt the current player to enter their move
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]):");
            int row = scanner.nextInt() - 1; // Read row input (adjust for 0-based array index)
            int col = scanner.nextInt() - 1; // Read column input (adjust for 0-based array index)

            // Check if the entered move is valid
            if (isValidMove(row, col)) {
                placeMove(row, col); // Place the player's move on the board
                printBoard(); // Display the updated board

                // Check for a win condition
                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!"); // Announce winner
                    gameEnded = true; // End the game
                } 
                // Check for a draw condition
                else if (isDraw()) {
                    System.out.println("It's a draw!"); // Announce draw
                    gameEnded = true; // End the game
                } 
                // If no win or draw, switch to the next player
                else {
                    switchPlayer();
                }
            } else {
                System.out.println("This move is invalid. Try again."); // Inform invalid move and prompt again
            }
        }

        scanner.close(); // Close the scanner to release resources
    }

    // Prints the current state of the Tic-Tac-Toe board
    static void printBoard() {
        for (char[] row : board) { // Iterate through each row of the board
            for (char ch : row) { // Iterate through each character in the row
                System.out.print(ch); // Print the character
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }

    // Checks if a chosen move (row, col) is valid
    static boolean isValidMove(int row, int col) {
        // Calculate the actual board array indices since the board includes separators
        int boardRow = row * 2;
        int boardCol = col * 2;

        // A move is valid if it's within bounds and the cell is empty (' ')
        return boardRow < 5 && boardCol < 5 && board[boardRow][boardCol] == ' ';
    }

    // Places the current player's symbol on the board at the given (row, col)
    static void placeMove(int row, int col) {
        // Calculate the actual board array indices
        int boardRow = row * 2;
        int boardCol = col * 2;
        board[boardRow][boardCol] = currentPlayer; // Place the current player's symbol
    }

    // Switches the current player from 'X' to 'O' or 'O' to 'X'
    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Ternary operator for concise switching
    }

    // Checks if the current player has won the game
    static boolean checkWin() {
        // Check all rows and columns for a win
        for (int i = 0; i < 3; i++) {
            // checkLine(r1, c1, r2, c2, r3, c3) checks if three specified cells form a win
            // Checks horizontal lines (rows)
            // Checks vertical lines (columns)
            if (checkLine(i, 0, i, 1, i, 2) || checkLine(0, i, 1, i, 2, i)) return true;
        }
        // Check both diagonals for a win
        return checkLine(0, 0, 1, 1, 2, 2) || checkLine(0, 2, 1, 1, 2, 0);
    }

    // Helper method to check if three specific cells form a winning line for the current player
    static boolean checkLine(int r1, int c1, int r2, int c2, int r3, int c3) {
        // Get the characters from the board at the specified (row, col) coordinates
        // Multiply by 2 to get the actual index on the display board
        char a = board[r1 * 2][c1 * 2];
        char b = board[r2 * 2][c2 * 2];
        char c = board[r3 * 2][c3 * 2];
        // A line is a win if all three cells contain the current player's symbol
        return a == currentPlayer && a == b && b == c;
    }

    // Checks if the game is a draw (all cells filled and no winner)
    static boolean isDraw() {
        // Iterate through all 3x3 logical cells of the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // If any cell is empty, the game is not a draw yet
                if (board[i * 2][j * 2] == ' ') return false;
            }
        }
        return true; // All cells are filled, and no win was detected, so it's a draw
    }
}