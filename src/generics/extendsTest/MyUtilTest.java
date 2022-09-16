package generics.extendsTest;

public class MyUtilTest {
    public static void main(String[] args){
        int num1 = 100;
        int num2 = 200;
        long num3 = 400L;
        long num4 = 100L;
        String str1 = "Hello";
        String str2 = "Jello";
        Double num5 = 1000.0;
        Double num6 = 999.0;

        System.out.println(MyUtil.compare(num1, num2));
        System.out.println(MyUtil.compare(num3, num4));
        System.out.println(MyUtil.compare(str1, str2));
        System.out.println(MyUtil.compare(num5, num6));
    }
}
