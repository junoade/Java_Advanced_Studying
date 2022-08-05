package formatting;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

public class DecimalFormat_ex01 {
    static int num2;
    final static Integer NUM3 = Integer.valueOf("12313123");

    final String[] PTRN_SYMBOLS = new String[]{
         /* 설명 생략 */
            "0",    "#",    ".",    "-",    "-",    ".",

         /* 지수     구분자    퍼센트   퍼밀(퍼센트x10)   통화기호   escape문자*/
            "E",    ";",    "%",    "\u2030",   "\u00A4",   "'"
    };

    static void example() {
        int num1 = 9123;
        // Integer num4 = null;

        DecimalFormat df = new DecimalFormat("####");
        DecimalFormat df2 = new DecimalFormat("0000");

        System.out.println("Example : Basic Pattern Symbol Test");
        System.out.println(df.format(num1)); // 9123 그대로
        System.out.println(df.format(num2)); // 0으로
        System.out.println(df2.format(num2)); // 0000 으로
        System.out.println(df2.format(NUM3)); // 12313123 그대로
        // System.out.println(df2.format(num4)); // null 인 Object는 java.lang.IllegalArgumentException을 throw함
    }

    static void example2(){
        double num = 123.123123;

        DecimalFormat df = new DecimalFormat("\u2030");
        System.out.println("Example : Unicode Symbol Test");
        System.out.println(df.format(num)); // ‰num2
    }

    static void exampleCurrencyLocale(){
        double num = 123.123123;
        DecimalFormat df = new DecimalFormat("\u2030");
        df = new DecimalFormat("#\u00A4");

        System.out.println("Example : Currency Symbol Test which is affected by Locale Config");
        System.out.println(df.format(num));
        df.setCurrency(Currency.getInstance(Locale.UK));
        System.out.println(df.format(num));
    }

    public static void main(String[] args) {
        example();
        example2();
        exampleCurrencyLocale();
    }

}
