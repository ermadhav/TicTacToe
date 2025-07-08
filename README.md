# Tic Tac Toe (Java Console Game)

This is a simple 2-player Tic Tac Toe game written in Java, designed to run in the console. It allows two users to take turns playing against each other.

-----

## 📁 Project Structure

```
TicTacToe/
│
├── TicTacToe.java # Main game source code
└── README.md      # This file
```

-----

## 🛠️ How to Compile and Run

### ✅ Requirements:

  * Java Development Kit (JDK) installed
  * Terminal or command prompt access

### ▶️ Run the Game:

1.  Open your terminal and navigate to the project directory:
    ```bash
    cd "path/to/TicTacToe"
    ```
2.  Compile the Java code:
    ```bash
    javac TicTacToe.java
    ```
3.  Run the compiled game:
    ```bash
    java TicTacToe
    ```

-----

## 🎮 How to Play

The game is for two players: **Player X** and **Player O**.

On each turn, you'll be prompted to enter the **row** and **column** number (both from 1 to 3) where you want to place your mark.

**Example input:**

```
Player X, enter your move (row [1-3] and column [1-3]):
1 1
```

The game concludes when:

  * A player successfully gets three of their marks in a row, column, or diagonal (a win).
  * All cells are filled, and no player has won (a draw).

-----

## 📷 Sample Output

```
  |   |  
--+---+--
  |   |  
--+---+--
  |   |  
Player X, enter your move (row [1-3] and column [1-3]):
```

*(The output will continue to show the board after each move, similar to the above, until the game ends.)*

-----

## 🧠 Concepts Used

  * Java Arrays (for the game board)
  * Conditionals & Loops (for game logic, turn management, and win checking)
  * Methods (for organizing game functionalities)
  * Console Input using `Scanner`
  * 2D Game Logic

-----

## 💡 Future Improvements

  * Add a Graphical User Interface (GUI) using Swing or JavaFX.
  * Implement an AI opponent for a single-player mode.
  * Include a scoreboard and an option to restart the game.

-----

## 📄 License

This project is intended for educational purposes. You are welcome to modify and use it as you see fit.

-----

Let me know if you'd like to explore turning this into a GUI version or adding AI logic\!
