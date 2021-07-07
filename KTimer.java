import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer
 * @author kaito071831
 */
public class KTimer {
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
        
        JTextArea timeM = new JTextArea(1, 10);
        timeM.setText("00");
        
        JTextArea timeS = new JTextArea(1, 10);
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
        m10.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){

                time.min += 10;

                if(time.min >= 60){
                    time.min -= 60;
                    time.minO = Integer.toString(time.min);
                    timeM.replaceRange("0" + time.minO, 0, 2);
                }else{
                    time.minO = Integer.toString(time.min);
                    timeM.replaceRange(time.minO, 0, time.minO.length());
                }

            }
        });

        //1分追加ボタンのイベント処理
        m1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){

                time.min += 1;
                
                if(time.min >= 60){
                    time.min -= 60;
                }

                time.minO = Integer.toString(time.min);

                if(time.minO.length() < 2){
                    timeM.replaceRange(time.minO, 1, time.minO.length() + 1);
                }else{
                    timeM.replaceRange(time.minO, 0, time.minO.length());
                }

            }
        });

        //10秒追加ボタンのイベント処理
        s10.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){

                time.sec += 10;

                if(time.sec >= 60){
                    time.sec -= 60;
                    time.secO = Integer.toString(time.sec);
                    timeS.replaceRange("0" + time.secO, 0, 2);
                }else{
                    time.secO = Integer.toString(time.sec);
                    timeS.replaceRange(time.secO, 0, time.secO.length());
                }

            }
        });

        //1秒追加ボタンのイベント処理
        s1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){

                time.sec += 1;
                
                if(time.sec >= 60){
                    time.sec -= 60;
                }

                time.secO = Integer.toString(time.sec);

                if(time.secO.length() < 2){
                    timeS.replaceRange(time.secO, 1, time.secO.length() + 1);
                }else{
                    timeS.replaceRange(time.secO, 0, time.secO.length());
                }
                
            }
        });

        //リセットボタンのイベント処理
        reset.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                
                time.min = 0;
                time.sec = 0;

                timeM.replaceRange("00", 0, timeM.getText().length());
                timeS.replaceRange("00", 0, timeS.getText().length());
            
            }
        });

        //スタートボタンのイベント処理
        start.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){

                Timer timer = new Timer();

                TimerTask task = new TimerTask(){
                    public void run(){

                        time.sec--;

                        //秒数が0未満になるとき分を1減らして秒数を59増やす
                        if(time.sec < 0){
                            time.sec += 60;
                            time.min--;
                            time.minO = Integer.toString(time.min);

                            //分が1桁になったときは0+分で出力する。そうでなければ通常通り出力する
                            if(time.min < 10){
                                timeM.replaceRange("0" + time.minO, 0, time.minO.length() + 1);
                            }else{
                                timeM.replaceRange(time.minO, 0, time.minO.length());
                            }

                            //分数が0未満のとき分の出力エリアの表示を00で固定する
                            if(time.min < 0){
                                timeM.replaceRange("00", 0, time.minO.length());
                            }

                        }

                        time.secO = Integer.toString(time.sec);                        

                        //分が1桁になったときは0+分で出力する。そうでなければ通常通り出力する
                        if(time.sec < 10){
                            timeS.replaceRange("0" + time.secO, 0, time.secO.length() + 1);
                        }else{
                            timeS.replaceRange(time.secO, 0, time.secO.length());
                        }

                        //分と秒が0になったときtimerのスケジュールをキャンセルする
                        if(time.min == 0 && time.sec == 0){
                            timer.cancel();
                        }

                        //停止ボタンが押されたときtimerのスケジュールをキャンセルする
                        stop.addMouseListener(new MouseAdapter(){
                            public void mouseClicked(MouseEvent e){
                                timer.cancel();
                            }
                        });

                    }
                };
                
                timer.schedule(task, 1000, 1000);

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
