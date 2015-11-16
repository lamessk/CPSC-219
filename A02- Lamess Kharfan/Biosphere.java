/*Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 2. Game Of Life . Version 1. 
Class Biosphere stores information about the simulated world.Takes the form of an 
array of references to Critter objects. Regulates maintenance of the biosphere: 
scanning the squares in order to determine where Critters will be born and where 
they will die.  Broken down into main tasks and sub-methods. The main job of scanning 
the biosphere is broken down into smaller jobs such: i) scanning the inner parts of the
biosphere (rows 1 - 8 and columns 1- 8: 64 squares) ii) scanning the top row only (row=0)
iii) scanning the bottom row (row=9) iv) scanning the left-most column (column=0) 
v) scanning the right-most column (column=9) vi) scanning the four corners. After scanning,
determine where critters will be born or which critters die based on critters surrounding it
the area in previous array. Copy that information into the current array. 
*/


public class Biosphere
{
    //Create attrubutes associates with the class that are accosiated with every object
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;
    public static final int MIN_ROW = 0;
    public static final int MAX_ROW = 9;
    public static final int MIN_COLUMN = 0;
    public static final int MAX_COLUMN = 9;
    public static final String HORIZONTAL_LINE = "  - - - - - - - - - -";
    public static final String HORIZONTAL_COUNT = "  0 1 2 3 4 5 6 7 8 9 ";

    //create two 2D arrays. One for previous one for current
    private Critter [][] previous;
    private Critter [][] current; 
    private int generation;
    
    //Create a biosphere
    public Biosphere ()
    {
        int r;
        int c;
        generation = 0;
        previous = new Critter [ROWS][COLUMNS];
        current = new Critter [ROWS][COLUMNS]; 
        for (r = 0; r < ROWS; r++)
        {
            for (c = 0; c < COLUMNS; c++)
            {
                //Create previous and current biospheres
                previous[r][c] = new Critter(Critter.EMPTY);
                current[r][c] = new Critter(Critter.EMPTY);
            }
        }
      }

    
    //Based on user input in class UserInteface, initialize previous to a certain
    //bioshpere type.
    public void initialize (int sphereType)
    {
        switch (sphereType)
        {
            case 1:
                initializeCase1 ();
                break;

            case 2:
                initializeCase2 ();
                break;

            case 3:
                initializeCase3();
                break;
    
            case 4:
                initializeCase4 ();
                break;
	    
            case 5:
              initializeCase5();
              break;

            case 6:
                initializeCase6 ();
                break;
           
            case 7:
                initializeCase7 ();
                break;

            case 8:
                initializeCase8 ();
                break;
        }
    }
    
    // Completely empty
    private void initializeCase1 ()
    {
        int r;
        int c;
        for (r = 0; r < ROWS; r++)
        {
            for (c = 0; c < COLUMNS; c++)
            {
                previous[r][c] = new Critter(Critter.EMPTY);
                current[r][c] = new Critter(Critter.EMPTY);
            }
        }
    }

    // Single critter
    private void initializeCase2 ()
    {
        int r;
        int c;
        for (r = 0; r < ROWS; r++)
        {
        for (c = 0; c < COLUMNS; c++)
        {
            previous[r][c] = new Critter(Critter.EMPTY);
            current[r][c] = new Critter(Critter.EMPTY);
        }
    }
    previous[MIN_ROW][MIN_COLUMN] = new Critter(Critter.REGULAR);
    current[MIN_ROW][MIN_COLUMN] = new Critter(Critter.REGULAR);	
    }

    // Single birth (3 critters)
    private void initializeCase3 ()
    {
        int r;
        int c;
        for (r = 0; r < ROWS; r++)
        {
        for (c = 0; c < COLUMNS; c++)
        {
            previous[r][c] = new Critter(' ');
            current[r][c] = new Critter (' ');
        }
        }
        current[1][1] = new Critter('*');
        previous[1][1] = new Critter('*');
        current[2][3] = new Critter('*');
        previous[2][3] = new Critter('*');
        current[3][1] = new Critter('*');
        previous[3][1] = new Critter('*');
    }
    
