/*Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 3. Race Tracks. Version 1.
Class GameController() is the user interface for the program (responsible for input 
and output: displaying the appropriate menu, getting user input, validating input etc.).
To a large extent it is directly and indirectly responsible for carrying out those actions.
Directly when the required code is included in a method of this class; indirectly when it 
calls the method of another class). Each track is separate, cars cannot move from one track to 
another. Also the track type determines the type of car that will drive there (there's never 
an SUV in the desert track or a Sports car in the arctic!)This class will also manage the 'rules'
of the simulation e.g., has the simulation ended, which car has 'won' etc.
*/
import java.util.Scanner;
import java.lang.*;
public class GameController {
    
    Scanner in = new Scanner(System.in);
    //Atributes for GameController
    //position one of strings, arrays.
    private final int FIRST = 0;
    //Input from user for SUV menu in string form
    private String selectionA;
    //Input from user for SUV in char form 
    private char selectionAChar; 
    //Input from user for sports car in string form
    private String selectionB;
    //Input from user for sports car in char form
    private char selectionBChar;
    //Keeps track of where the cars are in the array
    public int tracker;

    //Instantiation of an SUV object
    SUV aSUV = new SUV();
    //Instantiation of a Sports car object
    Sports aSport = new Sports();
    //Instantiation of a desert track
    DesertTrack aDesertTrack = new DesertTrack();
    //Instantiation of an arctic track
    ArcticTrack aArcticTrack = new ArcticTrack();

    /**
     *menuSUV() displays all the options for moving the SUV to the user and gives 
     * them the option to quit the simulation. 
     * @return selectionA - used to determine if the user is in cheat mode and 
     * determine weather or not the SUV has the option to move.
     */
    int suvCheating;
    public char menuSUV() 
    {
        //Print out menu with options for the user to choose from
        System.out.println("\nSUV DRIVING OPTIONS");
        System.out.println("(a)ll wheel drive mode");
        System.out.println("(d)rive normally");
        System.out.println("(q)uit simulation");
        System.out.print("Enter your selection: ");
        //selectionA - the input given by the user.
        selectionA = in.nextLine();
        
        //Convert the string form of input into a char using first position of 
        //String given by the user.
        selectionAChar = selectionA.charAt(FIRST);
        
        //Use the users input to determine which mode the SUV will drive in
        //Either AWD or normally. Or if the user has decided to enter the cheat menu
        //Or if the user has decided to quit.
        switch(selectionAChar)
        { 
            case 'c':
            case 'C':
                //Enter the cheat menu
                cheatMenu();
                break;
            case 'q':
            case 'Q':
                //Quit simulation
                System.out.println("SUV quit early, its a draw!");
                System.out.println("Quitting...");
                System.exit(0);   
                break;
            /*default:
                //If the user has entered an invalid selection ask for another.
                System.out.print("Invalid selection! Please enter a valid selection: ");
                selectionA = in.nextLine();
                selectionAChar = selectionA.charAt(FIRST);*/
        }

        //Return the users input
        return selectionAChar;
    }
   
     /**
     *menuSports() displays all the options for moving the Sports car to the user and gives 
     * them the option to quit the simulation. 
     * @return selectionB - used to determine if the user is in cheat mode and 
     * determine weather or not the SUV has the option to move.
     */
    int sportCheat;
    public char menuSports() 
    {
        //Print out menu with options for the user to choose from
        System.out.println("\nSPORTS CAR DRIVING OPTIONS");
        System.out.println("(d)rive normally");
        System.out.println("(q)uit simulation");
        System.out.print("Enter your selection: ");
        //selectionB - the input given by the user.        
        selectionB = in.nextLine();
        //Convert the string form of input into a char using first position of 
        //String given by the user.        
        selectionBChar = selectionB.charAt(FIRST);
        
        //Use the users input to determine which mode the Sports car will drive in
        //Or if the user has decided to enter the cheat menu or if the user has decided to quit.
        switch(selectionBChar)
        {
             //Enter the cheat menu
            case 'c':
            case 'C':
                cheatMenu();
               break;
            //Quit the simulation
            case 'q':
            case 'Q':
                System.out.println("Sports Car quit early! It's a draw!");
                System.out.println("Quitting...");
                //quit program
                System.exit(0);   
                break;
            /*default:
                //If the user has entered an invalid selection ask for another
                System.out.print("Invalid selection! Please enter a valid selection: ");
                selectionB = in.nextLine();
                selectionBChar = selectionA.charAt(FIRST);
                break;*/
        }
        //Return the users input in string form
        return selectionBChar;

    }
    
