import java.util.Random;
/*
Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 3. Race Tracks. Version 1.
ArticTrack() is A child of class of Track with the additional ability to generate a blizzard. 
A car traveling during a blizzard will be stuck (not move forward and just "spin 
its wheels") yet still expend fuel amounts appropriate to the type of car and driving 
mode (if applicable). The exceptionis an SUV traveling in AWD mode.
Each turn there's a 10% chance of a blizzard occurring, otherwise the driving conditions will be normal.
*/
public class ArcticTrack extends Track 
{
    //Attributes for class ArticTrack
    public int blizzard;
    public int position;
    
    //Instantiate a track
    Car [] Tracka = getTrack();
    
    //Display the artic track
    public void displayArctic()
    {
        System.out.println("ARCTIC TRACK");
        display();
    }
    
        /**
     *Blizzard() invokes a blizzard on the arctic track decreases the Standard 
     * distance to 0 if the car is in normal driving mode and to 1 in the car is
     * in AWD mode. Fuel consumption is unaffected in both cases. A blizzard occurs 
     * randomly and approximately 10% of the turns. 
     */
    Random generator = new Random();
    
    public int Blizzard(char mode)
    {
        //If the SUV is in cheat mode, do not move the car or consume fuel
        //Turn has been used to cheat
        if(mode == 'c' || mode == 'C')
        {
            SUV.STANDARD_DISTANCE = 0;
            SUV.CONSUMPTION_RATE = 0;
        }
        //If user has not invoked a blizzard
        else if(blizzard != 1)
        {
            //Create a 10% chance of a blizzard occuring
            blizzard = generator.nextInt(10);
            //If the number is 1, then a blizzard will occur
            if(blizzard == 1)
            {
                //Display message announcing a blizzard
                System.out.println("A blizzard has struck the arctic track");
                //If SUV is in AWD mode, move car at distance 1 and consume normal fuel
                if (mode =='a' || mode == 'A')
                {     
                    //If in AWD mode. move at distance 1. still consumes fuel 
                    SUV.STANDARD_DISTANCE = 1;
                    SUV.CONSUMPTION_RATE = 3;
                    System.out.println("Blizzard hits but SUV moves slowly but surely");
                }
       
                //if car is in normal driving mode, standard distance is 0 and consume normal amount of fuel
                else if (mode == 'd' || mode == 'D')
                {
                    //If driving normally, do not move at all, still consume fuel.
                    SUV.STANDARD_DISTANCE = 0;
                    SUV.CONSUMPTION_RATE = 3;
                    System.out.println("Blizzard hits and car spins its wheels");
                }
            }
        
            else
            {
                //otherwise, move fuel normally and consume fuel normally
                SUV.STANDARD_DISTANCE =2;
                SUV.CONSUMPTION_RATE = 3;
            }
        }
        
        //If user has invoked a blizzard, then blizzard is = 1 
        else if(blizzard == 1)
        {
            System.out.println("A blizzard has struck the arctic track!");
                if (mode =='a' || mode == 'A')
                {     
                    //If in AWD mode. move at distance 1. still consumes fuel 
                    SUV.STANDARD_DISTANCE = 1;
                    SUV.CONSUMPTION_RATE = 3;
                    System.out.println("Blizzard hits but SUV moves slowly but surely");
                }
            
                else if (mode == 'd' || mode == 'D')
                {
                    //If driving normally, do not move at all, still consume fuel.
                    SUV.STANDARD_DISTANCE = 0;
                    SUV.CONSUMPTION_RATE = 3;
                    System.out.println("Blizzard hits and car spins its wheels");
                }
        }
        //Otherwise move the car normally. and consume fuel normally
        else 
        {    
            SUV.STANDARD_DISTANCE = 2;
            SUV.CONSUMPTION_RATE = 3;
        }
        //Reset blizzard back to 0, if blizzard is invoked it will be set to 1
        blizzard = 0;
        return blizzard;
    }
    
    
    //blizzardInvoked() is used in the cheats menu for when a user would like to
    //force a blizzard on the arctic track
    public int blizzardInvoked()
    {
        //If user invoked a blizzard, set blizzard to 1
        blizzard = 1;
        return blizzard;
    }
        
      /*   
     *wipe() sets all elements of the track to null so that the 
     * previous position of the sUV car is erased from the track
     * so that the new one can be displayed.
     */
    public void wipe()
    {
        int c;
	for (c = 0; c < SIZE; c++)
	    Tracka[c] = null;
    }
    
    
    /**
     *advance() moves the SUV car forward on the track and keeps track
     * of the position of the SUV car so it may be moved
     * forward from the previous position in the previous turn.
     * @param distance - how far the car will move
     * @return position returns the current position of the SUV car.
     */
    
    public int advance(int distance)
    {
        //int distance = SUV.STANDARD_DISTANCE;
        position = position + distance;
        return position;
    }
    /**
     *setPosition() moves the SUV car to a certain position in the array, useful
     * for when the user uses a cheat to move the SUV car to a specific 
     * location.
     * @param location - where the user would like the SUV car to be placed
     * @return position - where the SUV car will be placed.
     */
        
        public int setPosition(int location)
        {
            position = location;
            return position;
        }
      /**
     *getPosition tells us the current position of the SUV car
     * @return position - the position of the SUV car
     */
        public int getPosition()
        {
            return position;
        }
    
}

