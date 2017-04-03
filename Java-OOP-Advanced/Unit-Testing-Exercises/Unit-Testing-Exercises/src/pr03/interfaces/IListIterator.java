package pr03.interfaces;

import java.util.List;

public interface IListIterator extends Iterable<String>{

    boolean move();

    boolean hasNext();

    void print();

    List<String> getItems();

}
