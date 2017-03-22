package pr04;

import pr04.interfaces.ILake;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake<T> implements ILake<T>{
    private List<T> items;

    public Lake() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        this.items.add(element);
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<T> {
        private int index;

        public Frog() {
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
