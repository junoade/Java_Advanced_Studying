package times;

import java.util.Calendar;
import java.util.Date;

public class Calendar_ex01 {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        Date date = new Date(today.getTimeInMillis()); // getTimeInMillis(), UTC 1970-01-01 기준
        System.out.println(date.getTime());
        System.out.println(today.get(Calendar.YEAR));
        System.out.println(today.get(Calendar.MONTH));

        /* Timezone 찾기 milliSecond로 반환되기 때문에, */
        final int HOUR_IN_MILLIS = 60*60*1000;
        System.out.println(today.get(Calendar.ZONE_OFFSET)/HOUR_IN_MILLIS);
    }
}
