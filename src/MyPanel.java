/**
 * a class creates the panel and its components
 * author: Miray Ayerdem
 * version : 25/11/2020
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    //Instances
    ArrayList<JButton> pots;
    ArrayList<JPanel> panels;
    ActionListener listener;
    JPanel panel ,panel2, panel3;
    JLabel label;
    private int attempt, numberOfBomb, prize, bomb, bomb2, num;
    private final int SIZE = 100;

    //Constructor
    MyPanel(int num)
    {
        this.num = num;
        panels = new ArrayList<JPanel>();
        pots = new ArrayList<JButton>();
        listener = new MyListener();
        setSize(SIZE * num,SIZE * num);
        setBackground(new Color(222,167,226));
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel.setPreferredSize(new Dimension(SIZE * num,20));
        panel.setBackground(Color.pink);
        label = new JLabel(attempt + "");
        panel.add(label);
        add(panel);
        numberOfBomb = 0;
        createComponent();


    }
    //inner class that listen actions of buttons to take action
    class MyListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //if all of the bombs are found game is starting again
            if(numberOfBomb >= 2)
            {
                numberOfBomb = 0;
                attempt = 0;
            }
            attempt++; //one action means one attempt
            //beginning of the game bombs and prizes buttons are chosen randomly
            if (attempt == 1) {
                prize = (int) (Math.random() * pots.size());
                do {
                    bomb = (int) (Math.random() * pots.size());
                    bomb2 = (int) (Math.random() * pots.size());
                }
                while (bomb == bomb2 || bomb == prize || bomb2 == prize); //they need to be different
            }
            //according to buttons labels are setting
            if(numberOfBomb < 2){

                if (e.getSource() == (pots.get(prize))) {
                    label.setText("WUWWW!! Price is found in " + attempt + " tries");
                    numberOfBomb = 0;
                    attempt = 0;
                } else if (e.getSource() == (pots.get(bomb)) || e.getSource() == (pots.get(bomb2))) {
                    label.setText("NOO:((( You are blown up at " + attempt + " tries");
                    numberOfBomb++;
                }
                else {
                    label.setText(attempt + "");
                }
            }


        }
    }

    /**
     * a method to create buttons and add to this.panel
     */
    public void createComponent()
    {
        panel2.setLayout(new GridLayout(num, num, num, num));

        //according to dimension, buttons are created and adding to pots arraylist
        for (int i = 1; i <= num * num; i++) {
            panels.add(new JPanel());
            pots.add(new JButton("Pot " + i));
            pots.get(pots.size()-1).setPreferredSize(new JButton("Pot 100").getPreferredSize());
            pots.get(i-1).addActionListener(listener);
            panels.get(i-1).add(pots.get(i-1));
            panel2.add(panels.get(i-1));
        }
        add(panel2);

    }
}
