package book_review.theProgrammersBrain.ch1;

/**
 * 1) LTM 에서 관련된 지식 인출?
 * 2) LTM 에서 어떤 정보 인출?
 * 3) STM 에 정보 저장?
 * 4) STM 에 구체적으로 어떤 정보 저장?
 * 5) 관련이 없어 보여 무시하고 넘아가는 정보 존재?
 * 6) 코드의 특정 부분을 광범위하게 작업 기억 공간을 사용해 분석하는가?
 * 7) 코드의 어떤 부분이 작업 기억 공간에 과부하를 주는가?
 * 8) 코드의 그 부분들이 작업 기억 공간을 어떻게 사용하는지 이해?
 */

public class example2_Luhn {
    public static void main(String[] args) {
        String test = "49927398716";
        System.out.println(luhnTest(test));
    }

    public static boolean luhnTest(String number) {
        int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(number).reverse().toString();
        for (int i = 0; i < reverse.length(); i++) {
            int digit = Character.digit(reverse.charAt(i), 10);
            System.out.println(digit);
            if (i % 2 == 0) {
                s1 += digit;
            } else {
                s2 += 2 * digit;
                if (digit >= 5) {
                    s2 -= 9;
                }
            }
            System.out.printf("s1 : %d, s2 : %d \n", s1, s2);
        }
        return (s1 + s2) % 10 == 0;
    }
}
