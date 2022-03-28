package example;

/**
 *  자바에서 i = i + 1 과 i++의 차이점
 *  JVM 에서 사용하는 명령어가 서로 다름
 *  -> i = i + 1 의 경우 iadd 명령어
 *  -> i++ 의  경우 iinc 명령어
 *  그리고 i += 1 의 경우 타입 조심해야함
 */
public class IncrementTest_220329 {
    public static void main(String[] args){
        short s = 1;

        // s = s + 1; // possible lossy conversion from int to short
        // ILOAD 1 ICONST_1 IADD ISTORE 1

        // s += 1; 왜 이건 괜찮을까 -> s++ 인스터럭션 과 같이 처리 IINC 1 1


        System.out.println(s);
    }
}
