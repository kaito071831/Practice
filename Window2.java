import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

public class Window2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("はじめてのSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Hello Would!!");
        frame.add(label);
        JButton button = new JButton("押してね");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("押されました！");
                label.setText("押すな！押すなよ！");
            }
        });
        //button.addActionListener(new EventListenner());//ボタンを押された時にEventListennerを呼び出す
        frame.add(button);

        frame.setVisible(true);
        System.out.println("フレームを表示");
    }
}
