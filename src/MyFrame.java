import javax.swing.*;

public class MyFrame extends JFrame {
    MyFrame(int num)
    {
        MyPanel panel = new MyPanel(num);
        this.getContentPane().add(panel);
        this.pack();
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}