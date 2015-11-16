/*
Lamess Kharfan. Student number: 10150607. CPSC 219. T04. Assignment 2. Game of Life. Version 1.
Class Critter: Instances of this class will store information about each critter. Includes an 
attribute that is used to store information about the critter's appearance.
Whenever the program runs through the loops to display individual squares of the biosphere, 
the character that is displayed for a particular square will be determined by the appearance of the 
critter (star = REGULAR, exclamation mark = FERTILE or a space = EMPTY) 
*/

public class Critter
{
    
    //Ceat apparenances of all critters
    public static final char REGULAR = '*';
    public static final char FERTILE = '!';
    public static final char EMPTY = ' ';

    private char appearance;

    //Set appearance to a new one in current
    public Critter(char newAppearance)
    { 
        setAppearance(newAppearance);
    }

    /*
       Displays the current appearance of the Critter in the form of 
       a single character. The character will be displayed to the screen
       (console) and the cursor remains on the same line.
    */
    public void display()
    {
        System.out.print(appearance);
    }


    public char getAppearance()
    {
        return(appearance);
    }

    public void setAppearance(char newAppearance)
    {
        appearance = newAppearance;
    }
    
}
