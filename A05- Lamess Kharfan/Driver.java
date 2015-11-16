
/**
 *Lamess Kharfan. Student Number: 10150607.T04. CPSC 219. Assignment 5. Movie Collection. Version 1.
 * This Movie collection program  allows a person to manage their movie collection.
 * A menu is initially displayed to the user giving them the option to add, search, or
 * remove movies and to also quit the program. They may enter as many movies as they like,
 * which will be sorted in alphabetical order as the user enter more and more movies
 * using the add option in the main menu. Using the add option,  The user may only enter
 * one of 6 specific genres and they may also only enter a rating between 1 and 5 for the 
 * movie, or a value less than 0 to terminate addition of a movie. The user may also search for a movie in the collection
 * using the search function, which will display all available data about a movie, which includes
 * the title, the names of the main cast members, genre, and the users personal rating for the 
 * movie out of 5 stars. The user has the ability to display all the movie in their collection, while will
 * appear in sets of four, as the user hits enter to view more and more movies. The user lastly, has the ability
 * to remove any movie by title that they wish, as long as it exists in the collection, they may do so by simply
 * entering the name of the movie they wish to delete into the search prompt. When the user is done with their movie
 * collection they may quit the program at the main menu.
 * Program limitations: Entered a string into the rating prompt will cause the program to crash.  
 * 
 * Driver() is the main starting execution point of the program.
 */
public class Driver {

    public static void main(String[] args) 
    {
       UserInterface aInterface = new UserInterface();
       aInterface.runTurn();
    }
    
}

