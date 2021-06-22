import javax.swing.*;

/**
 * @author kaito071831
 * @since 2021/06/22
 */
public class Window {
    public static void main(String[] args) {
        JFrame frame = new JFrame("はじめてのSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        frame.setLayout(null);
        JLabel label = new JLabel("Hello Would!!");//ラベル作成
        label.setLocation(10, 10);//ラベルの座標設定
        label.setSize(200, 20);//ラベルのサイズ設定
        frame.add(label);//フレームに追加
        JButton button = new JButton("押してね");//ボタン生成
        button.setLocation(250, 100);//ボタンの座標設定
        button.setSize(100, 20);//ボタンのサイズ設定
        frame.add(button);//フレームに追加

        frame.setVisible(true);
        System.out.println("フレームを表示");
    }
}