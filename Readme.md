# Unbeatable Tic-Tac-Toe with AI (Java Swing)

This project implements two versions of the classic game Tic-Tac-Toe:

1.  **TicTacToeClassic:** A traditional two-player version where users take turns marking X's and O's.
2.  **TicTacToeAI:** A single-player version where the user plays against an AI opponent powered by the Minimax algorithm with alpha-beta pruning.

## Features

-   **Graphical User Interface (GUI):** Uses Java Swing to create an interactive and visually appealing game board.
-   **AI Opponent (TicTacToeAI):** Implements the Minimax algorithm with alpha-beta pruning for intelligent decision-making. The AI is designed to be unbeatable.
-   **Win/Loss/Draw Detection:** Automatically determines the outcome of the game and displays a message accordingly.
-   **Scorekeeping:** Keeps track of wins for both the player and the AI (in `TicTacToeClassic`).
-   **Clear Board Functionality:** Allows resetting the game to start a new round.

## Implementation Details

### TicTacToeClassic

-   **`JButton` Array:** Uses a 2D array of `JButton` components to represent the game board.
-   **`ActionListener`:** Each button has an `ActionListener` to handle player moves, update the board, and check for wins/draws.
-   **`checkWin` Method:** Iterates through rows, columns, and diagonals to check for winning combinations.
-   **`winLogic` Method:** Handles the logic for displaying the winner and updating the score.
-   **`clearBoard` Method:** Resets the board and clears the game state.

### TicTacToeAI and Minimax

-   **`Minimax` Class:** Implements the Minimax algorithm with alpha-beta pruning in a separate class.
-   **`evaluate` Method:** Recursively evaluates the game tree to determine the best move for the AI.
-   **`checkWin` and `checkDraw` Methods:** Helper functions to determine the game state.
-   **`AIMove` Method:** Calls the `Minimax` class to calculate the optimal move and updates the board.

## How to Play

1.  **Clone the Repository:**

```bash
git clone https://github.com/<your-username>/tic-tac-toe.git
```

2.  **Compile and Run:**

```bash
javac org/example/*.java
java org.example.TicTacToeClassic  // For two-player mode
java org.example.TicTacToeAI       // For AI mode
```

## Code Structure

-   **`TicTacToeClassic`:** Main class for the two-player game.
-   **`TicTacToeAI`:** Main class for the AI version.
-   **`Minimax`:** Companion class for `TicTacToeAI` that implements the Minimax algorithm.
-   **`BtnActionListener` (in `TicTacToeAI`):** ActionListener for button clicks.
-   **`showMessage` (in `TicTacToeAI`):** Runnable to display the game result.
-   **`ButtonActionListener` (in `TicTacToeClassic`):** ActionListener for button clicks.
-   **`showWinDialog` (in `TicTacToeClassic`):** Runnable to display the game result.

## Resources

-   Minimax Algorithm Explanation: [Algorithms Explained – minimax and alpha-beta pruning]([https://www.youtube.com/watch?v=l-hh51ncgDI]) (Sebastian Lague)

## Improvements and Future Work

-   **Improved UI:** Consider using more modern-looking UI elements and enhancing the overall visual appeal of the game.
-   **Difficulty Levels:** Implement different difficulty levels for the AI opponent by adjusting the depth of the Minimax search.
-   **User Interface:** Consider adding a menu for choosing game modes (two-player or AI) and potentially customizing game settings.

## Learnings
- I have learned how to implement, think outside the box, and search for resources online.
- Algorithms made me think of other ways to create a simple mechanism. It makes you think intuitively. For example, my logic for checking if a game state is in a draw.



Please note that this is a Markdown (`.md`) version of the README. You can copy and paste this into a file named `README.md` in your project directory. Remember to replace `<your-username>` with your actual GitHub username.
