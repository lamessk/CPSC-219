import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Scanner;
import javax.swing.JFrame;



public class MyInterface extends JFrame implements ActionListener
{
    Scanner in = new Scanner(System.in);
    
    public static final int WIDTH = 200;
    public static final int HEIGHT = 200;
    public static final int BUTTONX = 50;
    public static final int BUTTONY = 40;
    public static final int BUTTON_HEIGHT = 20;
    public static final int BUTTON_WIDTH = 100;
    public static final int LABELX = 50;
    public static final int LABELY = 50;
    public static final int LABEL_HEIGHT = 75;
    public static final int LABEL_WIDTH = 75;
    
    public float num1;
    public float num2;
    public float result;
    
    JLabel aLabel = new JLabel("");
    
    public MyInterface()
    {
        super();
	setLayout(null);
        setSize(WIDTH, HEIGHT);
        JButton aButton = new JButton("Multiply");
        aButton.setBounds(BUTTONX, BUTTONY, BUTTON_WIDTH, BUTTON_HEIGHT);
        aButton.addActionListener(this);
        add(aButton);
	aLabel.setBounds(LABELX, LABELY, LABEL_WIDTH, LABEL_HEIGHT);
	add(aLabel);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        JButton aButton = (JButton) e.getSource();
        numbers();
    }
    
    public void numbers()
    {
        System.out.println("Enter the first number: ");
        num1 = in.nextInt();
        System.out.println("Enter the second number: ");
        num2 = in.nextInt();
        result = num1*num2;
        System.out.println(result);
        aLabel.setText(Float.toString(result));
        
    }

}

