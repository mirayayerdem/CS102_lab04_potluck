import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    ArrayList<JButton> pots;
    ArrayList<JPanel> panels;
    ActionListener listener;
    JPanel panel;
    JPanel panel2;
    JPanel panel3;
    JLabel label;
    private int attempt;
    private int prize;
    private int bomb;
    private int bomb2;
    private int num;
    MyPanel(int num)
    {
        panels = new ArrayList<JPanel>();
        pots = new ArrayList<JButton>();
        listener = new MyListener();
        setSize(300,300);
        setBackground(Color.yellow);
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel.setPreferredSize(new Dimension(300,20));
        panel.setBackground(Color.pink);
        label = new JLabel(attempt + "");
        panel.add(label);
        add(panel);
        this.num = num;
        createComponent();


    }
    class MyListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            attempt++;
            if(attempt == 1) {
                prize = (int) (Math.random() * pots.size() - 1);
                do {
                    bomb = (int) (Math.random() * pots.size() - 1);
                    bomb2 = (int) (Math.random() * pots.size() - 1);
                }
                while(bomb == bomb2 || bomb == prize || bomb2 == prize);
            }

            if(e.getSource() == (pots.get(prize)))
            {
                label.setText("WUWWW!! Price is found in " + attempt + " tries");
            }
            else if(e.getSource() == (pots.get(bomb)) || e.equals(pots.get(bomb2)))
            {
                label.setText("NOO:((( You are blown up at " + attempt + " tries");
            }
            else
            {
                label.setText(attempt + "");
            }
        }

    }

    public void createComponent()
    {
        panel2.setLayout(new GridLayout(num, num, num, num));

        for (int i = 1; i <= num * num; i++) {
            panels.add(new JPanel());
            pots.add(new JButton("Pot " + i));
            pots.get(i-1).addActionListener(listener);
            panels.get(i-1).add(pots.get(i-1));
            panel2.add(panels.get(i-1));
        }
        add(panel2);

    }
}
