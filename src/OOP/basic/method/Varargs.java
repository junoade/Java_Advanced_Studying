package OOP.basic.method;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 자바에서의 가변인자와 메소드 오버로딩
 * 자바의 정석 p287
 *
 * 기본 형태 Type ... Name
 *
 */
public class Varargs {

    /* step 1) 가변인자를 활용하여 String 타입의 모든 인자를 concat 연산하여 반환하도록 작성함 */
    public String concatenate(String ... str){
        Iterator<String> cursor = Arrays.stream(str).iterator();
        StringBuilder result = new StringBuilder();
        while(cursor.hasNext()){
            result.append(cursor.next());

        }
        return result.toString();
    }

    /* note01) 가변인자는 내부적으로 배열을 이용한다. */
    // 메소드 오버로딩 조건에는 안되지만.
    // 그러나 배열을 매개 변수로 전달하는 것과 차이가 있다.
    // public String concatenate(String[] str){ }
    public String failed_concat_note1(String[] str){
        return concatenate(str);
    }

    /* note02) 가변인자를 활용시, 같은 타입의 이름이 다른 변수를 쓴다해서 메소드 오버로딩이 되지 않음을 주의 */
    public String failed_concat(String delim, String ... str){
        return concatenate(delim)+ Arrays.toString(str);
    }
    public String failed_concat(String ... str){
        return concatenate(str);
    }

}
