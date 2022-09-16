package generics.extendsTest;

public class MyUtil {

    /**
     * 해당 메소드에서 사용하는 타입 파라미터는 Comparable 구현된 T로 제한한다.
     * 만약 primitive type이 전달되면, 해당 타입에 맞는 Boxed Type으로 AutoBoxing한다.
     * @param t1
     * @param t2
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int compare(T t1, T t2){
        return t1.compareTo(t2);
    }
}
