/*Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 1. Fight Simulator. Version 1. 
Manager takes class attack(which launches attacks) and class defender (which launches defences) and makes them opponents in kombat. There are 3 types of attacks and defences categorized by height: high, low and medium. If height of the attack matches the height of the defencem the attack is blocked, otherwise the attacker hit the defender and won the match. A user specifies percentages for each attack for the attacker as well as the number of rounds, and the defender generates defences with equal probability for the first 20 rounds, afterwards it becomes "intelligent" and the learns the patterns in the attacker and implements defences according to which attack is most often used.
After each round the attack and defence are displayed along with the result. The end of the program displays statistics of the entire Kombat such as probability of each attack by the attacker and defender and the total amount of hits and blocks. 
Limitations: Can only run 100 rounds. Percentages of probability of each attack must amount to 100. A string cannot be entered for any of the prompts for proabilities or rounds. 
*/


import java.util.Scanner;

public class Manager {

	public static void main(String[] args){
	
        float numRounds;    
        
	Scanner in = new Scanner(System.in);
	//Request number of rounds from the user.
        System.out.print("Enter the number of rounds: ");
	numRounds = in.nextFloat();
        //error check for negative rounds and rounds greater than limit
        if(numRounds > 100 || numRounds < 0)
	{
	  numRounds = 10;
	}   
        
	//Request probabilites of each attack from the user.
        System.out.print("Enter the percentage of high attacks: ");
	float high = in.nextFloat();
	System.out.print("Enter the percentage of medium attacks: ");
	float medium = in.nextFloat();
	System.out.print("Enter the percentage of low attacks: "); 
	float low = in.nextFloat();
	

	//Error checking. If the users entered percentages do not add up to 100
	//set percentages to default values.
	if ((high + medium + low) > 100)
        {
         high = 33;
         medium = 34;
         low = 33;
        }
	
	//Create instances of the attack and defender
        Attacker aAttacker = new Attacker();
        Defender aDefender = new Defender();
       
	//Counters for end results and to make the while loop run and terminate
        int counter = 0;
	int roundCount = 1;
        int hitCounter = 0;
        int blockCounter = 0;

	float highCount = 0;
	float medCount = 0;
	float lowCount = 0; 
	//Result of attacks and defences. Either "Hit" or "Block"
        String result;

	/*While loop runs though all the the rounds specified by the user. 
	 * Attacks and defences implemeted. Result is determined. 
	*/
	while(numRounds > counter)
	{
	  //get attack and defence from the attacker and defender
	  float attack = aAttacker.getAttack(high, medium, low);
	  float defence = aDefender.getDefence(33, 34, 33);


	
	  //Call learner method to count attackers attacks and begin to change 
	  //defences according to highest number to certain attack implemented 		  //by the attacker after 20 rounds.  	
	  //After round 20, check which attack was most common using a series of if if-else statements. Whichever was most common becomes the defenders new permanent defence so the defender may block more often. 	
  	  if (counter >=  20)
		{
		  float mostUsed = aDefender.learner(attack);
		  
		  if (mostUsed == 1)
		  {
		    defence = aDefender.getDefence(100, 0, 0);
		  }
		  else if (mostUsed == 2)
		  {
		    defence = aDefender.getDefence(0, 100, 0); 
		  }
		  else if (mostUsed == 3)
		  {
		    aDefender.getDefence(0, 0, 100);
		  }
		  else
		  {
		    defence = aDefender.getDefence(33, 34, 33);
		  }
		} 

	  //If defences and attack are the same, the attack was blocked by the
	  //defender, the result of the round is "Blocked"
	  if (attack == defence)
	  {
	    result = "Blocked!";
            blockCounter = blockCounter + 1;
	  }
	  //If defences and attack are not the some, the attack was not blocked
	  //by the defender, the result of the round is "Hit"        
	  else 
          {
            result = "Hit!";
            hitCounter = hitCounter + 1;
          }

		//Count the amount of each defence used by the defender for stats
		//at the end.
		if (defence == 1)
		{
		highCount = highCount + 1;
		}
		if (defence == 2)
		{
		medCount = medCount + 1;
		}
		if (defence == 3)
		{
		lowCount = lowCount + 1;
		}

	  //Display the round, the attack, the defence, and the result of the round
          System.out.println("Round " + roundCount + "..." + "  Attacker: " + aAttacker.convertToString(attack)+ "\tDefender:  " + aDefender.convertToString(defence) + "  \tResult: " +result);
     	
	  //Increase the counts by one, go on to the next round.   
	  counter = counter + 1;
	  roundCount = roundCount + 1;
	  }

	  //Display the summary of all the rounds. Total hits, Total blocks, the propotion of each attack implemented by the attacker and the defender.
	  System.out.println("Summary of Kombat: ");
          System.out.println("Total Hits:" + hitCounter + "Total Blocks: " + blockCounter);
	

	  //Attacker Proportions
          System.out.println("Attacker Proportions: Low " + low + " Medium " + medium + " High " + high);

	  //Defender Proportions
	  System.out.println("Defender Proportions: Low " + (lowCount/numRounds)*100 + " Medium: " + (medCount/numRounds)*100  + " High: " + (highCount/numRounds)*100);  

          }




}
        

