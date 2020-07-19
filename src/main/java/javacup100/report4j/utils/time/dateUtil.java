package javacup100.report4j.utils.time;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class dateUtil {
    public  static String toDateString(long time){
        String format="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(time);
    }
    public static String toTimeString(double seconds){
        double second;
        int minute;
        int hour;
        DecimalFormat df= new DecimalFormat("0.00");
        hour=(int)(seconds/3600);
        minute=(int)(seconds%3600)/60;
        second=seconds%60;
        return hour+" h "+minute+" m "+df.format(second)+" s";
    }

    public static void main(String[] args) {
        System.out.println(toTimeString(836131.89898));
    }
}
