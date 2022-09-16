package generics.wildcardTest;

public class Course<T> {
    private String name;
    private T[] enrollers;
    private int cursor;

    public Course(String name, int capacity) {
        this.name = name;
        enrollers = (T[]) (new Object[capacity]); // 제네릭 타입 배열을 생성하려면 이렇게 또는,
        // 또는 Replection API 활용
        // participants = (T[]) java.lang.reflect.Array.newInstance(participants.getClass().getComponentType(), capacity);
    }

    public String getName() { return name; }
    public T[] getEnrollers() { return enrollers; }

    public boolean add(T t){
        if(isFull()){
            getSpatial();
        }
        enrollers[cursor++] = t;
        return true;
    }

    public boolean isEmpty(){ return cursor == 0; }
    public boolean isFull(){ return cursor == enrollers.length; }

    void getSpatial(){
        int capacity = enrollers.length;
        T[] temp = (T[]) (new Object[2 * capacity]);
        System.arraycopy(enrollers, 0, temp, 0, capacity); // O(N)
        enrollers = temp;
    }
}
