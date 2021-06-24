import java.awt.*;
import javax.swing.*;

/**
 * Timer
 */
public class Timer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("キッチンタイマー");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());
        JTextArea time = new JTextArea(1, 10);
        frame.add(time, BorderLayout.NORTH);

        JPanel buttonA = new JPanel(new FlowLayout());
        frame.add(buttonA, BorderLayout.CENTER);
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        buttonA.add(b1);
        buttonA.add(b2);
        buttonA.add(b3);
        buttonA.add(b4);
        buttonA.add(b5);
        buttonA.add(b6);
        buttonA.add(b7);
        buttonA.add(b8);
        buttonA.add(b9);
        buttonA.add(b0);

        frame.setVisible(true);
    }
        
}