    /**
     *Cheat menu() can be used be both the SUV and the sports car to sabatoge one
     * another and increase one's chances of winning. The user may turn on debug mode 
     * to determine the positions of each car in the array, who is winning, or if it is a tie.
     * Cars may change each others amounts of fuel, Cars may change their locations in the array.
     * Cars may invoke a blizzard(SUV Arctic) or a heat wave(sports car, Desert).
     */

    public void cheatMenu()
    {
        int cheat;
        //Display menu with all the cheats
        System.out.println("\nCHEAT MENU SELECTION");
        System.out.println("(0) Toggle debugging messages on/off");
        System.out.println("(1) Change fuel of sports car");
        System.out.println("(2) Change fuel of SUV car");
        System.out.println("(3) Change location of sports car");
        System.out.println("(4) Change location of SUV car");
        System.out.println("(5) Make a blizzard in the artic track");
        System.out.println("(6) Make a heat wave in the desert track");
        System.out.print("Enter selection: ");
        cheat = in.nextInt();
        
        //While the user is entering a selection out of the range out the given 
        //menu selection, ask for another selection. 
        while(cheat < 0 || cheat > 6)
        {
            System.out.println("Invalid selection");
            System.out.print("Please enter a valid selection: ");
            cheat = in.nextInt();
        }
        
        //Implement the cheat that the user has specified.
        switch (cheat)
        {
            //Turn on debug mode. Display position of each car, who winning, or if it is a tie
            case 0:
                System.out.println("\t (0)Turn on debug mode");
                System.out.println("\t (1) Turn off debug mode");
                System.out.print("\t Enter your selection: ");

                int toggle = in.nextInt();
                if (toggle == 0)
                {
                    Debug.debugOn();
                    int pPos = aDesertTrack.getPosition();
                    int vPos = aArcticTrack.getPosition();
                    System.out.println("The current position of the sports car is: " + pPos);
                    System.out.println("The current position of the sports car is: " + vPos);
                    if(vPos == pPos)
                        System.out.println("Its a tie!\n");
                    else if(vPos > pPos)
                        System.out.println("SUV is winning\n");
                    else if(pPos > vPos)
                        System.out.println("Sports Car is winning\n");
                }
                
                else if(toggle == 1)
                    Debug.debugOff();
                
                break;
            
            //Change fuel of the sports car
            case 1:
                System.out.print("Enter the fuel for sports car: ");
                int sportsFuel;
                sportsFuel = in.nextInt();
                aSport.setFuel(sportsFuel);
                System.out.println("The fuel for the sports car is: " + sportsFuel+ "\n");
                break;
            //Change the fuel for the SUV
            case 2:
                //SUV set fuel
                System.out.print("Enter the fuel for SUV car: ");
                int suvFuel;
                suvFuel = in.nextInt();
                aSUV.setFuel(suvFuel);
                System.out.println("The fuel for the SUV is:" + suvFuel);
                break;
            //Put the Sports car at a different location in the desert track
            case 3:
                System.out.print("Enter a location to move sports car(between 0 and 24): ");
                int newLocationSport = in.nextInt();
                aDesertTrack.setLocation(aSport, newLocationSport);
                aDesertTrack.setPosition(newLocationSport);
                break;
            //Put the SUV at a diferent location in the arctic track
            case 4:
                System.out.println("Enter a location to move SUV(between 0 and 24): ");
                int newLocationSUV = in.nextInt();
                aArcticTrack.setLocation(aSUV, newLocationSUV);
                aArcticTrack.setPosition(newLocationSUV);
                break;
            //Invoke a blizzard upon the arctic track
            case 5:
                System.out.println("Blizzard invoked in the arctic track");
                aArcticTrack.blizzardInvoked();
                break;
            //Invoke a heat wave upon the desert track
            case 6:
                System.out.println("Heat wave invoked in the desert track");
                aDesertTrack.HeatWaveInvoked();
                break;
        }
       
        in.nextLine();
    }
    