    // Simple pattern in middle
    private void initializeCase4 ()
    {
        int r;
        int c;
        for (r = 0; r < ROWS; r++)
        {
            for (c = 0; c < COLUMNS; c++)
            {
                previous[r][c] = new Critter(Critter.EMPTY);
                current[r][c] = new Critter(Critter.EMPTY);
            }
        }
    previous[1][1] = new Critter(Critter.REGULAR);
    current[1][1] = new Critter(Critter.REGULAR);	
    previous[2][3] = new Critter(Critter.REGULAR);
    current[2][3] = new Critter(Critter.REGULAR);
    previous[2][2] = new Critter(Critter.REGULAR);
    current[2][2] = new Critter(Critter.REGULAR);			
    previous[3][1] = new Critter(Critter.REGULAR);
    current[3][1] = new Critter(Critter.REGULAR);	
    previous[3][3] = new Critter(Critter.REGULAR);
    current[3][3] = new Critter(Critter.REGULAR);
    }

    // Pattern near edges
    private void initializeCase5 ()
    {
        int r;
        int c;
        for (r = 0; r < ROWS; r++)
        {
            for (c = 0; c < COLUMNS; c++)
            {
                previous[r][c] = new Critter(Critter.EMPTY);
                current[r][c] = new Critter(Critter.EMPTY);
            }
        }
        previous[MIN_ROW][MIN_COLUMN] = new Critter(Critter.REGULAR);
        current[MIN_ROW][MIN_COLUMN] = new Critter(Critter.REGULAR);
        previous[MIN_ROW][MAX_COLUMN] = new Critter(Critter.REGULAR);
        current[MIN_ROW][MAX_COLUMN] = new Critter(Critter.REGULAR);	
        previous[MAX_ROW][MIN_COLUMN] = new Critter(Critter.REGULAR);
        current[MAX_ROW][MIN_COLUMN] = new Critter(Critter.REGULAR);	
        previous[MAX_ROW][MAX_COLUMN] = new Critter(Critter.REGULAR);
        current[MAX_ROW][MAX_COLUMN] = new Critter(Critter.REGULAR);	
        previous[0][2] = new Critter(Critter.REGULAR);
        current[0][2] = new Critter(Critter.REGULAR);	
        previous[2][1] = new Critter(Critter.REGULAR);
        current[2][1] = new Critter(Critter.REGULAR);	
    }

    //Fertile Critter
    private void initializeCase6 ()
    {
        int r;
        int c;
        for (r = 0; r < ROWS; r++)
        {
            for (c = 0; c < COLUMNS; c++)
            {
                previous[r][c] = new Critter(Critter.EMPTY);
                current[r][c] = new Critter(Critter.EMPTY);
            }
            previous[2][MIN_COLUMN] = new Critter(Critter.FERTILE);
            current[2][MIN_COLUMN] = new Critter(Critter.FERTILE);	    
            previous[1][1] = new Critter(Critter.REGULAR);
            current[1][1] = new Critter(Critter.REGULAR);	    
            previous[4][1] = new Critter(Critter.FERTILE);
            current[4][1] = new Critter(Critter.FERTILE);	    
        }
    }

    // Complex pattern, no fertile critters
    private void initializeCase7 ()
    {
        int r;
        int c;
        for (r = 0; r < ROWS; r++)
        {
            for (c = 0; c < COLUMNS; c++)
            {
                previous[r][c] = new Critter(Critter.EMPTY);
                current[r][c] = new Critter(Critter.EMPTY);
            }
        }
        current[1][4] = new Critter ('*');
        previous[1][4] = new Critter ('*');
        current[2][5] = new Critter ('*');
        previous[2][5] = new Critter ('*');
        current[3][3] = new Critter ('*');
        previous[3][3] = new Critter ('*');
        current[3][4] = new Critter ('*');
        previous[3][4] = new Critter ('*');
        current[3][5] = new Critter ('*');
        previous[3][5] = new Critter ('*');
    }

    // Complex pattern, with fertile critters
    private void initializeCase8 ()
    {
        int r;
        int c;
        for (r = 0; r < ROWS; r++)
        {
            for (c = 0; c < COLUMNS; c++)
            {
                previous[r][c] = new Critter(Critter.EMPTY);
                current[r][c] = new Critter(Critter.EMPTY);
            }
        }
        current[2][2]= new Critter (Critter.FERTILE);
        previous[2][2] = new Critter (Critter.FERTILE);
        current[2][3] = new Critter (Critter.REGULAR);
        previous[2][3] = new Critter (Critter.REGULAR);
        current[2][4] = new Critter (Critter.FERTILE);
        previous[2][4] = new Critter (Critter.FERTILE);
        current[4][1] = new Critter (Critter.REGULAR);
        previous[4][1] = new Critter (Critter.REGULAR);
    }

