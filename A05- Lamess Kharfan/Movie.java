/**
 * Lamess Kharfan. T04. Student Number: 10150607.CPSC 219. Assignment 5. Movie Collection. Version 1.
 *Class Movie() contains all information about movies in the list, including title,
 * names of three cast members,   the genre of the movie, and the users rating of 
 * the movie. Name is a string, cast members names are stored into an array, genre
 * is a String that can only be one of 6 specific genres and stars(rating) is an 
 * integer between 1 and 5. Getters and setters are available to get and set the 
 * name of a movie. ToString method available to display all data for movies in String form.
 */
public class Movie {
    //Attributes associated with all movies
    public String mName;
    public String [] castNames; 
    public String genre;
    public int stars;
    
    //Creates a movie, using name, cast members name, genrem and rating
    public Movie(String aName, String c1, String c2, String c3, String gen, int star) 
    {
        this.castNames = new String[3];
        mName = aName;
        castNames[0] = c1;
        castNames[1] = c2;
        castNames[2] = c3;
        genre = gen;
        stars = star;
    }
    //getName() allows user to retieve the name of the movie the are looking at
    public String getName()
    {
        return mName;
    }
    
    //setName() is used to set the name of a Movie
    public void setName(String aName)
    {
        mName = aName;
    }
    //To string displays movies in string form, and includes
    //all data concerning a particular movie. As long as a
    //movies name is not null, the movie is converted to string form.
    public String toString()
    {
        String temp;
        if(mName != null)
        {
            temp = "" + mName;
            temp = temp + "\n " + castNames[0];
            temp = temp + "\n " + castNames[1];
            temp = temp + "\n " + castNames[2];
            temp = temp + "\n " + genre;
            temp = temp + "\n " + stars;
            
        }
        else 
            temp = " \t Movie Name: No-name";
        return (temp);
    }
    
    
}

