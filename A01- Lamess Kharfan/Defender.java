/*Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 1. Fight Simulator. Version 1. 
Defender class generates defences. Learns patterns in attackers attacks, 
implements new defences accordingly.  
*/
import java.util.Random;

public class Defender {

//Association of each attack to an integer
public int high = 1;
public int medium = 2;
public int low = 3;

//Defender constructor. Launches defences in Manager
public void Defender()
{ 
}


    /**
     * @param dHigh , the probability of high defences.
     * @param dMed, the probability of medium defences.
     * @param dLow, the probability of low defences. 
     * @return defence, gives back which defence to implement based on random
     * selection of numbers in each bucket.
     * getDefence() takes the probabilities of each attack entered by the user
     * Selects a random number in the range of 1 - 100 and defence 	    	corresponding with the number in a specific bucket is implemented
     */

	public float getDefence(float dHigh, float dMed, float dLow)
	{
    	  Random generator = new Random();
    	  float defence = generator.nextInt(100)+ 1;
    	  if(defence >= 0 && defence <= dHigh)
    	  {
	    defence = high;
	  }
	  else if (defence >= dHigh && defence <= dMed+dHigh)
    	  {
            defence = medium;
	  }
    	  else if(defence > dMed+dHigh && defence <= 100)
    	  {
            defence = low;
	  }
	  return defence;
	}

    /*
     * @param defence - Takes in the integer associated with defence
     * @return defenceStr - The word representation of the defence
     * ConvertToString() takes in defences and associates the number 		associated with each defence to the word representations
     */
	public String convertToString(float defence)
	{
          String defenceStr = "None";
          if(defence == 1)
          {
              defenceStr = "High";
          }
          else if (defence == 2)
          {
            defenceStr = "Medium";  
          } 
          else if (defence == 3)
          {
            defenceStr = "Low";
          }
          return defenceStr;
	}

     /**
     * the learner() method learns the attackers likely hood of implementing a 
     * particular attack by counting the numbers of each attack.
     * Depending on which count is highest, the high, medium or low, a defence 		is
     * determined, using a serious of if -if else statements. 
     * @param attack - takes in attacks implemented by the attacker
     * @return defence - the defense to begin implementing once the attackers
     * patterns have been learned
     */
	public float learner(float attack)      
	{
		float highCount = 0;
		float medCount = 0;
		float lowCount = 0;
		float biggest = 0;
		if (attack == 1)
		{
	 	  highCount = highCount + 1;
		}
		else if (attack == 2)
		{
		  medCount = medCount + 1;
		}
		else if (attack == 3)
		{
		  lowCount = lowCount + 1;
		}

		float defence = 0;
	
		if (highCount > biggest)
		{
		  biggest = highCount;	
		  defence = 1;  
		}
		else if (medCount > biggest)
		{
		  biggest = medCount;
		  defence = 2;
		}
		else if (lowCount > biggest)
		{
		  biggest = lowCount;
		  defence = 3;
		}
		return defence;

	    }

    
}

