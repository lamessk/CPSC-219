/*/*Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 4. Shopping Simulation. Version 1.
MyDialog() presents the user with a login dialog when the program is 
initially run, The password expected is stored in a file and is encrypted using
a CeasarCipher which shifts each character backward one space in the alphabet.
The encrypted password is read from the file and converted to the original form.
It will then compare the unencrypted string vs. the current value entered in
the password field when either: (1) the user hits the login button or (2) the 
cursor focus is in the password field and the user hits enter. If there is no 
match then the program should display a suitable error message as well as the 
number of attempts and the maximum number allowed. If three unsuccessful attempts 
have been made then a suitable error message should be providedand the program will end.
If the password has been correctly entered then the login window is banished
 and the main shopping screen comes up.

*/

//Import all libraries needed for GUI's
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.io.*;



public class MyDialog extends JDialog implements ActionListener
{
   //Instantiate all class attributes
    public final int MATCH = 0;
    private JPasswordField aPasswordField;
    private JLabel aLabel;
    private int incorrect = 3;
    private JButton aButton;
    
    /*MyDialog() creates the user interface of the login window. It sets the 
      bounds of the window, sets the title bar, creates a label and text field,
      instantiates a buttons that will react the the event of being clicked
    */ 
    public MyDialog()
    {
	setBounds(100, 100, 350, 200);
        setTitle("No. incorrect login attempts (max = 3): " + incorrect);
        aLabel = new JLabel("Enter Password: ");
        aLabel.setBounds(50, 2, 120, 20);
        aPasswordField = new JPasswordField();
        aPasswordField.setBounds(50, 40, 120, 20);
        aPasswordField.addActionListener(this);
        aButton = new JButton("Login");
        aButton.setBounds(50, 100 ,100, 30);
        aButton.addActionListener(this);
        setLayout(null);
        addControl();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    //Adds label, password field, and button to the login window and displays them
    public void addControl()
    {
        
        add(aLabel);
        add(aPasswordField);
        add(aButton);
    }
    //actionPerformed() reacts the the events of the login button being clicked
    //If the password is correct the shopping window will open and if the password
    //is incorrect the user has 3 attempts total to keep trying until the program closes
    public void actionPerformed(ActionEvent e)
    {
	//Set password input
        String passwordinput = new String (aPasswordField.getPassword());
        //Read encrypted password from the file
        String filePass = readFile();
	//Deecrypt the password in the file
        String decryptedPass = CeasarCipher(filePass);
	//If the user input and decypted password are a match then login is a success
        if(decryptedPass.compareTo(passwordinput) == MATCH)
        {
            loginSuccess();
        }
	//Otherwise, login failed
        else
        {
            loginFailed();
        }
    }

    //CeasarCipher() decrypts passwords by moving all letters of the password
    //forward one letter in the alphabet 
    public String CeasarCipher(String pass)
    {
	//Shift is 1 space forwards
        int shift = 1;
	//turn into a character array
        char [] message = pass.toCharArray();
        String encypted = "";
        //for all elements in the character array
        for(int i = 0; i < message.length; ++i)
        {
	    
            char c = message[i];
	    //Shift the character element one letter forwards
            c = (char)(((c - 'a' + shift) % 26) + 'a');
	    //Add that letter element to a string 
	    encypted = encypted + c;
        }
	//Return the finished decrypted string password
        return encypted;       
    }

    //readFile() opens a file and reads what is inside it line by line
    //After retrieving the information inside the file it will close the file.
    //Catches any exceptions such as file not existing or IO excpetions.
    String firstLine;
    public String readFile()
    {
	//First try to open file, read filem and close file
        try
        {
            BufferedReader theInput = new BufferedReader(new FileReader("password.txt"));
            firstLine = theInput.readLine();
            theInput.close();
        }
        //If file doesn't exist, display appropriate error message
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
        //Display appropriate error message for IO error
        catch(IOException e)
        {
            System.out.println("Problem opening file.");
        }
        
        return firstLine;
    }
            
    //loginSuccess() closes the login window and opens the shopping window 
    public void loginSuccess()
    {
	setTitle("Login Successful!");
	timeDelay();
	setVisible(false);
	MyInterface aInterface = new MyInterface();
	MyWindowListener aWListener = new MyWindowListener();
        aInterface.addWindowListener(aWListener);
	aInterface.setVisible(true);
        
        
    }
    //loginFailed() gives the user 3 tries to enter the correct password
    //and closes the program if the user enters the password incorrectly 3 times
    public void loginFailed()
    {
	//One less login attempt
       incorrect = incorrect - 1;
       //When there are no more attempts, end the program
       if(incorrect == 0)
       {
           setTitle("Max attempts exceeded, exiting...");
           timeDelay();
           System.exit(0);
       }
	//Update the number of attempts left
	else
	setTitle("No. incorrect login attempts (max = 3): " + incorrect);
    }
    
    //timeDelay() pauses the program for a brief period of time so the user may
    //read changes in the title bar before the program exits
    private void timeDelay()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Interuption occured");
        }
        
    }
    
    
}
