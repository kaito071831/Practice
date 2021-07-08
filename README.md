# Practice port
## ポートフォリオ作成を行うためのリポジトリ
### 基本的にはKTimerをメインで作成している。
<br>

## Window
### 入門書を読んで写経しただけのJavaファイル
<br>

## KTimer
### GUI入門として自分で考えて作っているキッチンタイマーのJavaファイルのメインクラス。GUIの作成やイベントの処理を行っている。
<br>

## Time
### キッチンタイマーの時間についての変数とメソッドを持つ。
<br>

## 機能完成後の変更点

|日付|更新内容|
|----|-------|
|2021/7/8|[java.util.Timer](https://docs.oracle.com/javase/jp/8/docs/api/java/util/Timer.html)と[java.util.TimerTask](https://docs.oracle.com/javase/jp/8/docs/api/java/util/TimerTask.html)を使用していたが[javax.swing.Timer](https://docs.oracle.com/javase/jp/8/docs/api/javax/swing/Timer.html)に変更した。|
|2021/7/8|セットされているタイマーの時刻の出力を[JTextArea](https://docs.oracle.com/javase/jp/8/docs/api/javax/swing/JTextArea.html)を利用して行っていたがテキストエリアにユーザーが入力することがないため[JLabel](https://docs.oracle.com/javase/jp/8/docs/api/javax/swing/JLabel.html)に変更した。それに伴って時間出力の処理も変更した。|
|2021/7/8|タイマーが0になったときに音とダイアログが出るようにした。音は[java.awt.Toolkit](https://docs.oracle.com/javase/jp/8/docs/api/java/awt/Toolkit.html)を用いて実装した。ダイアログは[javax.swing.JOptionPane](https://docs.oracle.com/javase/jp/8/docs/api/javax/swing/JOptionPane.html)を用いて実装した。|

