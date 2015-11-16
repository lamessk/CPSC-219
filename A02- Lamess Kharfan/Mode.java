/*
Lamess Kharfan. Student number: 10150607. CPSC 219 Assignment 2.T04. Game of Life. Version 1. 
Determine if the program is operating in debugging mode. By default the program will not be
operating in debugging mode. When the program is in debugging mode, messages about the state
of the program will be displayed.


  Author:  James Tam
  Version: September 22, 2003 (minor mods on Feb 2015)

  A class that you can use to debug your program.  Copy it into the directory 
  that contains the classes of your program and you can access the static 
  variable anywhere in that program.  Anytime that you want to have debugging
  output statements to appear set "on" to true.  When you want to shut off 
  the debugging messages just set "on" to false.

 */
public class Mode
{
    // Default: False that debugging messages appear
    public static boolean debug = false;
    
    //If the user wants debug mode to be on, change value of debug to be true
    //in order to run debug mode
    public static boolean debugOn()
    {
        debug = true;
        System.out.println("Debug Mode On");
        return debug;
    }
    
    //Default value of debug. If the user chooses to turn off debug mode, set 
    //debug to false to turn off. 
    public static boolean debugOff()
    {
        debug = false;
        System.out.println("Debug Mode Off");
        return debug;
    }
    
}
