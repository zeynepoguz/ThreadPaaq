package Q1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TextsGUI extends JFrame {

    private JTextArea textArea;
    private JButton startB;
    private JButton stopB;
    private JScrollPane scrollPane;

    private boolean isWrites = true;


    public TextsGUI(){
        textArea = new JTextArea(5,25);
        startB = new JButton("start");
        stopB = new JButton("stop");

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(textArea);
        c.add(startB);
        c.add(stopB);
        c.add(new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        MEventHandler eh = new MEventHandler();

        startB.addActionListener(eh);
        stopB.addActionListener(eh);



    }

    public class MEventHandler implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == startB){
                isWrites=true;
                EventThread btnStart = new EventThread();
                btnStart.start();
                textArea.setVisible(true);
            }

            if (e.getSource() == stopB){
                textArea.removeAll();
                textArea.setVisible(false);
                isWrites=false;
            }

        }
    }

    public class EventThread extends Thread{
        public void run(){

            while (isWrites)
                textArea.append((String.valueOf((int)(Math.random()*5000)))+"\n");

        }
    }

//    public void changeText() throws InterruptedException{
//        if (!cont){
//            try{
//                System.out.println("WAIT;");
//                wait();
//            }catch (InterruptedException ie){
//                System.err.println(ie.getMessage());
//            }
//        }
//        cont=true;
//        textArea.append(String.valueOf((int) (Math.random() * 3000)));
//        System.err.println("writed");
//        notifyAll();
//
//    }
//
//
//    public synchronized void stopWriting() throws InterruptedException{
//        if (cont){
//            try{
//                wait();
//            }
//            catch (InterruptedException ie){
//                System.err.println(ie.getMessage());
//            }
//        }
//        cont = false;
//        notifyAll();
//
//    }

}
