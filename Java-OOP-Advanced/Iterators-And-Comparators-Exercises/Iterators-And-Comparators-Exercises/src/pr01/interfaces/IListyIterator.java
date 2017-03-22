package pr01.interfaces;

public interface IListyIterator<T> extends Iterable<T>{
    boolean move();

    boolean hasNextIndex();

    void print();
}
