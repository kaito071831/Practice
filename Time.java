public class Time {

    int min1;
    int min10;
    int sec1;
    int sec10;
    int min;
    int sec;
    int totalSec;
    String minO;
    String secO;    

    public Time(){
        min1 = 0;
        min10 = 0;
        sec1 = 0;
        sec10 = 0;
        totalSec = 0;
    }

    public int getMin(){
        min = min10*10 + min1;
        return min;
    }

    public String  outputTime(int minI){
        minO = Integer.toString(minI);
        return minO;
    }

    public int getSec(){
        sec = sec10*10 + sec1;
        return sec;
    }

    public int getTotalSec(){
        return totalSec = min*60+sec;
    }
    
}