    //Display the previous and current arrays side by side. 
    private void display ()
    {
        int r;
        int c;
        System.out.println("\t\tGeneration: " + generation);
        System.out.println("  PREVIOUS GENERATION" + "\t   CURRENT GENERATION");
        System.out.println(HORIZONTAL_COUNT + " \t " + HORIZONTAL_COUNT);
        for (r = 0; r < ROWS; r++)
        {
        System.out.println(HORIZONTAL_LINE + " \t " + HORIZONTAL_LINE);
        System.out.print(r + "|");
        for (c = 0; c < COLUMNS; c++)
        {
            previous[r][c].display();
            System.out.print('|');
        }
        System.out.print("\t" + r);
        System.out.print(" |");
        for (c = 0; c < COLUMNS; c++)
        {
            current[r][c].display();
            System.out.print('|');
        }
        System.out.println();
    }
    System.out.println(HORIZONTAL_LINE + " \t " + HORIZONTAL_LINE);
    generation++;
    }

    public void runTurn ()
    {
        // You could make display and call it outside the class methods.
        // But all the actions needed during a turn e.g., copy from one array
        // to another etc should not be done outside of this class.
        display();
    }
    
   
    
    public void debugON(int i, int j, int bCount)
    {
        System.out.println("Checking births... " + i +" " + j + " " + bCount);
    }
    
