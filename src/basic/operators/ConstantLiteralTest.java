package basic.operators;

public class ConstantLiteralTest {
    public static void main(String[] args) {
        final int a = 1_000_000;
        final int b = 1_000_000;

        /* 문제가 없는 이유, 'a'+1이 리터럴간 연산이라 */
        // 상수 또는 리터럴 간의 연산은 실행 과정동안 변하는 값이 아니라, 컴파일 시, 컴파일러가 계산하여 그 결과로 대체. 코드를 효율적으로
        char c1 = 'a'+1; // b 로 계산
        long c = 1_000_000L * 1_000_000L; // 물론 연산 결과의 리터럴이 저장하려는 type의 리터럴에 저장이 될 수 있어야 함.
        System.out.println(c);
    }
}
