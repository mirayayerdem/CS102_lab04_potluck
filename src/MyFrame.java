/**
 * a class creates a frame
 * author: Miray Ayerdem
 * version : 26/11/2020
 */
import javax.swing.*;

public class MyFrame extends JFrame {
    //Constructor
    MyFrame(int num) //param takes the dimension from user
    {
        MyPanel panel = new MyPanel(num);
        this.getContentPane().add(panel); //panel is adding to frame
        this.pack();
        setSize( 100 * num,100 * num);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}