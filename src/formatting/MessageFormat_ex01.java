package formatting;

import java.text.MessageFormat;

public class MessageFormat_ex01 {

    /**
     * 활용례1. 패턴에 맞게 출력하기
     */
    static void example(){
        String ptrn = "Name : {0}\nTel: {1} \nAge: {2} \nBirthday: {3}";
        Object[] args = {
                "Junho Choi", "010-1234-5678", "26", "01-01-1970"
        };
        String result = MessageFormat.format(ptrn, args);
        System.out.println(result);
    }

    public static void main(String[] args) {
        example();
    }
}
