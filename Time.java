public class Time {

    int min;
    int sec;
    int totalSec;
    String minO;
    String secO;    

    public Time(){
        min = 0;
        sec = 0;
        totalSec = 0;
        minO = "0";
        secO = "0";
    }

    public int getMin(){
        return min;
    }

    public String  outputTime(int minI){
        minO = Integer.toString(minI);
        return minO;
    }

    public int getSec(){
        return sec;
    }

    public int getTotalSec(){
        return totalSec = min*60+sec;
    }
    
}
