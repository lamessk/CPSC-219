/*Lamess Kharfan.CPSC 219. T04. Assignment 4. Version 1. Student Number: 10150607.
Shopping program Simulator. When the program is run a login dialog is presented to the user. The 
password is stored in an 'encrypted' format in a file called "password.txt". The encryption employs
 the Caesar cipher which shifted each character backward one place in the alphabet. The program reads
 the encrypted password and converts it to the original form. It will then compare the unencrypted
string vs. the current value entered in the password field when either: (1) the user hits the login
 button or (2) the cursor focus is in the password field and the user hits enter. If there is no
 match then the program should display a suitable error message as well as the number of attempts and
 the maximum number allowed. If three unsuccessful attempts have been made then a suitable error 
message is provided and the program will end. Program will 'pause' so the user actually has time to see
 the error message before it shuts down. If the password has been correctly entered then the login 
window is banished and the main shopping screen comes up. The shopping window consists of a name text field
and a address text field. The user can enter information into these fields and click the save button, which 
sends the entered information to an external file called "order.txt." The user can then click the clear button
which deletes all infomation that the user previously entered in the window so that they may do it again. The 
user may hit the 'x' to exit the program. 
Program Limitations: User only has 3 tries to log in, each time the user clicks save, order.txt is overwritten
and all previously entered information is discarded. 

Driver() is the main starting point of the program

*/

public class Driver {

    public static void main(String[] args) 
    {
	//Instantiate the login window as the starting point of the program
        
        MyDialog aDialog = new MyDialog();
        aDialog.setBounds(100, 100, 350, 200);
        aDialog.setVisible(true);


    }
    
}

