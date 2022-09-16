package generics.methodTest01;


public class GenericMethod01 {
    /* 제네릭 메소드를 사용 */
    public static <T> Box<T> boxing(T t){
        Box<T> result = new Box<T>();
        result.set(t);
        return result;
    }
}
