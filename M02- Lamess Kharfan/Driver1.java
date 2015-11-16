/*Lamess Kharfan Student Number: 10150607
CPSC 219 Mini Assignment 2
Ther Driver1 class uses the Cat and Dog class to create instances of a cat and
a dog and displays and changes their names and favourite foods using methods
such as setters and getters
*/


public class Driver1 
{
 public static void main(String[] args)
  {
	//Instances of a dog and a cat are created
	Cats aCat = new Cats();
	Dogs aDog = new Dogs();
	
	// Displays the default name and favourite food of the cat
	System.out.println("Cat's name: " + aCat.getName());
	System.out.println("Cat's favourite food: " + aCat.getFood());
	
	//Displays the default name and favourite food of the dog
	System.out.println("Dog's name: " + aDog.getName());
	System.out.println("Dog's favourite food: " + aDog.getFood()[0] + " and " + aDog.getFood()[1]);
	
	//Uses the setter setName() from the Cats class to change the name of the cat
	//Uses the setter setFood() from the Cats class to change the cats food
        aCat.setName("Sylvester");
	aCat.setFood("Catnip");
	
	//Displays the cat's new name and favourite food. 
        System.out.println("Cat's new name: " + aCat.getName());
	System.out.println("Cats new favourite food : " + aCat.getFood());
	aCat.makeSound();

        
    }
    
}

