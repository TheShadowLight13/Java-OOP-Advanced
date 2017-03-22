package pr01;

import pr01.interfaces.IListyIterator;

import java.util.*;

public class ListyIterator<T> implements IListyIterator<T> {

    private List<T> items;
    private int index;

    public ListyIterator(T... args) {
        items = Arrays.asList(args);
        index = 0;
    }

    public List<T> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean move() {
        if (this.hasNextIndex()) {
            this.index++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hasNextIndex() {
        return this.index + 1 < this.getItems().size();
    }

    @Override
    public void print() {
        if (this.getItems().isEmpty()) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        System.out.println(this.getItems().get((this.getIndex())));
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<T>{
        private int index;

        public CustomIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < items.size();
        }

        @Override
        public T next() {
            return items.get(this.index++);
        }
    }
}
