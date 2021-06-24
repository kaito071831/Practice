public class Time {
    int min;
    int sec;
    int totalSec;

    public int getMin(){
        return min;
    }

    public int getSec(){
        return sec;
    }

    public int getTotalSec(){
        return totalSec = min*60+sec;
    }
    
}
