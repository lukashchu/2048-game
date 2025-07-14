# 2048 Game (Java Implementation)  
**Author**: Andrew Lukashchuk  

## 📋 Overview  
This is a custom implementation of the classic **2048** game written in Java using the `PennDraw` library for graphics. The game supports multiple modes, including:  
- **Standard play**  
- **Hint mode**, which shows the best move  
- **AI mode**, where the computer plays for you  

The game features color-coded tiles, accurate animations, and a user-friendly interface. After a game ends, users can press the spacebar to restart.

---

## 🚀 How to Run  
1. Compile the code:  
   `javac *.java`  

2. Run the game in your desired mode:  
   - Regular game mode:  
     `java Game`  
   - AI plays the game:  
     `java Game ai`  
   - Hint button enabled:  
     `java Game hint`  

> Note: Make sure `PennDraw.java` is included and compiled in the same directory if it’s not already part of the standard classpath.

---

## 🎮 Controls  
- Use `W`, `A`, `S`, `D` keys to move the tiles up, left, down, and right.  
- In **hint mode**, click the center button to display the AI-recommended move.  
- After the game ends (win or loss), press the **spacebar** to start a new game instance.

---

## 🧠 Features  
- **AI Mode**: An AI looks ahead multiple moves to decide the best strategy and plays automatically.  
- **Hint Mode**: A button on the board shows the best move based on a depth-limited search.  
- **Color-Coded Tiles**: Tile colors reflect standard 2048 themes using RGB values.  
- **Responsive Game Flow**: Pressing space after a game ends instantly starts a new round.  
- **Win/Loss Screens**: Displays a win/loss message and your total number of moves.

---

## 🧱 File Structure  
- `Game.java`: Main driver of the program. Handles input arguments, game mode selection, and looping logic.  
- `Instance.java`: Manages a single run of the game, including user input handling, game state, and turn tracking.  
- `Board.java`: Core game logic for moving, merging, and scoring tiles. Also contains AI logic and rendering methods.  
- `Block.java`: Represents individual 2048 tiles, including their appearance and behavior on the board.  
- `PennDraw.java`: Lightweight graphics library for rendering the game.  

---

## 🏁 To-Do / Ideas for Future Improvement  
- Add undo functionality  
- Save/load games  
- Display current and best score  
- Support for larger grid sizes (e.g., 5x5 or 6x6)  
- Enhanced AI strategies (e.g., expectimax)  

---

## 📜 Note  
This project is for educational purposes and is not affiliated with the official 2048 game.
