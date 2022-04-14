package oop.interface_study.multiple_extends;

import java.util.AbstractList;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;

public interface MyList<E>  extends MyCollection<E>{
    boolean add(E e);
    void clear();
    boolean contains(Object o);
    boolean remove(Object o);

    /*@Override
    default Spliterator<E> spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractList.RandomAccessSpliterator<>(this){

            };
        } else {
            return Spliterators.spliterator(this, Spliterator.ORDERED);
        }
    }*/
}
