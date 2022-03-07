package OOP.basic.method;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 메소드 실행흐름 테스트
 * - 같은 클래스 내의 메소드 끼리는 참조변수를 사용하지 않더라도, 서로 호출이 가능하다
 * - static 메소드의 경우엔 같은 클래스에 선언된 인스턴스 메소드를 호출할 수 없다.
 * 왜? static 메소드의 호출 시점에 해당 인스턴스가 생성되지 않을 수 있기 때문
 */
public class MethodTest_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        MyMath myMath = new MyMath();
        System.out.println(myMath.special_op(x,y));
        System.out.println(MyMath.special_static_op(x,y));

    }

    public static class MyMath {

        long add(long x, long y) {
            return x + y;
        }

        long subtract(long x, long y) {
            return x - y;
        }

        long multiply(long x, long y) {
            return x * y;
        }

        double divide(double x, double y) {
            return x / y;
        }

        long special_op(long x, long y){
            return multiply(add(x,y), y);
        }

        static long special_static_op(long x, long y){
            // Non-static method 'multiply(long, long)' cannot be referenced from a static context
            // return multiply(add(x,y), y);
            return (x+y)*y;
        }

    }
}
