/*
Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 3. Race Tracks. Version 1.
SUV() is a child of class Car that has a different appearance ('V') and different movement
options: under normal driving mode the distance traveled is still the default rate 
of 2 but fuel consumption is 3 units, under AWD mode the car can still move when 
there is a blizzard albeit at a reduce speed. The fuel tank is larger with a capacity of 50 units.
 */


public class SUV extends Car {
    //Standard consumption rate of the SUV
    public static int CONSUMPTION_RATE = 3;
    //Standard distance the SUV car moves.
    public static int STANDARD_DISTANCE = 2;
    //The amount of fuel the SUV will normally start out with.
    public int maxfuel = 50;

    //Set appearance of SUV car and set fuel to starting fuel
    public SUV()
    {
	setAppearance('V');
	setFuel(maxfuel);
    }
   
    /*
     *move() moves the car by decreasing th amount of fuel in the cars tank, 
     * moving car the standard distance, and returning the distance travelled. 
     * gives the user stats about how far the car has moved, how much fuel was 
     * used, and what the current fuel in the tank is. 
    */
    
    public int move ()
    {
        //check if the car is out of fuel
        boolean SUVempty = isEmpty();
        //if fuel is still available then display stats and move the car
        if(SUVempty == false)
        {
            consumeFuel(CONSUMPTION_RATE);
            System.out.println("Current fuel: " + getFuel());
            System.out.println("Fuel use: " + CONSUMPTION_RATE);
            System.out.println("Distance traveled: " + STANDARD_DISTANCE);
        }
        //return how far the car has moved.
        return STANDARD_DISTANCE;
    }
}
