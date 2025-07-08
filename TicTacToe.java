import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static char current = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initBoard();

        while (true) {
            printBoard();
            System.out.print("Player " + current + " turn (row[1-3] col[1-3]): ");
            int r = sc.nextInt() - 1, c = sc.nextInt() - 1;

            if (r < 0 || r > 2 || c < 0 || c > 2 || board[r][c] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[r][c] = current;
            if (checkWin()) {
                printBoard();
                System.out.println("Player " + current + " wins!");
                break;
            }
            if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            current = (current == 'X') ? 'O' : 'X';
        }
    }

    static void initBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    static void printBoard() {
        System.out.println("---------");
        for (char[] row : board) {
            for (char c : row) System.out.print("|" + c);
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static boolean checkWin() {
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == current && board[i][1] == current && board[i][2] == current) ||
                (board[0][i] == current && board[1][i] == current && board[2][i] == current))
                return true;
        return (board[0][0] == current && board[1][1] == current && board[2][2] == current) ||
               (board[0][2] == current && board[1][1] == current && board[2][0] == current);
    }

    static boolean isDraw() {
        for (char[] row : board)
            for (char c : row)
                if (c == ' ') return false;
        return true;
    }
}
