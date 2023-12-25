/**********************************************************************
 * Project: 2048
 **********************************************************************/

Name: Andrew Lukashchuk
PennKey: aluk
Hours to complete assignment (optional): 30

/**********************************************************************
 * Instructions for how to run your program (which class to run, any command line 
 * arguments)
 **********************************************************************/

Game.java is the file that should be run via "java Game <mode>" where mode can be 
blank to just play the game regularly, or mode can be "hint" to play with a hint 
button in the middle, or mode can be "ai" to have the ai play the game for you.

/**********************************************************************
 * Any additional features you added beyond the assignment specifications
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

/**********************************************************************
 *  If you did the extra credit, explain your heuristic, and how
 *  you went about implementing it.
 **********************************************************************/

The color gradient was very straight forward and I just used a color picker to try
to get colors as close as possible to those in the real game.

The ai extra credit took me longer than the actual project itself, and I feel like 
I went a bit overkill on it. At first I had a 1000+ line regular ai that checked 
through a bunch of cases to manually pick the "best move". However, this did not 
have much success and wouldn't really make it past 1024. So I changed it up to 
prioritize going into the top right because that is how I usually played the game 
because it is easier to merge stuff together in series into the largest number in 
the top right. I ended up making a numerical score system to go through each case at 
once for all for of the moves and pick the one that was the most effective. This 
shortened the code greatly and allowed the most "well balanced" move to be chosen. 
It also allowed for recursion to be done, so I did not have to manually check for 
the open possibilities after each possible move. This exponentially increased the 
effectiveness of my ai and it wins a significant proportion of the time now.

The hint extra credit built upon the code of my ai extra credit, and gives a hint 
to the player to tell them what move to make based on the move that the ai would 
make if it had the given board layout.

I chose not to do the animation extra credit because I already did over 5 points 
worth of extra credit and it would cause too much lag in my game.

/**********************************************************************
 *  Have you enter all help, collaboration, and outside resources
 *  in your help log?  If not, do so now.  (And in future, make sure
 *  you make your help log entries as you go, not at the end!)
 *
 *  If you did not get any help in outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/

I did not receive any help outside of TA office hours. I 
did not collaborate with anyone, and I did not use any 
resources beyond the standard course materials.

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

Dealing with three consecutive blocks where the first was equal to double the next 
two, I had to spend some time to find a way to make sure they did not all combine
which I did with the instance variable returned in each block.

I had to completely rewrite the ai extra credit 3 times and at one point it was over
1500 lines of code long.

/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
 
I liked how there were no directions or restrictions because I feel much more 
comfortable programming on a whim and just typing stuff up without having to make 
sure I am using the correct function or class names.
