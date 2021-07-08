import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Timer
 * @author kaito071831
 */
public class KTimer{
    public static void main(String[] args) {

        //フレームを生成
        JFrame frame = new JFrame("キッチンタイマー");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        //時間出力部分をtimeIOパネルに追加してパネルをフレームに追加
        JPanel timeIO = new JPanel();
        timeIO.setLayout(new FlowLayout());
        
        JLabel timeMl = new JLabel("分");
        JLabel timeSl = new JLabel("秒");
        
        JLabel timeM = new JLabel();
        timeM.setText("00");
        
        JLabel timeS = new JLabel();
        timeS.setText("00");
        
        timeIO.add(timeM);
        timeIO.add(timeMl);
        timeIO.add(timeS);
        timeIO.add(timeSl);
        frame.add(timeIO, BorderLayout.NORTH);

        //タイマー操作ボタンをactionパネルに追加してからフレームに設定
        JButton reset = new JButton("Reset");
        frame.add(reset, BorderLayout.WEST);

        JPanel action = new JPanel();
        action.setLayout(new BoxLayout(action, BoxLayout.Y_AXIS));
        frame.add(action, BorderLayout.EAST);

        JButton start = new JButton("開始");
        start.setMaximumSize(new Dimension(80,80));
        action.add(start);
        
        JButton stop = new JButton("停止");
        stop.setMaximumSize(new Dimension(80,80));
        action.add(stop);

        //時間設定ボタン定義する。buttonAパネルにbuttonLayoutパネルを追加してフレームに設定
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

        //時間の値を設定するためにコンストラクタ生成
        Time time = new Time();

        //10分追加ボタンのイベント処理
        m10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                time.min += 10;

                if(time.min >= 60){
                    time.min -= 60;
                    time.minO = Integer.toString(time.min);
                    timeM.setText("0" + time.minO);
                }else{
                    time.minO = Integer.toString(time.min);
                    timeM.setText(time.minO);
                }

            }
        });

        //1分追加ボタンのイベント処理
        m1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                time.min += 1;
                
                if(time.min >= 60){
                    time.min -= 60;
                }

                time.minO = Integer.toString(time.min);

                if(time.minO.length() < 2){
                    timeM.setText("0" + time.minO);
                }else{
                    timeM.setText(time.minO);
                }

            }
        });

        //10秒追加ボタンのイベント処理
        s10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                time.sec += 10;

                if(time.sec >= 60){
                    time.sec -= 60;
                    time.secO = Integer.toString(time.sec);
                    timeS.setText("0" + time.secO);
                }else{
                    time.secO = Integer.toString(time.sec);
                    timeS.setText(time.secO);
                }

            }
        });

        //1秒追加ボタンのイベント処理
        s1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                time.sec += 1;
                
                if(time.sec >= 60){
                    time.sec -= 60;
                }

                time.secO = Integer.toString(time.sec);

                if(time.secO.length() < 2){
                    timeS.setText("0" + time.secO);
                }else{
                    timeS.setText(time.secO);
                }
                
            }
        });

        //リセットボタンのイベント処理
        reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                time.min = 0;
                time.sec = 0;

                timeM.setText("00");
                timeS.setText("00");
            
            }
        });

        //スタートボタンのイベント処理
        start.addActionListener(new ActionListener(){

            Timer timer = new Timer(1000, this);

            public void actionPerformed(ActionEvent e){

                timer.start();

                time.sec--;

                //秒数が0未満になるとき分を1減らして秒数を59増やす
                if(time.sec < 0){
                    time.sec += 60;
                    time.min--;
                    time.minO = Integer.toString(time.min);

                    //分が1桁になったときは0+分で出力する。そうでなければ通常通り出力する
                    if(time.min < 10){
                        timeM.setText("0" + time.minO);
                    }else{
                        timeM.setText(time.minO);
                    }

                    //分数が0未満のとき分の出力エリアの表示を00で固定する
                    if(time.min < 0){
                        timeM.setText("00");
                    }

                }

                time.secO = Integer.toString(time.sec);                        

                //秒が1桁になったときは0+秒で出力する。そうでなければ通常通り出力する
                if(time.sec < 10){
                    timeS.setText("0" + time.secO);
                }else{
                    timeS.setText(time.secO);
                }

                //分と秒が0になったときtimerのスケジュールをキャンセルする
                if(time.min == 0 && time.sec == 0){
                    timer.stop();
                }

                //停止ボタンが押されたときtimerのスケジュールをキャンセルする
                stop.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        timer.stop();
                    }
                });

            }
        });

        //時間設定ボタンをbuttonLayoutパネルに追加
        buttonLayout.add(m10);
        buttonLayout.add(m1);
        buttonLayout.add(s10);
        buttonLayout.add(s1);

        frame.setVisible(true);
    }    
}
