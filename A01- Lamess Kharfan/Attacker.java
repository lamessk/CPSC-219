/*Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 1. Fight Simulator. Version 1.
Attacker class generates attacks. 
*/

import java.util.Random;
public class Attacker {
    
    public float numRounds;
    
    //Association of each attack to an integer
    public float high = 1;
    public float medium = 2;
    public float low = 3;
    
    public float attack = 0;
        
    //Attacker constructor to launch attacks in Manager.
    public void Attacker()
	{
	}
    
    /**
     * @param hi , the probability of high attacks specified.
     * @param med, the probability of medium attacks specified.
     * @param lo, the probability of low attacks specified
     * @return attack, gives back which attack to implement based on random
     * selection of numbers in each bucket.
     * getAttack() takes the probabilities of each attack entered by the user
     * Selects a random number in the range of 1 - 100 and attack corresponding
     * with the number in a specific bucket is implemented
     */
    public float getAttack(float hi, float med, float lo)
    {     
          Random generator = new Random();
          attack = generator.nextInt(100);
        
          if (attack >= 0 && attack <= hi)
          {
              attack = high;
          }
	  else if (attack >= hi && attack <= med+hi)
          {
              attack = medium;
          }
          
          else if (attack > med+hi && attack <= 100)
          {
              attack = low;
          }
          return attack;
    }


    /**
     * @param attack - Takes in the integer associated with attacks
     * @return attackStr - The word representation of an attack
     * ConvertToString() takes in attacks and associates the number 		representing
     * each attack with the word representation
     */
    public String convertToString(float attack)
    {
        String attackStr = "None";
        if(attack == 1)
        {
              attackStr = "High";
        }
        else if (attack == 2)
        {
            attackStr = "Medium";
            
        }
        else if (attack == 3)
        {
            attackStr = "Low";
        }
        return attackStr;
    }


	
}


