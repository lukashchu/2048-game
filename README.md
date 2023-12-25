/**********************************************************************
 * Project: 2048
 **********************************************************************/

Name: Andrew Lukashchuk

/**********************************************************************
 * Instructions for how to run your program (which class to run, any command line 
 * arguments)
 **********************************************************************/

Game.java is the file that should be run via "java Game <mode>" where mode can be 
blank to just play the game regularly, or mode can be "hint" to play with a hint 
button in the middle, or mode can be "ai" to have the ai play the game for you.

/**********************************************************************
 * Additional features implemented in the Game
 **********************************************************************/

The colors are color coded to be different for each number and I used colors almost
the same as those in actual 2048 by using the rgb color picker.

By putting in the command line argumennt "Java Game ai", the ai will play the game 
for you.

By putting in the command line argument "Java Game hint", there will be a hint 
button in the middle of the board which will give a hint of what move the player 
should make next.

After the game ends, the player can start a new one by pressing the space button 
instead of having to close and restard the game.

/**********************************************************************
 * A brief description of each file and its purpose
 **********************************************************************/

Game.java is the main execution that takes in the user's keyboard input and inputs 
it into the game. It is where the game loop that runs the game is located.

Instance.java controls the current instance of the game that is being played. After
the game is won or lost, a new instance can be started by pressing the space button.

Block.java contains and controls the properties for each individual tile in the 4x4 
grid including the value of the tile and drawing the blocks based on their value.

Board.java contains the bulk of the code and has all of the methods and functions 
to operate how the blocks interact with each other and react the user's input 
whether to move everything up, down, left, or right. This file also contains the ai 
extra credit code.
