
import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;



public class MyWindowListener extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        JFrame aFrame = (JFrame) e.getWindow();
        aFrame.setTitle("Closing Window...");
        aFrame.setVisible(false);
        aFrame.dispose();
    }
}

