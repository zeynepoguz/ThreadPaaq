package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultiButton extends JFrame {

    private JButton b1,b2,b3;
    private JLabel label;

    public MultiButton() {
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");

        label = new JLabel("...");

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(label);
        c.add(b1);
        c.add(b2);
        c.add(b3);

        MyActionListener al = new MyActionListener();
        b1.addActionListener(al);
        b2.addActionListener(al);
        b3.addActionListener(al);
    }


    public class PrintThread extends Thread{
        private String number;

        public PrintThread(String s){
            number = s;
        }

        public void run(){
            while (true)
                label.setText(number);
        }

    }

    public class MyActionListener implements ActionListener{


        public void actionPerformed(ActionEvent e){
            if (e.getSource() == b1) {
                PrintThread t1 = new PrintThread("1");
                t1.start();
            }

            if (e.getSource() == b2){
                PrintThread t2 = new PrintThread("2");
                t2.start();
            }

            if (e.getSource() == b3){
                PrintThread t3 = new PrintThread("3");
                t3.start();
            }
        }

    }

}
