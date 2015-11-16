

import java.util.Scanner;

/**
 * Lamess Kharfan. Student Number: 10150607.T04. CPSC 219. Assignment 5. Movie Collection. Version 1.
 *Class Manager() includes methods for all the major list operations, add, remove, search 
 * and display. View each method for more specific details as to how each method works.
 * 
 */
public class Manager {
    
    //Attributes associated with the class
    private MovieNode head;
    private int FIRST = 0;
    //Import scanner to get user input
    Scanner in = new Scanner(System.in);
    //List header to be displayed when displaying all movies in the collection
    private final String LIST_HEADER = "MOVIE COLLECTION:";
    
    public Manager()
    {
        head = null; //New empty list
    }
    
    //Erase list sets all elements in the list in null
    //Erases everything in the list
    public void eraseList()
    {
        head = null;
    }


    /**
     *addAdvanced()inserts movies in ascending order of name (in-order insertion).
     *It takes in all the information from the user about the movie, including name, 
     * names of 3 main cast members, genre, and users rating out of 5 stars for the movie.
     * Error checks are performed if the user enters a genre that does not exist or a 
     * rating that is above 5, program also terminates addition of a movie if user enters
     * a rating less than 1. Using the information entered by the user, addAdvanced() compares
     * titles of already existing movies in the list and inserts them in alphabetical order.
     */
        public void addAdvanced()
    {
        //Attributes associated addition of a new movie
        String title;
        String c1;
        String c2;
        String c3;
        String genre;
        int MATCH = 0;
        //Possible genres that the user may enter
        String[] possibleGenres = {"action", "drama", "science fiction","comedy", "horror", "martial arts", "other"};
        //Users rating /5
        int rate;
        
        //Instantiation of a new movie and a new movie node
        Movie newMovie;
        MovieNode newNode;
        
        //Prompts the user to enter title, 3 character names, genre and rating
        System.out.println("Adding a new movie..");
        System.out.print("\t Movie Title: ");
        title = in.nextLine();
        System.out.print("\t Name of cast member 1: ");
        c1 = in.nextLine();
        System.out.print("\t Name of cast member 2: ");
        c2 = in.nextLine();
        System.out.print("\t Name of cast member 3: ");
        c3 = in.nextLine();
        System.out.print("\t Genre of the movie: ");
        genre = in.nextLine();
        
        //Error check for if the users input for genre is valid
        boolean isInArray = false;
        //For all genres in the list, check if the users genre is valid(in the list of possible genres)
        for (int i = 0; i < possibleGenres.length; i++) 
        {    
            //If users input is in the list of possible genres, set validity to true
            if(genre.equalsIgnoreCase(possibleGenres[i]))
                isInArray = true; 
        }
        //If the users input was not valid, prompt the user to enter another (valid) genre
        if(isInArray == false)
        {
            System.out.println("\t Invalid genre entered. Please enter a valid one: ");
            genre = in.nextLine();
        }
        
        System.out.print("\t Your Rating: Stars(1-5, Less than 1 to terminate addition) :  ");
        rate = in.nextInt();
        
        //Error check for if the users rating input is valid. While the users input
        //is greater than 5, continue to prompt the user for a valid rating
        while(rate > 5)
        {
            System.out.println("\t Invalid rating!");
            System.out.println("\t Please enter a number between 1 and 5");
            rate = in.nextInt();
            //If the user enters an invalid title, terminate addition of the movie
            //Return to main menu
            if(rate < 1)
            {
                System.out.println("Terminating addition of " + title + "to your movie collection.");
                return;
            }
        }
        
        //Using all of the information given by the user, create a new movie for the list
        //and also create a new movieNode
        newMovie = new Movie(title, c1, c2, c3, genre, rate);
        newNode = new MovieNode(newMovie, null);
        
        
        //Instantiate all attributes for adding movie in alphabetical order
        //A previous and a current position in the list are needed to do so
        MovieNode previous = null;
        MovieNode current = head;
        
        //If the list is empty, the new node is the head
        if(head == null)
        {
            head = newNode;
        }

        //If the list if not empty
        else 
        {
            //While there is node after current and the name of the movie in the current position's first letter
            //is smaller than the one the user just entered
            while(current.getNext() != null && ((current.getData().getName().compareToIgnoreCase(title) < 0)) )
            {
                //Continue moving through the list until we find a node with current less then the the new title
                previous = current;
                current = current.getNext();	
            }
            
            //If current is the first movie in the list, and its title is larger than that of 
            //the new movie to be inserted, make the new movie the new head, and point its node to current
            if(head == current && (current.getData().getName().compareToIgnoreCase(title) > 0))
            {
                head= newNode;
                newNode.setNext(current);
            }
            //The the movie after current is null (we have reached the end of the list without finding a movie 
            //whos title is less than that of our new movie, add that movie to the end of the linked list
            else if(current.getNext() == null && (current.getData().getName().compareToIgnoreCase(title) < 0))
            {
                current.setNext(newNode);
            }
            
            //If our current movie is not null and out previous movie is not null(our current movie position
            //is between two other nodes) then insert the movie between two nodes by setting the previous movies
            //next node to our new node and our new nodes next movie to the movie in the current position.
            else if(current != null && previous != null)
            {
                newNode.setNext(current);	
                previous.setNext(newNode);
            }
        }     
        in.nextLine();	
    }
        
