package oop.interface_study.multiple_extends;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface MyCollection<E> extends MyIterable<E>{

    boolean add(E e);
    void clear();
    boolean contains(Object o);
    boolean remove(Object o);

    default Stream<E> parallelStream() {
        return StreamSupport.stream(spliterator(), true);
    }

    /*@Override
    default Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 0); // this는 해당 인터페이스를 구현하는 구현 객체의 인스턴스를 가르킴
    }*/

}
