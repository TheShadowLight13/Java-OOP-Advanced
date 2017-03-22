package pr03;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>{

    @Override
    public int compare(Book firstElement, Book secondElement) {
        return firstElement.compareTo(secondElement);
    }
}
