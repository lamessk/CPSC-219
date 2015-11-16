/*

Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 3. Race Tracks. Version 1. 
 A racing simulation with two separate driving tracks: arctic and desert. For this version 
of the program the arctic track contains an SUV (Sport Utility Vehicle) and the desert track 
contains a sports car. Each car will try to reach the end of its respective track without running 
out of fuel and prior to the other car. If either or both cars reach the end of the 
track then the simulation ends: draw (if both reach it during the same turn), win (for the car that
reached it first), and loss (for the car that didn't reach it first). If one car runs out of fuel 
then the simulation continues until: both cars run out fuel (tie) or the other car reaches the end 
(win for that car). The simulation is also a 'draw' if the user quits the program early.
There is a random chance of a weather event occurring in each track. The arctic track can have a blizzard
that prevents non-AWD (All Wheel Drive) movement (but doesn't stop the expenditure of fuel) while the desert 
track can be hit with a heat wave that can cause sports cars to overheat and double the fuel consumption rate 
(movement distance is unchanged). Finally the simulation allows for a 'cheat' option. For testing
purposes: debugging messages can be toggled on/off, the fuel level of either car can be manually set, a car can
be manually moved to any location within its current track, a weather event can be invoked in the other track 
(meant to hinder the other car so the cheat option shouldn't work on one's own track. Because the weather event 
for a track is determined immediately after the user's choice for that track, the user's option for causing a
weather event in their own track will be ignored. Sabotage your own track will be canceled out by the random 
occurrence of weather events.
Program Limitations: Cannot error check for proper input from the user for SUV menu and Sports Car Menu. 
User input must be of form String, Track is only of size 24. 


Class Driver() is the starting execution point of the program. Instantiates the GameController and runs all the events.

  Author:  James Tam
  Version: April 1, 2013

  Starting execution point.



*/

public class Driver
{
    public static void main(String [] args)
    {
        //New track
        Track aTrack = new Track();
        //Instantiate GameController
        GameController aGame = new GameController();
        aGame.runTurn();
    }
}
