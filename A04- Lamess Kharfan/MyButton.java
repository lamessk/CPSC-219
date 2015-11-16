/**
 *
 * @author Owner
 * 
 * 
 */

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton
{
    private Component aComponent;
    
    public MyButton(String s, ImageIcon pic, Component aComponent)
    {
        super(s, pic);
        this.aComponent = aComponent;
    }
    
    public Component getComponent()
    {
        return(aComponent);
    }
}

