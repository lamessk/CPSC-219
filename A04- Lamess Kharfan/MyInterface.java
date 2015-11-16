/*Lamess Kharfan. Student Number: 10150607
CPSC 219. Tutorial 04. Assignment 4. Shopping Simulation. Version 1. 
MyInterface() handles the shopping window for "Lamess's sweets co." 
User can enter their name and shipping address info into the text area
and textfields, respectively, and hit save when they are done, hitting 
save saves the entered information to a external text document called
"order.txt", user can then hit the clear button to deleted all previously
entered information, then enter more information and save that if desired.
User can exit the program by clicking the x in the corner of the window.
*/

//Import all needed libraries for graphical 
//user interface programs, document reading, writing.
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.io.FileWriter;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.awt.Insets;


public class MyInterface extends JFrame
{
    //Instantiate attributes of the class
    private JTextField textField1;
    private JTextArea textField2;
    private MyButton saveButton;
    private MyButton clearButton;
    private JLabel title;
    private JLabel titleContinued;
    private ImageIcon titleIcon;
    private JLabel imageLabel;
    private ImageIcon titleIcon2;
    private JLabel imageLabel2;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private ImageIcon anIcon;
    private ImageIcon cIcon;


    /*MyInterface() handles opening and closing of the shopping window, 
	can be instantiated and shopping window will appear as needed.
	*/    
    MyInterface()
    {
        GridBagConstraints aConstraint = new GridBagConstraints();
	setLayout(null);
	//sets title bar of shopping window
        setTitle("Order Information");
	//sets the size of the shopping window
        setBounds(100, 100, 450, 350);

	initializeControls();
	actionsPerformed();
	addControls();
       //Close window and end program when user hits 'x'
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }



    //WriteFile() gets the text from the text fields and saves it
    //to a file called order.txt/ Enters the name and address info
    //on seperate lines of the file.
    public void writeFile()
    {
	try
        {
		//instantiate new print writer that will write to ordert.xt
		PrintWriter theOutput = new PrintWriter(new FileWriter("order.txt"));
		//get the information from both textfields		
		String name = textField1.getText();
                String address = textField2.getText();
		//Print the info to the file
		theOutput.println(name);
		theOutput.println(address);	
		//Close the file being written to
		theOutput.close();
                }
		//Catches the exception when the file cannot be found
                catch(FileNotFoundException f)
                {
                    System.out.println("File cannot be found");
                } 
		//Catches issues with IO
                catch (IOException f) 
                {
                    System.out.println("File could not be loaded");
   
                }	
    }
    

    /*InitializeControls() creates all labels, buttons, and Icons to be displayed
      on the shopping window and sets a spot for it to be displayed at
    */
    public void initializeControls()
    {
	//Creates title, sets font, and chooses bounds
	title = new JLabel("LAMESS'S SWEETS CO.");
	titleContinued = new JLabel("Breads & Pastries");
	title.setFont(new Font("Times", Font.BOLD, 20));
        title.setBounds(110, 30, 250, 70);
	titleContinued.setFont(new Font("Arial", Font.BOLD, 18));
	titleContinued.setBounds(120, 60, 200, 70);
	
	//Creates image of a flour bag in title
	titleIcon = new ImageIcon("flour.gif");
	imageLabel = new JLabel(titleIcon);
	imageLabel.setBounds(0, 30, 100, 100);

	//Creates image of sugar bag in title
	titleIcon2 = new ImageIcon("sugar.gif");
	imageLabel2 = new JLabel(titleIcon2);
	imageLabel2.setBounds(325, 30, 100, 100);

	//creates label above the text field designated for the name field
        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(40, 140, 140, 20);
	//creates a label above the address text area
        addressLabel = new JLabel("Address: ");
        addressLabel.setBounds(240, 140, 120, 20);

	//Creates a text field for user to enter their name into
        textField1 = new JTextField("");
        textField1.setBounds(40, 160, 120, 25);
	//creates a text area for user to enter all their shipping address info into
        textField2 = new JTextArea("");
        textField2.setBounds(240, 160, 120, 80);
    }

    /*actionsPeformed() creates buttons for clear and save and reacts to events of the save 
	button and clear button being clicked.
	when the save button is clicked all info entered into both text fields is saved to an
	external file. when clear button is clicked both text fields are cleared.
	*/
    public void actionsPerformed()
    {
	//Creates save button
	anIcon = new ImageIcon("saveg.gif");
        saveButton = new MyButton("Save", anIcon, this);
        saveButton.setBounds(40, 250, 100, 30);
	//reacts to events of save button being clicked
        saveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton aButton = (JButton) e.getSource();
		setTitle("Saving....");
		timeDelay();
		setTitle("Order Information");
                writeFile();
                        
            }
            
        });
	//creates clear button
        cIcon = new ImageIcon("trash.gif");
        clearButton = new MyButton("Clear", cIcon, this);
        clearButton.setBounds(240, 250, 100, 30);
	//Reacts to events of clear button being clicked
        clearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent d)
            {
                JButton bButton = (JButton) d.getSource();
		setTitle("Clearing....");
		timeDelay();
		setTitle("Order Information");
                textField1.setText("");
                textField2.setText("");
            }
            
        });

    }

    //addControls() Adds all buttons and labels to the shopping window and displays them    
    public void addControls()
    {
	add(title);
	add(titleContinued);
        add(nameLabel);
	add(imageLabel);
	add(imageLabel2);
        add(addressLabel);
        add(textField1);
        add(textField2);
        add(saveButton);
        add(clearButton);
    }

    //timeDelay() pauses the program for a brief period of time so the user may
    //read changes in the title bar before the program exits
    private void timeDelay()
    {
        try
        {
            Thread.sleep(1500);
        }
        catch(InterruptedException e)
        {
            System.out.println("Interuption occured");
        }
        
    }
    
}
    

