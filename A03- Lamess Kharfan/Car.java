/*
Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 3. Race Tracks. Version 1.
Each car is represented by a single character. The basic car is shown as a 'c'.
Individual cars have a fixed amount of fuel (40) that is consumed at a fixed consumption
rate (2), allowing it to move a standard distance (2). If the fuel has been totally 
expended (zero or less) then the car can no longer move. All cars display its current
state during a turn: current fuel, consumption rate and distance traveled for that turn. If the 
car is driving under extraordinary circumstances e.g., an SUV driving in non-AWD mode and consuming
fuel without moving during a blizzard then the actual movement and actual fuel consumption information
for that turn should be displayed.
*/
public class Car
{
    public static final int STARTING_FUEL = 40;
    public static final int STANDARD_DISTANCE = 2;
    public static final int CONSUMPTION_RATE = 2;

    private char appearance;
    private int fuel;

    public Car()
    {
	setAppearance('c');
	fuel = STARTING_FUEL;
    }

    // As the car moves, this class or child classes can specify for that type of car
    // how much fuel to consume.
    protected void consumeFuel(int amount)
    {
	if (amount < 0)
	    fuel = 0;
	else
	    fuel = fuel - amount;
    }

    public int getFuel()
    {
	return fuel;
    }

    // Allows external queries of the fuel state of a particular car.
    public boolean isEmpty()
    {
	if (fuel <= 0)
	    return true;
	else
	    return false;
    }

    // Car internally knows how much fuel to use and how far to move. However the 
    // actual movement in the virtual track must be done by another class hence
    // this method must communicate to the caller how far it moves.


    // If this method is overriden then all child class methods must also display
    // the same debugging messages shown below.
    
    
    public int move ()
    {
	consumeFuel(CONSUMPTION_RATE);
	System.out.println("Current fuel: " + fuel);
	System.out.println("Fuel use: " + CONSUMPTION_RATE);
	System.out.println("Distance traveled: " + STANDARD_DISTANCE);
	return STANDARD_DISTANCE;
    }

    public void setAppearance (char anAppearance)
    {
	appearance = anAppearance;
    }

    public void setFuel (int newFuel)
    {
	if (fuel < 0)
	    System.out.println("Fuel cannot be set to a negative value");
	else
	    fuel = newFuel;
    }

    public String toString() 
    {
	String s = "";
	s = s + appearance;
	return s;
    }
}