    /**
     *remove() is used when the user wants to remove specific movies from their
     * collection. If the list is empty, the user is informed that there is nothing
     * to remove, other wise, a call to removeNonempty() is made to remove movies in
     * all other positions.
     */
    public void remove()
    {
        if( head == null)
            System.out.println("List is already empty: Nothing to remove");
        else
        {
            removeNonempty();
        }
    }

    /**
     *removeNonEmpty() prompts the user for the name of the movie to remove. The program then searches
     * for and removes the first instance of that movie (case insensitive search). An appropriate status
     * message should be displayed if no matches were found.
     */
    public void removeNonempty()
    {
        //All attributes required to remove the first instance of a movie
        MovieNode previous = null;
        MovieNode current = head;
        String searchName = null;
        boolean isFound = false;
        String currentName;
        //Prompts the user for the title of the movie to be removed
        System.out.println("Enter name of the movie to remove: ");
        searchName = in.nextLine();
        //As long as current is not null(we have not reached the end of the list)
        //and the movie we are searching for has not been found, keep searching through
        //the list until it is found or we reach the end.
        while((current != null) && (isFound == false))
        {
            //Get the name of the movie in the current position
            currentName = current.getData().getName();
            //If the searched name is equivalent to that of current
            if(searchName.compareToIgnoreCase(currentName) == 0)
                //Mark that the movie has been found, stop searching
                isFound = true;
            //Otherwise keep searching though the list
            else 
            {
                previous = current;
                current = current.getNext();
            }
            
            //when the movie is found, inform the user that the movie is being removed
            if(isFound == true)
            {
                System.out.println("Removing movie called " + searchName);
                
            }
            
            //If the previous node is null(we are at the head) then remove the
            //head by setting the head to the next movie
            if(previous == null)
                head = head.getNext();
            //Otherwise set previous's next node to currents next node, thus removing
            //current from the list
            else 
                previous.setNext(current.getNext());
        }
        
        
    }
    
    /**
     * search() allows the user to type in the name of the movie (case insensitive)
     * to see full information about that movie.  If the list is empty then the program 
     * informs the user of this fact and no search is to be performed.  If the movie is
     * not in the list, then the program indicates that the movie could not be found under
     * that name. If the movie is in the list, then the program displays additional 
     * details about that movie (all the fields of that movie will be displayed onscreen).
     */
    public void search()
    {
        //All attributes requires to search for a movie
        int num = 1;
        MovieNode previous = null;
        MovieNode current = head;
        String searchMovie = null;
        boolean isFound = false;
        String currentMovie = null;
        //Prompt the user for the name of the movie they would like the search for
        System.out.print("Enter the name of the movie to be searched: ");
        searchMovie = in.nextLine();
        //While we haven't reached the end of the least and while we have not found the
        //movie that we are searching for, keep searching through the list until one of the
        //conditions of loop is made false
        while((current != null) && (isFound == false))
        {
            //get name of the movie in the current position
            currentMovie = (current.getData()).getName();
            //If we have found the movie, mark that the movie has been found
            if (searchMovie.compareToIgnoreCase(currentMovie) == 0)
            {
                isFound = true; // Match found
            }
            else // No match: move onto next node
            {
                previous = current;
                current = current.getNext();
                num = num + 1;
            }
        }
        //If we have located the movie, display all of its data
        if (isFound == true)
        {
            System.out.println("\t#" + num + ": "+ current.getData());
        }
        //Otherwise, notify the user that their movie does not exist
        else
        {
            System.out.println("No movie called " + searchMovie + " in the collection.");
        }
    }
    
    /**
     *display() displays each movie in alphabetical order when the user calls the method.
     * Each movie is separated onscreen by a line of stars.  When the list of movies is long,
     * to prevent the output from scrolling off the screen the program 'pauses' the display 
     * of movies every 4th movie while it waits for the user to 'Hit enter to continue'.  The
     * output is be displayed in a neat and legible format, consisting of title, 3 cast members,
     * genre, and the users rating, all on separate lines and by a line of stars. The program
     * displays an appropriate status message if the list is empty
     */
    public void display()
    {
        //Counters for name and tracking every fourth movie
        int count = 1;
        int num = 0;
        //begin at the beginning of the list
        MovieNode temp = head;
        //Print header and a row of stars
        System.out.println(LIST_HEADER);
        for(int i = 0; i < LIST_HEADER.length(); i++)
        {
            System.out.print("*");
        }
        System.out.println();
        //If list is empty, notify the user that there is nothing to display
        if(temp == null)
            System.out.println("List is empty: nothing to display");
        //If the list is not empty, iterate through the list and display all
        //the data of every movie
        while(temp != null)
        {
            System.out.println("#" + count + ": " + temp);
            temp = temp.getNext();
            count = count + 1;
            num = num + 1;
            //After every movie display a row of stars to seperate the previous
            //movie from the next
            for(int i = 0; i < LIST_HEADER.length(); i++)
            {
                System.out.print("*");
            }
            System.out.println();
            //If we have reached the fourth movie in the list, prompt the user to
            //hit enter to continue viewing movies
            if(num == 4)
            {
                System.out.print("Hit enter to see more movies: ");
                in.nextLine();
                num = 0;
            }            
        }
        System.out.println();
        
    }
  
    
}

