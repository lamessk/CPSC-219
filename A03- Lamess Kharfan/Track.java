/*
Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 3. Race Tracks. Version 1.
Track is The parent race track class. All tracks will contain a fixed size array of car objects.
 The array will be empty (null) except for the one element that refers to a car. 
During the simulation the car will move along the array to simulate the movement
of a car along a track. Responsibilities of the class include: displaying the state of the 
track, putting a car at a parcticular location on the track (can be used in cheat mode or
by the child classes to place the sports car and SUV at the start of their respective tracks 
and 'moving' the car), determining if a car has reached the end of the track.
*/
public class Track
{
    public static final int SIZE = 25;

    private Car [] aTrack;


    // Create the track and initialize all elements to sensible default values.
    public Track()
    {
	int c;
	aTrack = new Car[SIZE];
	for (c = 0; c < SIZE; c++)
	    aTrack[c] = null;
    }

    // Displays the track with a numbered grid around element element.
    // Columns 10 and greater are labeled with capital letters of the alphabet
    public void display()
    {
	int c;
	final int FIRST_CAPITAL = 65;     // ASCII value for 'A' = 65
	int temp_code;
	char temp_char;
	// Labels for the columns
	for (c = 0; c < SIZE; c++)
	{
	    if (c < 9)
		System.out.print(" " + (c+1));
	    // Display letters for values >= 10, A = 10, B = 11 etc.
	    // ASCII 'A' = 65, 'B' = 66
	    else
	    {
		// Determine ASCII code of label
		temp_code = FIRST_CAPITAL + (c - 9);

		// Convert ASCII code to a charcter and display
		temp_char = (char) temp_code;
		System.out.print(" " + temp_char);
	    }	
	}
	System.out.println();


	// Row of dashes before the elements of the track
	for (c = 0; c < SIZE; c++)
	{
	    System.out.print(" -");
	}
	System.out.println();
	
	// Display each track element bound left and right by vertical bar.
	for (c = 0; c < SIZE; c++)
	{
	    if (aTrack[c] != null)
	    {
		// Each element is preceeded by a vertical bar.
		System.out.print('|');
		// Display element element.
		System.out.print(aTrack[c].toString());
	    }
	    else
		System.out.print("| ");
	} 
	// Closing bar at end of row (follows last element)
	System.out.println('|');

	// Row of dashes after the elements of the track
	for (c = 0; c < SIZE; c++)
	{
	    System.out.print(" -");
	}
	System.out.println();

    }

    public Car []  getTrack ()
    {
	return aTrack;
    }

    // Used place a car object at a particular index in the track, useful for 
    // child classes that needs to place the two cars at the starting location.
    
    protected void setLocation(Car aCar, int index)
    {
	if ((index >= 0) && (index < Track.SIZE))
	    aTrack[index] = aCar;
	else
	{
	    if ((index < 0) || (index >= Track.SIZE))
		System.out.println("Placing car out of bounds of track 0-" + Track.SIZE);	    
	}
    }

}
