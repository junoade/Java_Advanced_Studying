package basic.operators;

public class RoundDownTest {
    public static void main(String[] args){
        float pi = 3.141592f;
        /* 소수점 세자리에서 내림하기 */
        float roundDownPi = (int)(pi * 1000) / 1000f; // 3145.92f 가 되었다가, 3145가 되고, /1000f 연산 수행
        float roundPi = (int)(pi * 1000 + 0.5) / 1000f; // 0.5를 추가해줌

        /* Math 클래스의 round, ceil(올림), floor(내림) */
        float roundDownPi2 = (float) Math.floor(pi * 1000.0) /1000.0f;

        /* String 클래스의 format 이용한 반올림 방법 */
        String roundDownPi3 = String.format("%.3f", pi);

        System.out.printf("(int) 형변환을 이용한 내림 방법 : %f\n", roundDownPi);
        System.out.printf("(int) 형변환을 이용한 반올림 방법 : %f\n", roundPi);
        System.out.printf("Math 유틸리티 활용한 내림 방법 : %f\n", roundDownPi2);
        System.out.printf("String format 메소드 활용한 반올림 방법 %s\n", roundDownPi3);
    }
}
