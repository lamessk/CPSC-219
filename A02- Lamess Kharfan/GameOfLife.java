/*
Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 2. Game Of Life . Version 1. 
Class GameOfLife runs the program. Driver of the program. Instantiating the user 
interface and calls the methods of it to run the program. Implements only the very
base bones of functionality of GameOfLife. 
Features:
The "Game of Life" is a biological simulation created by John Conway and consists of 
a "biosphere" that is divided into cells. Each cell is inhabited by a life form that I 
will refer to as "the Critter".  Critters will live or die depending upon a simple set of 
rules. Critter dies if it 0-1 neigbors due to lonliness and dies if it has more than 4 
neighbors due to overcrowding. If the square is empty: a critter will be born there if it has
exactly 3 neighbors. After initializing the starting positions, the program will simulate the 
births and deaths of the critters over time on a turn-by-turn basis. Births and deaths occur 
simultaneously. Two arrays of type Critter are shown. One array,'previous', contains the positions
of the critters previous to the turn and is used to determine how many critters neighbor a particular 
square.  The second array,'current', will initially contain the same pattern of critters as the other 
array.  As the program scans the previous array, critters will die from and be born into the 'current' array.
Limiations: Can only handle 10x10 arrays. User input must be an integer. 

James Tam Credits: 
  Author:  James Tam
  Version: Feb 2015

  This simplified version just creates a Biosphere (#6) and displays it.
  In the actual version a user interface should be created in main() and the
  user interface should create the Biosphere (allowing the user which version
  #1 - 7 is used for initialization).
*/

public class GameOfLife
{
    public static void main(String [] args)
    {
        //Create a new user interface for a user to run the game from
        UserInterface aInterface = new UserInterface();
        //Call the menu method to display all the options of biosphers the user
        //may selected
        aInterface.menu();
        //Call getBioSphere, will run all methods for checking for neighbors, births
        //deaths, ask to run another generation or quit. 
        aInterface.getBioSphere();
        
    }
}
