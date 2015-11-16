/*
  Author:  James Tam
  Version: April 1, 2013

Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 3. Race Tracks. Version 1.

  The sole purpose of this class is track if the program is in debugging mode.

 */
public class Debug
{
    
    public static boolean on = false;
    //If the user wants debug mode to be on, change value of debug to be true
    //in order to run debug mode
    public static boolean debugOn()
    {
        on = true;
        System.out.println("Debug Mode On");
        return on;
    }
    
    //Default value of debug. If the user chooses to turn off debug mode, set 
    //debug to false to turn off. 
    public static boolean debugOff()
    {
        on = false;
        System.out.println("Debug Mode Off");
        return on;
    }
    
}

