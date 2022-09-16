package generics.methodTest01;

public class GenericMethod02<T> {

    /**
     * 인스턴스를 생성하는 시점의 타입으로 모두 고정되어, 인자로 해당 타입로만 전달 받아야 한다.
     */
    public Box<T> boxing(T t){
        Box<T> result = new Box<>();
        result.set(t);
        return result;
    }

    /**
     * 인스턴스를 생성할 때 타입과 다르게, 호출 시의 타입을 전달받을 수 있음
     * @param t
     * @param <t>
     * @return
     */
    public <t> Box<t> boxing2(t t){
        Box<t> result = new Box<>();
        result.set(t);
        return result;
    }
}
