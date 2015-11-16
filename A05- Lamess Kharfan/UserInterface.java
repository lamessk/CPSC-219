/**
 * Lamess Kharfan. Student Number: 10150607. T04. CPSC 219. Assignment 5. Movie Collection. Version 1.
 *Class UserInterface() is responsible for all interactions with the user (displaying program options, 
 * getting user input). The user interface class is responsible for displaying a menu of 
 * features available, getting the user's selection, checking the validity
 * of the input and determining the option selected. Once the appropriate menu option
 * has been determined then the user interface class tells class manager
 * to run the appropriate method. The program repeats until the user quits. Each 
 * time that the program repeats the main menu is displayed. 
 */

import java.util.Scanner;

public class UserInterface {
    
    //Attribues associates with class UserInterface()
    public final int FIRST = 0;
    //Import scanner to get user input
    Scanner in = new Scanner(System.in);
    //Store users selection in string form
    String selection;
    //Used to convert user's string input into a char format
    char selectionChar;
    
    //Instantiate manager to use methods of class manager
    Manager aManager = new Manager();
            
            
    //Displays an introduction to the program (describes how it works)
    //each time that it's run.
    UserInterface()
    {
        
        System.out.println("Welcome to your personal movie collection manager \n"
                + "where you can organize your movies according to name, cast members, \n"
                + "genre of movie, and your personal ratings(out of 5 stars)");
    }
    //displayMenu() Displays the menu  of features available, gets the user's selection, checks
    //the validity of the input and determines the option selected.
    public void displayMenu()
    {
        
        //Displays a menu listing the features available.
        System.out.println("MOVIE COLLECTON OPTIONS: ");
        System.out.println("\t (A)dd a movie to the collection");
        System.out.println("\t (S)earch your movie collection");
        System.out.println("\t (R)emove a movie from the collection");
        System.out.println("\t (D)isplay your movie collection");
        System.out.println("\t (Q)uit");
        //Prompt user to enter their selection from the main menu
        System.out.print("\t Enter your selection: ");
        //Store in a string
        selection = in.nextLine();
        //Convert string into char by taking first char of the string
        selectionChar = selection.charAt(FIRST);

        
        System.out.println();
        //Depending on the users selection, either quit the program or make
        //a call to a method of class Manager to add, remove, search, or display.
        switch(selectionChar)
        {
            case 'A':
            case 'a':
                //Call addAdvanced() method of class manager which
                //will take in data about movie and ad them to the list
                //in alphabetical order
                aManager.addAdvanced();
                break;
            case 'S':
            case 's':
                //Search the list for a movie that the user has specified and
                //display data of that movie if it is found
                aManager.search();
                break;
            case 'D':
            case 'd':
                //Display all movies in the list, in 4's
                aManager.display();
                break;
                
            case 'R':
            case 'r':
                //Remove any movie the user specifies from the list
                aManager.remove();
                break;
            case 'Q':
            case 'q':
                //Displays a sign off exit message to indicate 
                //to the user that the program has ended.
                System.out.println("Thanks for managing for movie collection with Movie Manager! ");
                System.out.println("Exitting... ");
                System.exit(0);
                break;
        }
        
        
    }
    //While the user has not quit the program, display the menu prompting the
    //user for a selection from the main menu, if the user enters an invalid 
    //selection, menu will continually display until the user either quits or
    //enters a valid selection.
    public void runTurn()
    {
        while(selectionChar != 'q' || selectionChar != 'Q')
        {
            displayMenu();
        }
    }
    
}

