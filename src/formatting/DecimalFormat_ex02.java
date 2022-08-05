package formatting;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * 기호와 문자가 포함된 문자열을 숫자로 쉽게 변환할 수 있다.
 */
public class DecimalFormat_ex02 {
    static void example() {
        DecimalFormat df = new DecimalFormat("#,###.##");
        DecimalFormat df2 = new DecimalFormat("#.###E0");
        DecimalFormat df3 = new DecimalFormat("#"); // ,#
        String input = "1,234,567.89";

        System.out.println("Example : 기호와 문자가 포함된 문자열을 숫자로 쉽게 변환할 수 있다. ");
        try {
            Number num = df.parse(input); // ParseException Handling 필요
            Number num2 = df3.parse(input);
            double d = num.doubleValue();
            double d2 = num2.doubleValue();

            System.out.print(input + " -> ");
            System.out.print(d + " -> ");
            System.out.println(df2.format(d));
            System.out.println("주의! 반복되는 , 기호를 패턴에 포함해줘야 올바르게 됨! " + input + " -> " + d2); // 1.0 이 되어버림

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        example();
    }
}
