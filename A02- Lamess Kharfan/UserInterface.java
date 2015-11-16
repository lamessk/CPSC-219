import java.util.Scanner;
//
 //*Lamess Kharfan. Student #: 10150607. T04. CPSC 219. 
// * Assignment 2. Game of Life. Version 1. 
//* Class UserInterface's main jo is displaying the initial menu (biosphere selection), 
//*getting user input and the end of each turn, determining if the user's selection was 
//*valid/determining which option was selected. Uses the input to initialize a biosphere,
//*run the counts and determines births or deaths to be displayed in current bioshphere. 
//* Asks user if they would like to run the generation in debug or not. 
//*Asks the user if they would like to run another generation or not. Continues until the
//*User quits the program
 
public class UserInterface {

    //Attributes associated with the entire class
    
    //bioType is an interger that tells the program which biosphere the user
    //could like to run
    private int bioType;
    //Takes in the input of whether or not to run another turn or quit
    private String inputString;
    //inputChar is used to take input string and make it a char to compare types
    private char inputChar;
    //FIRST is used to take the first char of a string of input
    private final int FIRST = 0;
    //Takes in the input od weather or not to run debug mode in the String form 
    private String debugString;
    //debugChar is used to make the input a char to compare types
    private char debugChar;
    
    //Instantiate class Scanner to get input
    Scanner in = new Scanner(System.in);
    
    /**
     *menu() prints out all of the options the user has for different types of
     * biospheres. Asks the user for a integer between 1-8, depending on the 
     * biosphere.
     * 
     * @return bioType
     */
    public int menu()
    {
        System.out.println("Pick the starting biosphere: ");
	System.out.println("\t 1) All Empty");
	System.out.println("\t 2) One Critter");
	System.out.println("\t 3) Single Birth");
	System.out.println("\t 4) Simple Pattern in Middle");
	System.out.println("\t 5) Pattern near Edges");
	System.out.println("\t 6) Fertile Critter");
	System.out.println("\t 7) Complex Pattern 1: One Fertile Critter");
	System.out.println("\t 8) Complex Pattern 2: Fertile Critter");
	System.out.print("\t Please Enter Your Selection: ");
	bioType = in.nextInt();
        
        
        //Exception handling, if the user inputs a selection less than 1 and
        //greater than 8, request another selection.
	if (bioType < 1 || bioType > 8){
            
	System.out.println("Invalid Selection");
	System.out.println("Please enter a valid selection: ");
	bioType = in.nextInt();

        }
        return bioType;
    }
    
    /**
     *Create a biosphere and run all methods within biosphere for scanning and counting
     * in order to have births and deaths occur and go from the previous biosphere to the 
     * current biosphere. Asks the user to hit enter to run another generation or 'Q' to quit. 
     * Also asks the user if they could like to run the program in debugging mode.
     */
    public void getBioSphere()
    {
        //Create new biophere
        Biosphere aBiosphere = new Biosphere();
        //initialize biosphere to biosphere specified by the user
        aBiosphere.initialize(bioType);
        in.nextLine();
        
        //While the user does not want to quit
        while(inputChar != 'Q' || inputChar != 'Q')
        {
            //Scan all squares, count neighbors, determine births, determine deaths
            //Copy new array into current
            aBiosphere.checkLeft();
            aBiosphere.checkRight();
            aBiosphere.checkTopLeft();
            aBiosphere.checkTopRight();
            aBiosphere.checkBottomLeft();
            aBiosphere.checkBottomRight();
            aBiosphere.checkTopRow();
            aBiosphere.checkBottomRow();
            aBiosphere.checkMiddle();
            
            //Run a turn to display the biosphere
            aBiosphere.runTurn();
            
            //If the user would like to see the next generation, hit enter.
            //If the user wants to quit give them the option to hit Q or q
            System.out.println("Hit enter to run another generation ('q' to quit)");
            //Assign input to the variable "inputString"
            inputString = in.nextLine();
            
            //If the user hit enter then the length of the input would be 0.
            //If the user hit anything else, check what it was.
            if (inputString.length() != 0)
            {
                //Make the input be a char to compare to other chars
                inputChar = inputString.charAt(FIRST);
                //Switch input char
                switch(inputChar)
                {
                    //If the input is 'q' or 'Q' then quit the program
                    case 'Q':
                    case 'q':
                    //Display a message showing that you are quitting
                    System.out.println("Quitting...");
                    //quit program
                    System.exit(0);   
                    break;

            }
        }
            
            //Ask the user if they would like to run the program in debug mode.
            //If they would like to they will hit 'd', otherwise they can hit 'D'
            //to continue running another generation without debug mode or to turn
            //debig mode off
            System.out.print("To set to debug mode hit 'd'('D' to to exit debug mode or to not run debug mode)");
            //Assign input to a string
            debugString = in.nextLine();
            //Convert the string into a character to compare it to other chars
            debugChar = debugString.charAt(FIRST);
            //switch char
            switch(debugChar)
            {
                //If 'd' was selected, turn debug mode on
                case 'd':
                    Mode.debugOn();
                    break;
                //If 'D' was selected, turn debug mode off or continue not using it
                case 'D':
                    Mode.debugOff();
                    break;
            }
            
            //Display the next generation with the old current as previous
            aBiosphere.newPrevious(); 
        }
    }
    
    }
