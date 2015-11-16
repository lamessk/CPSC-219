/*Lamess Kharfan Student Number: 10150607
CPSC 219 Mini Assignment 2
*/

public class Cats 
{
    //Attributes for name and string created 
    public String name;
    public String favouriteFood;
 


    //Cat that has default values for name and favourite food
    public Cats() 
    { 
      name = "unknown Kitty";
      favouriteFood = "Nothing! >.<";
    }


    //Method makeSound() prints "meow" when called
    public void makeSound()
    {
      String sound;
      sound = "Meow!";
      System.out.println(sound);
     }
    
    //Method getName() returns the name of Cat when called
    public String getName() 
    {
      return name;
    }

    //Method getFood() returns the Cat's favourite food when called 
    public String getFood()
    {
      return favouriteFood;
    }

    //Method setName() uses a setter to change the default name of the cat to 
    //a new name, takes in a string that is the new name
    public void setName(String newName)
    {
      name = newName;
    }

    //Method setFood() uses a setter to change the defule favourite food of
    //the cat to a new favourite food , takes in a string that is the new food
    public void setFood(String newFood)
    {
      favouriteFood = newFood;
    }


}
