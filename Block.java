/*  Name: Andrew Lukashchuk
 *  PennKey: aluk
 *  Recitation: 215
 *
 *  Execution: none
 *
 *  This contains the individual blocks located on each tile of the 4x4 grid and the
 *  properties of that tile like its numeric value and various methods to update the
 *  tile to keep up with the game.
 */
public class Block {
    // Instance variables
    private int x, y, value;
    private boolean returned = false;

    /*
     * Description: Creates a new block instance at the designated coordinates in 
     *              the 4x4 grid.
     * Input: x coordinate, y coordinate, and value of the block
     * Output: none
     */
    public Block(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    /*
     * Description: Returns a boolean of whether or not a block is at this tile
     * Input: none
     * Output: boolean value
     */
    public boolean atPosition() {
        if (this.value > 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Description: Doubles the value of this tile after another block with the
     *  same value merges into it
     * Input: none
     * Output: none
     */
    public void addValue() {
        if (this.value == 0) {
            this.value = 2;
        } else {
            this.value *= 2;
        }
    }

    /*
     * Description: Sets the return value to false to indicate that this block has 
     *  yet merged this turn
     * Input: none 
     * Output: none 
     */
    public void noReturn() {
        this.returned = false;
    }

    /*
     * Description: Sets the return value to true to indicate that this block has 
     *  already merged this turn 
     * Input: none 
     * Output: none 
     */
    public void yesReturn() {
        this.returned = true;
    }

    /*
     * Description: Returns the returned value of whether or not this tile has 
     *  merged in the current turn 
     * Input: none 
     * Output: boolean value
     */
    public boolean hasReturned() {
        return this.returned;
    }

    /*
     * Description: Iterates through all of the possible values of the block and 
     *  draws the block based on its value, the highest possible value is 2048 at
     *  which point the player wins the game 
     * Input: none 
     * Output: none 
     */
    public void draw() {
        /* sets drawing coordinates based on the block coordinates in order to draw
         * in the appropriate position on the grid
         */
        double x = 0.53 + 0.98 * this.x;
        double y = 0.53 + 0.98 * this.y;

        /* EXTRA CREDIT: Assigns different colors and font size based on the value 
         * of the block */
        if (this.value == 0) {
            PennDraw.setPenColor(187, 173, 160);
            PennDraw.filledSquare(x, y, 0.45);
        } else if (this.value == 2) {
            PennDraw.setPenColor(237, 228, 219);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(60);
            PennDraw.setPenColor(128, 119, 110);
            PennDraw.text(x, y - 0.05, value);
        } else if (this.value == 4) {
            PennDraw.setPenColor(237, 222, 199);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(60);
            PennDraw.setPenColor(128, 119, 110);
            PennDraw.text(x, y - 0.05, value);
        } else if (this.value == 8) {
            PennDraw.setPenColor(243, 176, 121);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(60);
            PennDraw.setPenColor(247, 247, 247);
            PennDraw.text(x, y - 0.05, value);
        } else if (this.value == 16) {
            PennDraw.setPenColor(237, 140, 85);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(55);
            PennDraw.setPenColor(247, 247, 247);
            PennDraw.text(x, y - 0.05, value);
        } else if (this.value == 32) {
            PennDraw.setPenColor(247, 123, 95);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(55);
            PennDraw.setPenColor(247, 247, 247);
            PennDraw.text(x, y - 0.05, value);
        } else if (this.value == 64) {
            PennDraw.setPenColor(234, 90, 56);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(55);
            PennDraw.setPenColor(247, 247, 247);
            PennDraw.text(x, y - 0.05, value);
        } else if (this.value == 128) {
            PennDraw.setPenColor(244, 216, 107);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(50);
            PennDraw.setPenColor(247, 247, 247);
            PennDraw.text(x, y - 0.05, value);
        } else if (this.value == 256) {
            PennDraw.setPenColor(242, 208, 75);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(50);
            PennDraw.setPenColor(247, 247, 247);
            PennDraw.text(x, y - 0.05, value);
        } else if (this.value == 512) {
            PennDraw.setPenColor(227, 191, 41);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(50);
            PennDraw.setPenColor(247, 247, 247);
            PennDraw.text(x, y - 0.05, value);
        } else if (this.value == 1024) {
            PennDraw.setPenColor(222, 186, 20);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(40);
            PennDraw.setPenColor(247, 247, 247);
            PennDraw.text(x, y - 0.05, value);
        } else if (this.value == 2048) {
            PennDraw.setPenColor(235, 195, 1);
            PennDraw.filledSquare(x, y, 0.45);
            String value = "";
            value += this.value;
            PennDraw.setFontBold();
            PennDraw.setFontSize(40);
            PennDraw.setPenColor(247, 247, 247);
            PennDraw.text(x, y - 0.05, value);
        }
    }

    /*
     * Description: Returns the integer value of the block on the tile 
     * Input: none 
     * Output: int value 
     */
    public int getValue() {
        return this.value;
    }

    /*
     * Description: Clears the value of the tile to 0 to indicate no block on the
     *  tile
     * Input: none 
     * Output: none 
     */
    public void noValue() {
        this.value = 0;
    } 

    /*
     * Description: Sets the value of the block on the tile to a specific int value 
     * Input: int value 
     * Output: none 
     */
    public void setValue(int value) {
        this.value = value;
    }
}