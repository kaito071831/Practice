import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Timer
 * @author kaito071831
 */
public class Timer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("キッチンタイマー");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JPanel timeIO = new JPanel();
        timeIO.setLayout(new FlowLayout());

        JLabel timeMl = new JLabel("分");
        JLabel timeSl = new JLabel("秒");
        JTextArea timeM = new JTextArea(1, 10);
        timeM.setText("00");
        JTextArea timeS = new JTextArea(1, 10);
        timeS.setText("00");
        timeIO.add(timeMl);
        timeIO.add(timeM);
        timeIO.add(timeSl);
        timeIO.add(timeS);
        frame.add(timeIO, BorderLayout.NORTH);

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

        Time time = new Time();

        m10.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                time.min10 += 1;
                
                timeM.replaceRange(time.outputTime(time.min10), 0, 1);
                if(time.min10 >= 6){
                    time.min10 -= 6;
                    if(time.min10 == 0){
                        timeM.replaceRange("0", 0, 1);
                    }
                    System.out.println(time.getMin());
                }else{
                    timeM.replaceRange(time.outputTime(time.min10), 0, 1); 
                    System.out.println(time.getMin());
                }
            }
        });

        m1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                time.min1 += 1;
                timeM.replaceRange(time.outputTime(time.min1), 1, 2);
                if(time.min1 >= 10){
                    time.min1 -= 10;
                    if(time.min1 == 0){
                        timeM.replaceRange("0", 1, 2);
                        timeM.replaceRange("", 2, 3);
                    }
                    System.out.println(time.getMin());
                }else{
                    timeM.replaceRange(time.outputTime(time.min1), 1, 2); 
                    System.out.println(time.getMin());
                }
            }
        });

        s10.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                time.sec10 += 1;
                timeS.replaceRange(time.outputTime(time.sec10), 0, 1);
                if(time.sec10 >= 6){
                    time.sec10 -= 6;
                    if(time.sec10 == 0){
                        timeS.replaceRange("0", 0, 1);
                    }
                    System.out.println(time.getSec());
                }else{
                    timeS.replaceRange(time.outputTime(time.sec10), 0, 1); 
                    System.out.println(time.getSec());
                }
            }
        });

        s1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                time.sec1 += 1;
                timeS.replaceRange(time.outputTime(time.sec1), 1, 2);
                if(time.sec1 >= 10){
                    time.sec1 -= 10;
                    if(time.sec1 == 0){
                        timeS.replaceRange("0", 1, 2);
                        timeS.replaceRange("", 2, 3);
                    }
                    System.out.println(time.getSec());
                }else{
                    timeS.replaceRange(time.outputTime(time.sec1), 1, 2); 
                    System.out.println(time.getSec());
                }
            }
        });

        reset.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                time.min10 = 0;
                time.min1 = 0;
                time.sec10 = 0;
                time.sec1 = 0;
                time.min = 0;
                time.totalSec = 0;
                timeM.replaceRange(time.outputTime(time.min10), 0, 1);
                timeM.replaceRange(time.outputTime(time.min1), 1, 2);
                timeS.replaceRange(time.outputTime(time.sec10), 0, 1);
                timeS.replaceRange(time.outputTime(time.sec1), 1, 2);
            }
        });

        start.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                time.totalSec = time.getTotalSec();
                int reTotalSec = time.totalSec;
                for(int i=0; i<reTotalSec; i++){
                    try {
                        Thread.sleep(1000);
                        time.totalSec -= 1;
                        time.sec1 -= 1;
                        timeS.replaceRange(time.outputTime(time.sec1), 1, 2);
                        if(time.sec1 < 0){
                            time.sec1 += 9;
                            time.sec10 -= 1;
                            timeS.replaceRange(time.outputTime(time.sec10), 0, 1);
                        }
                        if(time.sec10 <0){
                            time.sec10 += 5;
                            time.min1 -= 1;
                            timeM.replaceRange(time.outputTime(time.min1), 1, 2);
                        }
                        if(time.min1 < 0){
                            time.min1 += 9;
                            time.min10 -= 1;
                            timeM.replaceRange(time.outputTime(time.min10), 0, 1);
                        }
                        System.out.println(time.totalSec);
                        
                    } catch (InterruptedException f) {
                        System.out.println(f);
                    }
                }
            }
        });

        buttonLayout.add(m10);
        buttonLayout.add(m1);
        buttonLayout.add(s10);
        buttonLayout.add(s1);

        frame.setVisible(true);
    }
}