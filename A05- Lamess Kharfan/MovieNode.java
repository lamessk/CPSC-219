/**
 * Lamess Kharfan.Student Number: 10150607. T04. CPSC 219. Assignment 5. Movie Collection. Version 1.
 *class MovieNode() is a class with two fields: a) 'Data' which is of type 'Movie' 
 * b) 'Next' which is a reference to a MovieNode (next node in the list or null for 
 * the end of the list).
 */
public class MovieNode {
    
    private Movie data;
    private MovieNode next;
    
    //MovieNode() has the ability to set data and set the next node in the list
    public MovieNode()
    {
        setData(null);
        setNext(null);
    }
    //Uses all the movie from a to create a movie and then set the next movie.
    public MovieNode(Movie someData, MovieNode nextNode)
    {
        setData(someData);
        setNext(nextNode);
    }
    //Get data returns all th data of a movie
    public Movie getData()
    {
        return(data);
    }
    //Get next() returns the next movie in the list
    public MovieNode getNext()
    {
        return(next);
    }
    //setData() sets all of the data in a movie 
    public void setData(Movie someData)
    {
        data = someData;
    }
    //setNext() sets the next node to the one specified by the user
    public void setNext(MovieNode nextNode)
    {
        next = nextNode;
    }
    //toString gives a string representation of data
    public String toString(){
        return(data.toString());
    }
    
}
