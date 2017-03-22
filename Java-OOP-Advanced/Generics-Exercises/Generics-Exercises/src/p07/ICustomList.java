package p07;

import java.util.Comparator;
import java.util.List;

public interface ICustomList<T> extends Iterable<T>{
    List<T> getCustomList();
    void add(T element);
    T remove(int index);
    boolean contains(T element);
    void swap(int initialIndex, int swapIndex);
    int countGreaterThat(T element);
    T getMax();
    T getMin();
}
