package pr03;

import pr03.interfaces.IStack;

import java.util.*;

public class Stack<T> implements IStack<T> {
    private List<T> items;

    public Stack() {
        this.items = new ArrayList<>();
    }

    public List<T> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    @Override
    public void push(T element) {
        this.items.add(0, element);
    }

    @Override
    public T pop() {
        if (this.getItems().isEmpty()) {
            throw new IllegalArgumentException("No elements");
        }

        return this.items.remove(0);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int index;

        public StackIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < items.size();
        }

        @Override
        public T next() {
            return items.get(index++);
        }
    }
}
