/*Lamess Kharfan Student Number: 10150607
CPSC 219 Mini Assignment 2
*/

public class Dogs 
{

    //Attributes for name and favourite food creates. An array with 2 elements
    //for favouriteFood
    public String name;
    public String [] favouriteFood = new String [2];
    
    //Dog's default name and favourite foods 
    public Dogs()
    {
      name = "No Name Puppy";
      favouriteFood[0] = "Dog Food";
      favouriteFood[1] = "Your Food";        
    }
                
    //getName() allows the other classes to retrieve Dog's Name
    public String getName() 
    {
      return name;
    }
    //getFood allows() the other classes to retrieve Dog's food
    public String [] getFood()
    {
      return favouriteFood;	
    }

}


