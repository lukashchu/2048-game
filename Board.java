/*  Name: Andrew Lukashchuk
 *  PennKey: aluk
 *  Recitation: 215
 *
 *  Execution: none
 *
 *  This class contains all of the methods for the board class which consists of
 *  how all of the blocks interact with each other and how the blocks react to the 
 *  inputs of the player to move them in the four different directions. The bulk of 
 *  the code is in this class.
 */
public class Board {
    // grid of the blocks 
    private Block[][] grid;
    // extra credit instance variables 
    private int constantA;
    private String lastMove;

    /*
     * Description: Creates a new board instance from which the game will be played
     *  on. The 4x4 grid of blocks will be controlled from this instance and the 
     *  board will react directly with the user's controls
     * Input: none
     * Output: none 
     */
    public Board() {
        // assigning a block of value 0 to each of the blocks in the 4x4 grid 
        grid = new Block[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new Block(i, j, 0);
            }
        }

        // Creating the two starting blocks
        randomBlock();
        randomBlock();
    }

    /*
     * Description: Helper function for the randomBlock function that returns the x
     *  and y coordinates of a blank location on the grid 
     * Input: none 
     * Output: int array of blank x, y coordinates
     */
    private int[] emptyBlock() {
        int x = (int) (Math.random() * 4);
        int y = (int) (Math.random() * 4);
        int[] pos = { x, y };
        if (grid[x][y].atPosition()) {
            return emptyBlock();
        }
        return pos;
    }

    /*
     * Description: Checks the game lost conditions by seeing if any of the four 
     *  directions still have possible moves 
     * Input: none
     * Output: boolean value 
     */
    public boolean gameLost() {
        return !(leftPossible() || rightPossible() || upPossible() || 
        downPossible());
    }

    /*
     * Description: Checks if the game has been won by iterating through the tiles 
     *  to see if 2048 has been reached yet 
     * Input: none 
     * Output: boolean value 
     */
    public boolean gameWon() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j].getValue() == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Description: Returns if it is possible for the block in the given coordinates
     *  to move to the right by seeing if the tile to the right is empty or contains
     *  a block of the same value 
     * Input: int x and y coordinates of the block 
     * Output: boolean value 
     */
    public boolean blockRightPossible(int x, int y) {
        for (int i = x + 1; i < 4; i++) {
            if (!grid[i][y].atPosition()) {
                return true;
            }
        }
        return grid[x + 1][y].getValue() == grid[x][y].getValue();
    }

    /*
     * Description: Returns if a move to the right is possible by iterating through 
     *  every tile to see if there is a block there and if it is possible for that 
     *  block to move to the right
     * Input: none 
     * Output: boolean value 
     */
    public boolean rightPossible() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j].atPosition()) {
                    if (blockRightPossible(i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     * Description: Returns if it is possible for the block in the given coordinates
     *  to move up by seeing if the tile above is empty or contains a block of the 
     *  same value 
     * Input: int x and y coordinates of the block 
     * Output: boolean value 
     */
    public boolean blockUpPossible(int x, int y) {
        for (int i = y + 1; i < 4; i++) {
            if (!grid[x][i].atPosition()) {
                return true;
            }
        }
        return grid[x][y + 1].getValue() == grid[x][y].getValue();
    }

    /*
     * Description: Returns if a move up is possible by iterating through every tile 
     *  to see if there is a block there and if it is possible for that block to 
     *  move up
     * Input: none 
     * Output: boolean value 
     */
    public boolean upPossible() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[j][i].atPosition()) {
                    if (blockUpPossible(j, i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     * Description: Returns if it is possible for the block in the given coordinates
     *  to move down by seeing if the tile below is empty or contains a block of the 
     *  same value 
     * Input: int x and y coordinates of the block 
     * Output: boolean value 
     */
    public boolean blockDownPossible(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (!grid[x][i].atPosition()) {
                return true;
            }
        }
        return grid[x][y - 1].getValue() == grid[x][y].getValue();
    }

    /*
     * Description: Returns if a move down is possible by iterating through every 
     *  tile to see if there is a block there and if it is possible for that block 
     *  to move down 
     * Input: none 
     * Output: boolean value 
     */
    public boolean downPossible() {
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (grid[j][i].atPosition()) {
                    if (blockDownPossible(j, i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     * Description: Returns if it is possible for the block in the given coordinates
     *  to move to the left by seeing if the tile to the left is empty or contains
     *  a block of the same value 
     * Input: int x and y coordinates of the block 
     * Output: boolean value 
     */
    public boolean blockLeftPossible(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (!grid[i][y].atPosition()) {
                return true;
            }
        }
        return grid[x - 1][y].getValue() == grid[x][y].getValue();
    }

    /*
     * Description: Returns if a move to the left is possible by iterating through 
     *  every tile to see if there is a block there and if it is possible for that 
     *  block to move to the left
     * Input: none 
     * Output: boolean value 
     */
    public boolean leftPossible() {
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j].atPosition()) {
                    if (blockLeftPossible(i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     * Description: Draws the board first drawing the background and then iterating
     *  through every tile to draw it 
     * Input: none 
     * Output: none 
     */
    public void draw() {
        PennDraw.setScale(0, 4);
        PennDraw.clear(205, 192, 180);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j].draw();
            }
        }
    }

    /*
     * Description: Draws the game lost screen if the player loses 
     * Input: none 
     * Output: none 
     */
    public void drawLost() {
        PennDraw.clear(255, 255, 255, 120);
        PennDraw.setPenColor(128, 119, 110, 255);
        PennDraw.setFontSize(70);
        PennDraw.setFontBold();
        PennDraw.text(2, 2, "Game over!");
    }

    /*
     * Description: Draws the game won screen if the player wins 
     * Input: none 
     * Output: none
     */
    public void drawWon() {
        PennDraw.clear(235, 195, 1, 120);
        PennDraw.setPenColor(247, 247, 247, 255);
        PennDraw.setFontSize(70);
        PennDraw.setFontBold();
        PennDraw.text(2, 2, "You win!");
    }

    /*
     * Description: Assigns a random empty tile to hold a value of either 2 or 4 to
     *  initialize a new random block on the board 
     * Input: none 
     * Output: none 
     */
    public void randomBlock() {
        int[] newBlock = emptyBlock();
        int newValue = 2;
        if (Math.random() < 0.10) {
            newValue = 4;
        }
        grid[newBlock[0]][newBlock[1]].setValue(newValue);
    }

    /*
     * Description: Moves the block with the given inputs up until it reaches a
     *  barrier or a block with a different value it can not merge with or it ends 
     *  the turn by merging with a block of the same value 
     * Input: int x and y positions of block and the int value of the block 
     * Output: none 
     */
    public void blockUp(int x, int y, int value) {
        boolean turnDone = false;
        for (int i = y + 1; i < 4; i++) {
            if (!grid[x][i].atPosition() && !turnDone) {
                grid[x][i].setValue(value);
                grid[x][y].noValue();
                blockUp(x, i, value);
                turnDone = true;
            } else if (grid[x][i].getValue() == value && !turnDone && 
            !grid[x][i].hasReturned()) {
                grid[x][i].addValue();
                grid[x][y].noValue();
                grid[x][i].yesReturn();
                turnDone = true;
            } else {
                turnDone = true;
            }
        }
    }

    /*
     * Description: iterates through all of the blocks and tries to move them up if 
     *  possible 
     * Input: none 
     * Output: none 
     */
    public void moveUp() {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 0; j--) {
                blockUp(i, j, grid[i][j].getValue());
            }
        }
        lastMove("up");
    }

    /*
     * Description: Moves the block with the given inputs down until it reaches a
     *  barrier or a block with a different value it can not merge with or it ends 
     *  the turn by merging with a block of the same value 
     * Input: int x and y positions of block and the int value of the block 
     * Output: none 
     */
    public void blockDown(int x, int y, int value) {
        boolean turnDone = false;
        for (int i = y - 1; i >= 0; i--) {
            if (!grid[x][i].atPosition() && !turnDone) {
                grid[x][i].setValue(value);
                grid[x][y].noValue();
                blockDown(x, i, value);
                turnDone = true;
            } else if (grid[x][i].getValue() == value && !turnDone && 
            !grid[x][i].hasReturned()) {
                grid[x][i].addValue();
                grid[x][y].noValue();
                grid[x][i].yesReturn();
                turnDone = true;
            } else {
                turnDone = true;
            }
        }
    }

    /*
     * Description: iterates through all of the blocks and tries to move them down 
     *  if possible 
     * Input: none 
     * Output: none 
     */
    public void moveDown() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                blockDown(i, j, grid[i][j].getValue());
            }
        }
        lastMove("down");
    }

    /*
     * Description: Moves the block with the given inputs left until it reaches a
     *  barrier or a block with a different value it can not merge with or it ends 
     *  the turn by merging with a block of the same value 
     * Input: int x and y positions of block and the int value of the block 
     * Output: none 
     */
    public void blockLeft(int x, int y, int value) {
        boolean turnDone = false;
        for (int i = x - 1; i >= 0; i--) {
            if (!grid[i][y].atPosition() && !turnDone) {
                grid[i][y].setValue(value);
                grid[x][y].noValue();
                blockLeft(i, y, value);
                turnDone = true;
            } else if (grid[i][y].getValue() == value && !turnDone && 
            !grid[i][y].hasReturned()) {
                grid[i][y].addValue();
                grid[x][y].noValue();
                grid[i][y].yesReturn();
                turnDone = true;
            } else {
                turnDone = true;
            }
        }
    }

    /*
     * Description: iterates through all of the blocks and tries to move them to the 
     *  left if possible 
     * Input: none 
     * Output: none 
     */
    public void moveLeft() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                blockLeft(i, j, grid[i][j].getValue());
            }
        }
        lastMove("left");
    }

    /*
     * Description: Moves the block with the given inputs right until it reaches a
     *  barrier or a block with a different value it can not merge with or it ends 
     *  the turn by merging with a block of the same value 
     * Input: int x and y positions of block and the int value of the block 
     * Output: none 
     */
    public void blockRight(int x, int y, int value) {
        boolean turnDone = false;
        for (int i = x + 1; i < 4; i++) {
            if (!grid[i][y].atPosition() && !turnDone) {
                grid[i][y].setValue(value);
                grid[x][y].noValue();
                blockRight(i, y, value);
                turnDone = true;
            } else if (grid[i][y].getValue() == value && !turnDone && 
            !grid[i][y].hasReturned()) {
                grid[i][y].addValue();
                grid[x][y].noValue();
                grid[i][y].yesReturn();
                turnDone = true;
            } else {
                turnDone = true;
            }
        }
    }

    /*
     * Description: iterates through all of the blocks and tries to move them to the 
     *  right if possible  
     * Input: none 
     * Output: none 
     */
    public void moveRight() {
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                blockRight(i, j, grid[i][j].getValue());
            }
        }
        lastMove("right");
    }

    /*
     * Description: Clears the returned values of every block in the board to 
     *  indicate a new turn and that none of the blocks have merged yet this turn 
     * Input: none 
     * Output: none
     */
    public void clearReturn() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j].noReturn();
            }
        }
    }

    /*
    * EXTRA CREDIT FUNCTIONS
    * AI Extra Credit 
    */

    /* Description: This returns the total number of empty tiles on the current 
     *  board 
     * Input: none 
     * Output: int value of the number of empty tiles
     */
    public int emptyCount() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j].getValue() == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
     * Description: boolean variable that indicates that the simulation is over and
     *  the game should stop running
     * Input: none 
     * Output: boolean value 
     */
    public boolean simulationOver() {
        return gameLost() || gameWon();
    }

    /*
     * Description: This adds a 2 block into the "x"th empty block out of all of 
     *  the possible empty blocks to adjust the board 
     * Input: current board and int x
     * Output: none 
     */
    public void addEmptyBlock(Block[][] field, int x) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (field[i][j].getValue() == 0) {
                    if (x > 0) {
                        x--;
                    } else {
                        field[i][j].setValue(2);
                        return;
                    }
                }
            }
        }
    }

    /*
     * Description: Constant that holds the number of moves ahead the ai and hint 
     *  will look before making a move. 
     * Input: integer value of how many moves ahead to look 
     * Output: none 
     */
    public void constantA(int a) {
        constantA = a;
    }

    /*
     * Description: Returns the constant that holds how many moves ahead to look 
     * Input: none 
     * Output: integer value of the constant 
     */
    public int constantA() {
        return this.constantA;
    }

    /*
     * Description: This provides a "score" of the move being made by scoring the 
     *  board given as an input based on a series of properties such as how close 
     *  the tiles are to being merged and their spot on the board 
     * Input: board's block array and the integer of which iteration it is on 
     * Output: integer value of the board's score 
     */
    public int scoreMove(Block[][] field, int k) {
        if (k <= 0) {
            return 0;
        }

        // storing input field 
        Block[][] addToBlock;
        Block[][] addedBlock;
        int score = 0;
        Block[][] saved = new Block[4][4];
        loadBoard(field);

        /* iterating through every possible block to be added to all of the empty 
         * block positions on the board */
        int emptyBlocks = emptyCount();
        for (int x = 0; x < emptyBlocks; x++) {
            // adding empty block
            loadBoard(field);
            addToBlock = saveBoard();
            addEmptyBlock(addToBlock, x);
            addedBlock = saveBoard();

            /* adding the value of each block in the board multiplied by the x and y 
             * positions to give priority to blocks in the top right corner */
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    score += (int) (addedBlock[i][j].getValue() * i * j);
                }
            }

            /* iterating through each block and subtracting a number of how different
             * in value it is from its neighbors to encourage blocks to merge */
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i < 3) {
                        score -= (int) Math.abs(addedBlock[i][j].getValue() - 
                        addedBlock[i + 1][j].getValue());
                    }
                    if (i > 0) {
                        score -= (int) Math.abs(addedBlock[i][j].getValue() - 
                        addedBlock[i - 1][j].getValue());
                    }
                    if (j > 0) {
                        score -= (int) Math.abs(addedBlock[i][j].getValue() - 
                        addedBlock[i][j - 1].getValue());
                    }
                    if (j < 3) {
                        score -= (int) Math.abs(addedBlock[i][j].getValue() - 
                        addedBlock[i][j + 1].getValue());
                    }
                }
            }
        }

        // saving the scores for all four possible moves to pick the best one 
        int nextScore = 0;
        
        loadBoard(field);
        if (upPossible()) {
            moveUp();
            saved = saveBoard();
            nextScore = scoreMove(saved, k - 1);
        }

        loadBoard(field);
        if (rightPossible()) {
            moveRight();
            saved = saveBoard();
            if (scoreMove(saved, k - 1) > nextScore) {
                nextScore = scoreMove(saved, k - 1);
            }
        }

        loadBoard(field);
        if (leftPossible()) {
            moveLeft();
            saved = saveBoard();
            if (scoreMove(saved, k - 1) > nextScore) {
                nextScore = scoreMove(saved, k - 1);
            }
        }

        loadBoard(field);
        if (downPossible()) {
            moveDown();
            saved = saveBoard();
            if (scoreMove(saved, k - 1) > nextScore) {
                nextScore = scoreMove(saved, k - 1);
            }
        }

        /* returning the highest score possible from all four moves and the following
         * moves using recursion */
        return score + (int) (0.8 * nextScore);
    }

    /*
     * Description: Performs the most optimal move based on the scores assigned in 
     *  the previous method 
     * Input: none 
     * Output: none 
     */
    public void performMove() {
        Block[][] field;
        field = saveBoard();
        Block[][] saved;
        int bestScore = 0;

        // checking all of the moves to save the highest score 
        loadBoard(field);
        if (upPossible()) {
            moveUp();
            saved = saveBoard();
            bestScore = scoreMove(saved, constantA());
        }

        loadBoard(field);
        if (rightPossible()) {
            moveRight();
            saved = saveBoard();
            if (scoreMove(saved, constantA()) > bestScore) {
                bestScore = scoreMove(saved, constantA());
            }
        }

        loadBoard(field);
        if (leftPossible()) {
            moveLeft();
            saved = saveBoard();
            if (scoreMove(saved, constantA()) > bestScore) {
                bestScore = scoreMove(saved, constantA());
            }
        }

        loadBoard(field);
        if (downPossible()) {
            moveDown();
            saved = saveBoard();
            if (scoreMove(saved, constantA()) == bestScore) {
                bestScore = scoreMove(saved, constantA());
            }
        }

        // iterating through the possible moves to pick the best one 
        loadBoard(field);
        if (upPossible()) {
            moveUp();
            saved = saveBoard();
            if (bestScore == scoreMove(saved, constantA())) {
                loadBoard(saved);
                lastMove("up");

                return;
            }
        }

        loadBoard(field);
        if (downPossible()) {
            moveDown();
            saved = saveBoard();
            if (bestScore == scoreMove(saved, constantA())) {
                loadBoard(saved);
                lastMove("down");

                return;
            }
        }

        loadBoard(field);
        if (leftPossible()) {
            moveLeft();
            saved = saveBoard();
            if (bestScore == scoreMove(saved, constantA())) {
                loadBoard(saved);
                lastMove("left");

                return;
            }
        }

        loadBoard(field);
        if (rightPossible()) {
            moveRight();
            saved = saveBoard();
            if (bestScore == scoreMove(saved, constantA())) {
                loadBoard(saved);
                lastMove("right");

                return;
            }
        }
    }

    /*
     * Description: returns the last move to be made 
     * Input: none 
     * Output: String of the last move made 
     */
    public String lastMove() {
        return this.lastMove;
    }

    /*
     * Description: saves the last move to be made 
     * Input: String of the last move made 
     * Output: none 
     */
    public void lastMove(String lastMove) {
        this.lastMove = lastMove;
    }

    /*
     * Description: returns the current board as a block array to be saved in a 
     *  variable 
     * Input: none 
     * Output: block array currently on the board 
     */
    public Block[][] saveBoard() {
        Block[][] saved = new Block[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                saved[i][j] = new Block(i, j, grid[i][j].getValue());
            }
        }
        return saved;
    }

    /*
     * Description: loads a saved block array onto the board 
     * Input: block array 
     * Output: none 
     */
    public void loadBoard(Block[][] saved) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new Block(i, j, saved[i][j].getValue());
            }
        }
    }

    /*
    * EXTRA CREDIT FUNCTIONS
    * Hint Extra Credit 
    */

    /*
     * Description: returns a string of a hing to be given based on the current 
     *  board 
     * Input: none 
     * Output: String of recommended move 
     */
    public String hintMove() {
        Block[][] saveBoard;
        saveBoard = saveBoard();
        String last = "";
        performMove();
        last += lastMove();
        loadBoard(saveBoard);
        if (last.equals("up") && upPossible()) {
            return "Go up!";
        } else if (last.equals("down") && downPossible()) {
            return "Go down!";
        } else if (last.equals("right") && rightPossible()) {
            return "Go right!";
        } else if (last.equals("left") && leftPossible()) {
            return "Go left!";
        }
        return "";
    }

    /*
     * Description: Draws the hint button on the board 
     * Input: none 
     * Output: none 
     */
    public void drawHint() {
        PennDraw.setPenColor(100, 245, 66);
        PennDraw.filledSquare(2.0, 2.0, 0.04);
        PennDraw.setPenColor(247, 247, 247);
        PennDraw.setFontSize(10);
        PennDraw.text(2.0, 2.0, "?");
    }
}