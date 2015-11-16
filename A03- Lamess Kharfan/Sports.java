/*
Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 3. Race Tracks. Version 1.
Sports() is a child of class Car that has a different appearance ('P') with 
a standard fuel consumption rate of 2 units but the ability to move 3 distance 
units. To keep the car lighter (and faster) the fuel tank capacity is only 30 units.
Normally a sports car has an efficient cooling system but if there is a heat 
wave, a sports car will overheat and consume fuel at double the normal rate (move 
distance is unchanged). The car will remain overheated only so long 
as the heat wave lasts e.g., if there is a heat wave during the current turn but not the
next then the car will only remain overheated for only one turn.
*/
public class Sports extends Car {
    
    //Standard distance for the sports car
    public static int STANDARD_DISTANCE = 3;
    //Standard consumption rate of fuel of the sports car
    public static int CONSUMPTION_RATE = 2; 
    //The amount of fuel that the Sports Car will start with
    public int MAX_FUEL = 30;

    //Set appearance of sports car and set fuel to starting fuel
    public Sports()
    {
	setAppearance('P');
        setFuel(MAX_FUEL);
    }
    /*
     *move() moves the car by decreasing th amount of fuel in the cars tank, 
     * moving car the standard distance, and returning the distance travelled. 
     * gives the user stats about how far the car has moved, how much fuel was 
     * used, and what the current fuel in the tank is. 
    */
    public int move ()
    {
        //Check is Sports car is out of fuel
        boolean sportEmpty = isEmpty();
        //As long as the sports car still has fuel, display movement stats.
        if(sportEmpty == false)
        {
            consumeFuel(CONSUMPTION_RATE);
            System.out.println("Current fuel: " + getFuel());
            System.out.println("Fuel use: " + CONSUMPTION_RATE);
            System.out.println("Distance traveled: " + STANDARD_DISTANCE);
        }

        //Return how far the car has moved.
        return STANDARD_DISTANCE;
    }
    
}

