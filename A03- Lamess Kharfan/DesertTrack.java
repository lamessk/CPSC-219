import java.util.Random;

/*
Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 3. Race Tracks. Version 1.
DesertTrack() is A child of class of Track with the additional ability to generate
a heat wave. A sports car traveling during a heat wave will overheat. Overheating
causes the sports cars fuel consumption to double. Each turn there's a 10% 
chance of a heat wave occurring, otherwise temperature will be normal.
*/
public class DesertTrack extends Track 
{
    //Attributes of the class
    public int heatWave;
    public int position;
    
    Random generator = new Random();
    
    //Instantiation of an array
    Car dTrack [] = getTrack();
    
    /**
     *displayDesert() displays the desert track
     */
    public void displayDesert()
    {
        System.out.println("DESERT TRACK");
        display();
    }
    
    /**
     *HeatWave() invokes a heat wave on he desert track and increases the rate
     * of fuel consumption to 4 units. But standard distance is unaffected. A heat 
     * wave occurs randomly and approximately 10% of the turns. 
     */
    public int HeatWave(char mode)
    {
        //If user is in cheat mode, do not move car or consume fuel
        if(mode == 'C' || mode == 'c')
        {
            Sports.CONSUMPTION_RATE = 0;
            Sports.STANDARD_DISTANCE = 0;
        }
        //If the user has not invoked a heat wave
        else if (heatWave != 1)
        {
            //Create a 10% chance of the heat wave occuring
            heatWave = generator.nextInt(10);
            //If a heatwave is occuring, consume double the fuel
            if(heatWave == 1)
            {
                Sports.CONSUMPTION_RATE = 4;
                Sports.STANDARD_DISTANCE = 3;
                System.out.println("A heatwave hammers the desert track");
            }
            //otherwise, move the car normally, consume normal fuel
            else
            {
                Sports.CONSUMPTION_RATE = 2;
                Sports.STANDARD_DISTANCE = 3;
            }
        }
        //check if a user has invoked a heatwave
        else if (heatWave == 1)
        {
            //If a heatwave has been invoked consume double the fuel, move normal distance
            System.out.println("A heatwave hammers the dessert track!");
            Sports.CONSUMPTION_RATE = 4;
            Sports.STANDARD_DISTANCE = 3;
        }
        //Otherwise, move and consume fuel normally
        else
        {
            Sports.CONSUMPTION_RATE = 2;
            Sports.STANDARD_DISTANCE = 3;
        }
        //Reset heatwave value to 0
        heatWave  = 0;
        return heatWave;
    }
    
    /**
     *If user chooses to invoke a heat wave on the desert track via the cheats
     * menu, probability of a heat wave is 100%
     * Sports car consumes fuel at a rate of 4 units.
     */
    public int HeatWaveInvoked()
    {
        //Make heatwave = 1
        heatWave = 1;
        return heatWave;
    }
    
    /**
     *wipe() sets all elements of the track to null so that the 
     * previous position of the sports car is erased from the track
     * so that the new one can be displayed.
     */
    public void wipe()
    {
        int c;
	for (c = 0; c < SIZE; c++)
	    dTrack[c] = null;
    }
    
    /**
     *advance() moves the sports car forward on the track and keeps track
     * of the position of the sports car in the car so it may be moved
     * forward from the previous position in the previous turn.
     * @return position returns the current position of the sports car.
     */
    public int advance()
    {
        int howFar = Sports.STANDARD_DISTANCE;
        position = position + howFar;
        return position;
    }
        
    /**
     *setPosition() moves the sports car to a certain position in the array, useful
     * for when the user uses a cheat to move the sports car to a specific 
     * location.
     * @param location - where the user would like the sports car to be placed
     * @return position - where the sports car will be placed.
     */
    public int setPosition(int location)
     {
        position = location;
        return position;
    }
        
    /**
     *getPosition tells us the current position of the sports car
     * @return position - the position of the sports car
     */
    public int getPosition()
    {
        return position;
    }
        
}

