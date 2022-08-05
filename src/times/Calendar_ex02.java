package times;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Calendar_ex02 {

    /**
     * UTC와 KST를 타임존으로 갖는 두 인스턴스를 만들고 싶은데,
     * 둘다 로컬 타임으로 나오는 잘못된 예시의 경우
     */
    public static void example01(){
        Calendar uk = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.UK);
        Calendar seoul = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        Date uk_now = uk.getTime();
        Date seoul_now = seoul.getTime();

        // 비록 uk 참조변수가 갖는 TimeZone은 UTC 이지만, Date 클래스로 변환되면서 local의 Default Timezone으로 변환되어 출력됨
        System.out.println("Case1 -");
        System.out.println(uk_now);
        System.out.println(seoul_now);
    }

    /**
     * 명시적으로 DateFormat 클래스에 대해, setTimeZone(출력되는 시간에 대해), Locale(출력되는 언어에 대해) 설정할 필요가 있다.
     * Calender 객체가 갖는 time 필드는 로컬에 대한 getTime()을 바탕으로
     * Date(getTimeInMillis())를 반환하게 됨
     */
    public static void example02(){
        TimeZone tz = TimeZone.getTimeZone("UTC");
        Calendar uk = Calendar.getInstance(tz, Locale.UK);
        SimpleDateFormat sdf_uk = new SimpleDateFormat("EEE MMM/dd/yyyy HH:mm:ss zzz", Locale.US);
        sdf_uk.setTimeZone(TimeZone.getTimeZone("UTC"));

        System.out.println("Case2 -");
        System.out.println("Time zone: " + tz.getID());
        System.out.println("default time zone: " + TimeZone.getDefault().getID());
        System.out.println();

        System.out.println("UTC:     " + sdf_uk.format(uk.getTime()));
        System.out.println("Default: " + Calendar.getInstance().getTime());

        System.out.println(sdf_uk.format(uk.getTime()));
        System.out.println();
    }

    public static void main(String[] args) {
        example01();
        example02();
    }
}
