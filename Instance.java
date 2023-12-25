/*  Name: Andrew Lukashchuk
 *  PennKey: aluk
 *  Recitation: 215
 *
 *  Execution: none
 *
 *  This contains the current game instance which reads for user input to send the 
 *  input into the board class from which the actual game functions and methods are 
 *  controlled to run the game and interact with the user's input. 
 */
public class Instance {
    private Board board; 
    private int turns;

    /*
     * Description: The instace object controls the current game instance being 
     *  run by the game.
     * Input: none 
     * Output: none 
     */
    public Instance() {
        this.turns = 0;
        board = new Board();
    }

    /*
     * Description: Used to tell if the game is stil ongoing or has been won or lost
     * Input: none 
     * Output: boolean value of whether or not the game is over 
     */
    public boolean ongoingInstance() {
        return !board.simulationOver();
    }

    /*
     * Description: Controls the game instance where an ai is playing the game 
     * Input: none 
     * Output: none 
     */
    public void aiGame() {
        boolean ongoing = true;

        // how many moves ahead to look 
        board.constantA(6);

        while (ongoing) {
            board.clearReturn();
            board.performMove();
            board.randomBlock();
            turns++;
            board.draw();
            PennDraw.advance();
            if (board.simulationOver()) {
                ongoing = false;
            }
        }
        return;
    }

    /*
     * Description: Controls the game instance when there is a hint button
     * Input: none 
     * Output: none  
     */
    public void hintGame() {
        boolean ongoing = true;

        // how many moves ahead to look 
        board.constantA(8);
        
        board.draw();
        board.drawHint();
        PennDraw.advance();
        while (ongoing) {
            if (PennDraw.hasNextKeyTyped()) {
                // Different controls for the four different directions
                char typed = PennDraw.nextKeyTyped();
                if (typed == 'w' && board.upPossible()) {
                    board.clearReturn();
                    board.moveUp();
                    board.randomBlock();
                    turns++;
                    board.draw();
                    board.drawHint();
                    PennDraw.advance();
                } else if (typed == 's' && board.downPossible()) {
                    board.clearReturn();
                    board.moveDown();
                    board.randomBlock();
                    turns++;
                    board.draw();
                    board.drawHint();
                    PennDraw.advance();
                } else if (typed == 'a' && board.leftPossible()) {
                    board.clearReturn();
                    board.moveLeft();
                    board.randomBlock();
                    turns++;
                    board.draw();
                    board.drawHint();
                    PennDraw.advance();
                } else if (typed == 'd' && board.rightPossible()) {
                    board.clearReturn();
                    board.moveRight();
                    board.randomBlock();
                    turns++;
                    board.draw();
                    board.drawHint();
                    PennDraw.advance();
                }
            }
            if (PennDraw.mousePressed()) {
                if (PennDraw.mouseX() < 2.05 && PennDraw.mouseX() > 1.95 && 
                PennDraw.mouseY() < 2.05 && PennDraw.mouseY() > 1.95) {
                    board.draw();
                    board.drawHint();
                    PennDraw.setPenColor(247, 247, 247);
                    PennDraw.setFontSize(75);
                    PennDraw.text(2.0, 2.0, board.hintMove());
                    PennDraw.advance();
                }
            }
            if (board.simulationOver()) {
            ongoing = false;
            }
        }
        return;
    }

    /*
     * Description: Controls the game instance when the game is being played 
     *  regularly taking in user input to run the game instance 
     * Input: none 
     * Output: none 
     */
    public void newGame() {
        while (ongoingInstance()) {
            if (PennDraw.hasNextKeyTyped()) {
                // Different controls for the four different directions
                board.clearReturn();
                char typed = PennDraw.nextKeyTyped();
                if (typed == 'w' && board.upPossible()) {
                    board.moveUp();
                    board.randomBlock();
                    turns++;
                } else if (typed == 's' && board.downPossible()) {
                    board.moveDown();
                    board.randomBlock();
                    turns++;
                } else if (typed == 'a' && board.leftPossible()) {
                    board.moveLeft();
                    board.randomBlock();
                    turns++;
                } else if (typed == 'd' && board.rightPossible()) {
                    board.moveRight();
                    board.randomBlock();
                    turns++;
                }
            }

            // Advance frame
            board.draw();
            PennDraw.advance();
        }
        return;
    }

    /*
     * Description: Returns the game outcome 
     * Input: none 
     * Output: boolean value that is true if won and false if lost 
     */
    public boolean gameOutcome() {
        return board.gameWon();
    }

    /*
     * Description: Display screen when the game is lost 
     * Input: none 
     * Output: none 
     */
    public void gameLost() {
        board.draw();
        board.drawLost();
        PennDraw.setPenColor(128, 119, 110, 255);
        PennDraw.setFontSize(30);
        PennDraw.setFontBold();
        String display = "You lasted " + turns + " moves.";
        PennDraw.text(2, 1.5, display);
        PennDraw.advance();
    }

    /*
     * Description: Display screen when the game is won 
     * Input: none 
     * Output: none 
     */
    public void gameWon() {
        board.draw();
        board.drawWon();
        PennDraw.setPenColor(247, 247, 247, 255);
        PennDraw.setFontSize(30);
        PennDraw.setFontBold();
        String display = "It took you " + turns + " moves.";
        PennDraw.text(2, 1.5, display);
        PennDraw.advance();
    }
}