    /**
     *checkRight() is specialized to check all of the squares in the right hand 
     * column of the previous array and count critters surrounding every square
     * in the right hand column. Creates a birth and death count for every critter
     * and depending on the count, a critter is born or a critter dies.
     */
    public void checkRight()
    {
        //Initialize attributes associated with all elements of the array
        int birthCritterCounter = 0;
        int deathCritterCounter = 0;
        int i;
        int j = 9;
        char critterAppear;
            
        //While the array in in column 9
        while(j == 9)
        {
            //for rows 1- 8 in column 9
            for (i = 1; i <= 8; i++)           
            {

                
                    //Get appearance of critter to the left(check left)
                   critterAppear = previous[i][j-1].getAppearance();
                   //If it is a regular critter, add one to each count
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   //If it is a fertile critter add 2 to birth count and 1 to death.
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //get appearance of the critter above(check up)
                   critterAppear = previous[i-1][j].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   // get appearance of the critter below (check down)
                   critterAppear = previous[i + 1][j].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //get appearance of the critter above and to the left (check NW)
                   critterAppear = previous[i-1][j-1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //get the appearance of the critter to the left and down(check SW)
                   critterAppear = previous[i+ 1][j - 1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //get appearance of the critter
                   critterAppear = previous[i][j].getAppearance();
                   //If the critter is not an empty square
                   if(critterAppear == Critter.REGULAR || critterAppear == Critter.FERTILE)
                   {
                       //check the count for deaths. 
                       //If the count is greater than 4, the critter dies from overpopulation
                       //If the count is 1 or less then the critter dies of lonliness
                       //Copy this into the current array 
                       if(deathCritterCounter >= 4 || deathCritterCounter <= 1)
                       {
                           current[i][j] = new Critter(Critter.EMPTY);
                       }
                   }
                   
                   
                
                   //If the appearance is empty check if a critter can be born
                   else if(critterAppear == Critter.EMPTY)
                   {
                    //If the birth count is exactly 3, a critter can be born into
                    //the empty square
                    //Copy into current array
                    if(birthCritterCounter == 3)
                    {
                    current[i][j] = new Critter(Critter.REGULAR);
                    }
                }
                    

                //If mode is true, turn on the debug method   
                if(Mode.debug == true)
                    debugON(i, j, birthCritterCounter);
                   
                //Set counts back to zero to be used for another critter
                birthCritterCounter = 0;
                deathCritterCounter = 0;
            
            }
            //when done, break out of the loop
            j++;  
        }
    }
    
        /**
     *checkLeft() is specialized to check all of the squares in the left hand 
     * column of the previous array and count critters surrounding every square
     * in the left column, and in every row. Creates a birth and death count for every 
     * critter and depending on the count, a critter is born or a critter dies.
     * Copy results into the current array
     */
    public void checkLeft()
    {
        int birthCritterCounter =0;
        int deathCritterCounter = 0;
        int i;
        int j = 0;
        char critterAppear;
            
        while(j == 0)
        {
          for (i = 1; i <= 8; i++)              
            {
                 
                   //check right
                   critterAppear = previous[i][j+1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //check up
                   critterAppear = previous[i][j].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //check down
                   critterAppear = previous[i+1][j].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //check NE
                   critterAppear = previous[i-1][j+1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //check SE
                   critterAppear = previous[i + 1][j + 1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //Check for deaths
                   critterAppear = previous[i][j].getAppearance();
                   if(critterAppear == Critter.REGULAR || critterAppear == Critter.FERTILE)
                   {
                       if (deathCritterCounter >= 4 || deathCritterCounter <= 1)
                       {
                           current[i][j] = new Critter(Critter.EMPTY);
                       }
                   }
                   //Check for births
                   else if(critterAppear == Critter.EMPTY) 
                    {
                        if(birthCritterCounter == 3)
                    {
                        current[i][j] = new Critter(Critter.REGULAR);
                    }
                    
                    }
                //Check is debug needs to be turned on
                if(Mode.debug == true)
                    debugON(i, j, birthCritterCounter);
                   
                
                //Reset counters 
                birthCritterCounter = 0;
                deathCritterCounter = 0;
                  
             
                }
          //Break out of loop when done
                j++;
            }
    
       }
    
        /**
     *checkTopLeft() is specialized to check all of the squares around the top left 
     * corner of the previous array and count critters surrounding every square
     * it. Creates a birth and death count for every critter and depending on the count,
     * a critter is born or a critter dies.This is copied in to the current array
     */
    
    
    public void checkTopLeft()
    {
        int birthCritterCounter = 0;
        int deathCritterCounter = 0;
        int i = 0;
        int j = 0;
        char critterAppear;
            
        while(i == 0)
        {
            while(j == 0)
            {
                
                //check down
                critterAppear = previous[i + 1][j].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                
                //check right
                   critterAppear = previous[i][j + 1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   //check SE
                   critterAppear = previous[i + 1][j + 1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
            
                   }
                   
                   //Check for births
                   critterAppear = previous[i][j].getAppearance();
                   if(critterAppear == Critter.REGULAR || critterAppear == Critter.FERTILE)
                   {
                       if(deathCritterCounter >= 4 || deathCritterCounter <= 1)
                       {
                           current[i][j] = new Critter(Critter.EMPTY);
                       }
                   }
                   
                   //check for deaths
                    else if(critterAppear == Critter.EMPTY) 
                     {

                       if(birthCritterCounter == 3)
                    {
                        current[i][j] = new Critter(Critter.REGULAR);
                      }
                }
                //Check if debug mode is on
                if(Mode.debug == true)
                debugON(i, j, birthCritterCounter);
                   
                //reset counters
                birthCritterCounter = 0;
                deathCritterCounter = 0;
                j++;
            }
            i++;
        }

    }
    
            /**
     *checkTopRight() is specialized to check all of the squares around the top right 
     * corner of the previous array and count critters surrounding every square
     * it. Creates a birth and death count for every critter and depending on the count,
     * a critter is born or a critter dies.This is copied in to the current array
     */
    
    public void checkTopRight()
    {
        int birthCritterCounter = 0;
        int deathCritterCounter = 0;
        int i = 0;
        int j = 9;
        char critterAppear;
            
        while(i == 0)
        {
            while(j == 9)
            {
                
                //Check left
                critterAppear = previous[i][j - 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                
                //check down
                   critterAppear = previous[i + 1][j].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //Check SW
                   critterAppear = previous[i + 1][j - 1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
            
                   }
                   //Check for births
                   critterAppear = previous[i][j].getAppearance();
                   if(critterAppear == Critter.REGULAR || critterAppear == Critter.FERTILE)
                   {
                       if(deathCritterCounter >= 4 || deathCritterCounter <=1)
                       {
                           current[i][j] = new Critter(Critter.EMPTY);
                       }
                   }
                   
                
                   //Check for deaths
                else if(critterAppear == Critter.EMPTY) 
                {
                    if(birthCritterCounter == 3)
                    {
                        current[i][j] = new Critter(Critter.REGULAR);
                    }    
                }
                
                   //Check if debug mode is on
                if(Mode.debug == true)
                debugON(i, j, birthCritterCounter);
                   
                //Reset counters
                birthCritterCounter = 0;
                deathCritterCounter = 0;
                j++;
            }
            i++;
        }
       
    }
    
            /**
     *checkBottomLeft() is specialized to check all of the squares around the bottom left 
     * corner of the previous array and count critters surrounding every square
     * it. Creates a birth and death count for every critter and depending on the count,
     * a critter is born or a critter dies.This is copied in to the current array
     */
    
    public void checkBottomLeft()
    {
        int birthCritterCounter = 0;
        int deathCritterCounter = 0;
        int i = 9;
        int j = 0;
        char critterAppear;
            
        while(i == 9)
        {
            
            while(j == 0)
            {
                //Check up
                critterAppear = previous[i - 1][j].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                
                //Check right
                  critterAppear = previous[i][j + 1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //Check NW
                   critterAppear = previous[i -1][j + 1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //Check for births
                   critterAppear = previous[i][j].getAppearance();
                   if(critterAppear == Critter.REGULAR || critterAppear == Critter.FERTILE)
                   {
                       if(deathCritterCounter >= 4 || deathCritterCounter <= 1)
                       {
                           current[i][j] = new Critter(Critter.EMPTY);
                       }
                   }
                   
                   //Check for deaths
                  else if(critterAppear == Critter.EMPTY) 
                  {
                       if(birthCritterCounter == 3)
                        {
                            current[i][j] = new Critter(Critter.REGULAR);
                        }
                  }
                
                //Check if debug mode is turned on
                if(Mode.debug == true)
                debugON(i, j, birthCritterCounter);
                   
                
                birthCritterCounter = 0;
                deathCritterCounter = 0;
                   
                j++;
            }
            i++;
        }
      
    
    }
    
            /**
     *checkBottomRight() is specialized to check all of the squares around the bottom right 
     * corner of the previous array and count critters surrounding every square
     * it. Creates a birth and death count for every critter and depending on the count,
     * a critter is born or a critter dies.This is copied in to the current array
     */
    
    public void checkBottomRight()
    {
        int birthCritterCounter = 0;
        int deathCritterCounter = 0;
        int i = 9;
        int j = 9;
        char critterAppear;
            
        while(i == 9)
        {
            while(j == 9)
 
            {
                //Check up
                critterAppear = previous[i - 1][j].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //Check left
                   critterAppear = previous[i][j - 1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //Check NW
                   critterAppear = previous[i -1][j - 1].getAppearance();
                   if (critterAppear == Critter.REGULAR)
                   {
                       birthCritterCounter += 1;
                       deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                   
                   //Check births
                   critterAppear = previous[i][j].getAppearance();
                   if(critterAppear == Critter.REGULAR || critterAppear == Critter.FERTILE)
                   {
                       if(deathCritterCounter >= 4 || deathCritterCounter <= 1)
                       {
                           current[i][j] = new Critter(Critter.EMPTY);
                       }
                   }
                   
                   //Check deaths
                else if(critterAppear == Critter.EMPTY) 
                {

                       if(birthCritterCounter == 3)
                        {
                            current[i][j] = new Critter(Critter.REGULAR);
                        }
                }
                //Check is debug is on
                if(Mode.debug == true)
                debugON(i, j, birthCritterCounter);
                   
                //Reset counters
                birthCritterCounter = 0;
                deathCritterCounter = 0;
                
                j++;
            }
            i++;
        }

    }
    
            /**
     *checkTopRow() is specialized to check all of the squares around the top row 
     * of the previous array and count critters surrounding every square
     * it. Creates a birth and death count for every critter and depending on the count,
     * a critter is born or a critter dies.This is copied in to the current array
     */
    
    public void checkTopRow()
    {
        int birthCritterCounter = 0;
        int deathCritterCounter = 0;
        int i = 0;
        int j;
        char critterAppear;
            
        while(i == 0)
        {
            for(j = 1; j <= 8; j++)
            { 
                
                //Check left
                critterAppear = previous[i][j - 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                
                //Check right
                critterAppear = previous[i][j + 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //check down
                critterAppear = previous[i + 1][j].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                
                //Check SW
                critterAppear = previous[i + 1 ][j - 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                else if (critterAppear == Critter.FERTILE)
                {
                    birthCritterCounter += 2;
                    deathCritterCounter += 1;
                }
                
                //Check SE
                critterAppear = previous[i + 1][j + 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                
                //Check for births
                critterAppear = previous[i][j].getAppearance();
                if(critterAppear == Critter.REGULAR || critterAppear == Critter.FERTILE)
                   {
                       if (deathCritterCounter >= 4 || deathCritterCounter <= 1)
                       {
                           current[i][j] = new Critter(Critter.EMPTY);
                       }

                   }
                
                //Check for deaths
                else if(critterAppear == Critter.EMPTY) 
                {
                       if(birthCritterCounter == 3)
                       {
                           current[i][j] = new Critter(Critter.REGULAR);
                       }
                }
                //Check if debug mode is on
                if(Mode.debug == true)
                debugON(i, j, birthCritterCounter);
                   
                //Reset counters
                birthCritterCounter = 0;
                deathCritterCounter = 0;
            }
            i++;
        }
    }
    
    /**
     *checkBottomRow() is specialized to check all of the squares around the bottom row 
     * of the previous array and count critters surrounding every square
     * it. Creates a birth and death count for every critter and depending on the count,
     * a critter is born or a critter dies.This is copied in to the current array
     */
    
    public void checkBottomRow()
    {
        int birthCritterCounter = 0;
        int deathCritterCounter = 0;
        int i = 9;
        int j;
        char critterAppear;
            
        while(i == 9)
        {
            for(j = 1; j <= 8; j++)
            { 
                
                //Check left
                critterAppear = previous[i][j - 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //check right
                critterAppear = previous[i][j + 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                
                //check down
                critterAppear = previous[i - 1][j].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //Check NW
                critterAppear = previous[i - 1 ][j - 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //Check NE
                critterAppear = previous[i - 1][j + 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //Check for births
                critterAppear = previous[i][j].getAppearance();
                if(critterAppear == Critter.REGULAR || critterAppear == Critter.FERTILE)
                   {
                       if (deathCritterCounter >= 4 || deathCritterCounter <= 1)
                       {
                           current[i][j] = new Critter(Critter.EMPTY);
                       }

                   }
                
                //Check for deaths
                else if(critterAppear == Critter.EMPTY) 
                {
                       if(birthCritterCounter == 3)
                       {
                           current[i][j] = new Critter(Critter.REGULAR);
                       }
                }
                //Check if debug mode is on
                if(Mode.debug == true)
                debugON(i, j, birthCritterCounter);
                   
                //Reset Counter
                birthCritterCounter = 0;
                deathCritterCounter = 0;

            }
            i++;
            
        }
    }
    
    /**
     *checkTopRow() is specialized to check all of the squares around all of the elements
     * of the array that are in the middle of array, (not around the edges)
     * of the previous array and count critters surrounding every square
     * it. Creates a birth and death count for every critter and depending on the count,
     * a critter is born or a critter dies.This is copied in to the current array.
     */
    
    public void checkMiddle()
    {
        int birthCritterCounter = 0;
        int deathCritterCounter = 0;
        int i;
        int j;
        char critterAppear;
            
        for(i = 1; i <= 8; i++)
        {
            for(j = 1; j <= 8; j++)
            {
                
                //Check left
                critterAppear = previous[i][j - 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //Check right
                critterAppear = previous[i][j + 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //check down
                critterAppear = previous[i - 1][j].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                
                //Check down
                critterAppear = previous[i + 1][j].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }                
                //Check NW
                critterAppear = previous[i - 1 ][j - 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //Check NE
                critterAppear = previous[i - 1][j + 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //Check SW
                critterAppear = previous[i +1 ][j - 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //Check SE
                critterAppear = previous[i + 1][j + 1].getAppearance();
                if (critterAppear == Critter.REGULAR)
                {
                    birthCritterCounter += 1;
                    deathCritterCounter += 1;

                   }
                   else if (critterAppear == Critter.FERTILE)
                   {
                       birthCritterCounter += 2;
                       deathCritterCounter += 1;
                   }
                //Check for births
                critterAppear = previous[i][j].getAppearance();
                if(critterAppear == Critter.REGULAR || critterAppear == Critter.FERTILE)
                   {
                       if (deathCritterCounter >= 4 || deathCritterCounter <= 1)
                       {
                           current[i][j] = new Critter(Critter.EMPTY);
                       }

                   }
                
                //Check for births
                else if(critterAppear == Critter.EMPTY) 
                {
                       if(birthCritterCounter == 3)
                       {
                           current[i][j] = new Critter(Critter.REGULAR);
                       }
                }
                //Check if debug mode is on
                if(Mode.debug == true)
                debugON(i, j, birthCritterCounter);
                   
                         
                //reset counters
                birthCritterCounter = 0;
                deathCritterCounter = 0;
            }
        }
    }
    
    /**
     *newPrevious() takes all of the elements of the current array and 
     * stores them into the previous array for the next generation. 
     */
    public void newPrevious()
    {
        //For every row
        for(int i = 0; i <= 9; i++)
        {
            //For every column
            for(int j = 0; j <= 9; j++)
            {
                //Make every element in previous into current. 
                previous[i][j] = current[i][j];
                
                
            }
        }

    }
    
}



                

        