    /**
     *runTurn() Displays the menus, displays the tracks, displays the cheat menu, 
     * keeps track of the where the cars are in their respective tracks. Wipes 
     * tracks, displays new tracks with cars in their new positions. 
     * Determines if either car is out of fuel and can no longer move. Determines
     * who won, who lost, and if it is a tie. 
     */
    public void runTurn()
    {
        //Display instructions to the user.
        System.out.println("Welcome to the race track! \n Here you can race an SUV in the arctic and a Sports car in the desert! \n"
                + "The rules are simple, to move each car chose the mode of movement from the driving options and keeping going\n until "
                + "one car gets to the end! Watch out though, your fuel is limited and harsh weather may sabatoge you!\n"
                + "(Feeling a little mischievous? Hit 'C' at the menu prompt and sabatoge your opponent!\n)");
        
        //Display Arctic track and desert track  with sports car and SUV in starting positions
        aArcticTrack.setLocation(aSUV, FIRST);
        aArcticTrack.displayArctic();
           
        aDesertTrack.setLocation(aSport, FIRST);
        aDesertTrack.displayDesert();
        
        //While a car has not reached the end of its respective array
        while(tracker < 25)
        {
            
            //prompt user to enter SUV driving option
            menuSUV();
            //Call blizzard function to disover if one will be invoked
            aArcticTrack.Blizzard(selectionAChar);
            //check if SUV is out of fuel
            boolean suvEMPTY = aSUV.isEmpty();
            if(suvEMPTY == true)
            {
                System.out.println("SUV has run out of fuel!");
            }
            //If SUV is not empty, move and advance
            int vMove = aSUV.move();
            int vAdvance = aArcticTrack.advance(vMove);
            
            //Prompt user to enter sports driving selection
            menuSports();
            //
            aDesertTrack.HeatWave(selectionBChar);
            
            boolean sportEMPTY = aSport.isEmpty();
            if(sportEMPTY == true)
            {
                System.out.println("The sports car has run out of fuel!");
            }
            
            int sMove = aSport.move();
            int pAdvance = aDesertTrack.advance();
            
            
            //Set all elements of the array to null, erasing the previous positions
            //of the sports car and SUV in their tracks.
            aDesertTrack.wipe();
            aArcticTrack.wipe();
           
            //Check if the sports car has reached the end of the desert track 
            //If the sports car has reached the end of the track, display message
            //announcing the sports car is the winner and exit loop
            if(pAdvance >= 24)
            {  
                System.out.println("Sports Car has reached the end of the track!");
                System.out.println("Sports Car is the winner! \n");
                aDesertTrack.setLocation(aSport, 24);
                tracker = 25;
            }
            //If sports car has not reached the end of the track, move sports car to 
            //its new position in the desert track
            else if(pAdvance < 24)
                aDesertTrack.setLocation(aSport, pAdvance);                
            
            //Check if the SUV car has reached the end of the arctic track 
            //If the SUV car has reached the end of the track, display message
            //announcing the SUV car is the winner and exit loop
            if(vAdvance >= 24)
            {
                System.out.println("SUV has reached the end of the track!");
                System.out.println("SUV is the winner! \n");
                aArcticTrack.setLocation(aSUV, 24);
                tracker = 25;
            }
            //If the SUV has not reached the end of the track, move it the new position
            //in the arctic track
            else if(vAdvance < 24)
                aArcticTrack.setLocation(aSUV, vAdvance);                
            
            //If the sports car and the SUV are in the same position in their respective 
            //tracks, announce that they are tied.
            if(pAdvance == vAdvance)
            {
                //If they are at the end of the track and tied, display a message saying
                //that they reached the end at the same time and it is a tie!
                if(pAdvance >= 24 && vAdvance >= 24)
                {
                    System.out.println("SUV and Sports Car reached end at the same time! It's a draw! \n");
                    aDesertTrack.setLocation(aSport, pAdvance);
                    aArcticTrack.setLocation(aSUV, vAdvance);  
                    tracker = 25;
                }
                //If the cars are not at the end but in the same position, display that they are tied
                else
                {
                    System.out.println("SUV and Sports Car are tied \n");
                    aDesertTrack.setLocation(aSport, pAdvance);
                    aArcticTrack.setLocation(aSUV, vAdvance);    
                }
                
            }
            //if both cars are empty then the results are a draw.
            //Display result and end simulation
            if(sportEMPTY == true && suvEMPTY == true)
            {
                System.out.println("Both cars have run out of fuel before reaching the end of the track!");
                System.out.println("Its a draw!");
                tracker = 25;
            }
            //Display the tracks at the end or before the next turn is run
            aArcticTrack.displayArctic();
            aDesertTrack.displayDesert();
        }   
    }    
}
