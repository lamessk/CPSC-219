public class Driver {
    
    public static void main(String [] args)
    {
        
        MyInterface interfaceA = new MyInterface ();
        interfaceA.setVisible(true);

        MyWindowListener aWListener = new MyWindowListener();
        interfaceA.addWindowListener(aWListener);
}
    
}

