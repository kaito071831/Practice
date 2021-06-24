import java.awt.*;
//import java.awt.event.*;
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
        JButton reset = new JButton("Reset");
        frame.add(reset, BorderLayout.WEST);
        JPanel action = new JPanel();
        action.setLayout(new BoxLayout(action, BoxLayout.Y_AXIS));
        frame.add(action, BorderLayout.EAST);
        JButton start = new JButton("Start");
        start.setMaximumSize(new Dimension(80,80));
        action.add(start);
        JButton stop = new JButton("Stop");
        stop.setMaximumSize(new Dimension(80,80));
        action.add(stop);


        JPanel buttonA = new JPanel();
        JPanel buttonLayout = new JPanel();
        buttonLayout.setLayout(new BoxLayout(buttonLayout, BoxLayout.Y_AXIS));
        frame.add(buttonA, BorderLayout.CENTER);
        buttonA.add(buttonLayout);
        
        JButton m10 = new JButton("10分");
        m10.setMaximumSize(new Dimension(100,50));
        JButton m1 = new JButton("1分");
        m1.setMaximumSize(new Dimension(100,50));
        JButton s10 = new JButton("10秒");
        s10.setMaximumSize(new Dimension(100,50));
        JButton s1 = new JButton("1秒");
        s1.setMaximumSize(new Dimension(100,50));

        //int min;
        //int sec;

        // m10.addMouseListener(new MouseAdapter(){
        //     public void mouseClicked(MouseEvent e){
        //         System.out.println("押されました");
        //     }
        // });

        buttonLayout.add(m10);
        buttonLayout.add(m1);
        buttonLayout.add(s10);
        buttonLayout.add(s1);

        frame.setVisible(true);
    }
        
}