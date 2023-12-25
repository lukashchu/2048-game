/*  Name: Andrew Lukashchuk
 *  PennKey: aluk
 *  Recitation: 215
 *
 *  Execution: java Game <mode>
 *
 *  This is the main execution class for the 2048 game. It initializes a new board
 *  and assigns the controls to do their respective purpose. If the game is over it 
 *  displays a message letting the player know if they won or lost. wasd controls.
 *  Mode can be blank, "ai", or "hint".
 */
public class Game {
    /*
     * Description: The game object is used to indicate what mode is being played 
     *  and connects the user input into the game instance by starting a new 
     * instance when the game starts and whenever the user wants to start a new one.
     * Input: String of the game mode 
     * Output: none 
     */
    public static void game(String mode) {
        // Initializes new game instance to be played 
        Instance curr = new Instance();

        // Sets game mode in instance 
        if (mode.equals("ai")) {
            curr.aiGame();
        } else if (mode.equals("hint")) {
            curr.hintGame();
        } else if (mode.equals("game")) {
            curr.newGame();
        }

        // End game display for whether game won or lost
        if (curr.gameOutcome()) {
            curr.gameWon();
        } else {
            curr.gameLost();
        }

        // Waits for user to press space button to start a new instance when over 
        boolean waiting = true;
        while (waiting) {
            if (PennDraw.hasNextKeyTyped()) {
                String key = "";
                key += PennDraw.nextKeyTyped();
                if (key.equals(" ")) {
                    waiting = false;
                }
            }
        }
    }

    // Main execution 
    public static void main(String[] args) {
        // Enabling Penn Draw animation for the game
        PennDraw.enableAnimation(30);

        // Game loop where each instance will be ran 
        while (true) {
            // Picking game mode based on command line arguments 
            if (args.length == 0) {
                game("game");
            } else if (args.length == 1) {
                if (args[0].equals("ai")) {
                    game("ai");
                } else if (args[0].equals("hint")) {
                    game("hint");
                } else {
                    game("game");
                }
            }
        }
    }
}