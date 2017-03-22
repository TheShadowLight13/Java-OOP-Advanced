package p07;

import java.text.Collator;
import java.util.*;

public class CustomListImpl<T extends Comparable<T>> implements ICustomList<T> {

    private List<T> customList;

    public CustomListImpl() {
        this.customList = new ArrayList<>();
    }

    @Override
    public List<T> getCustomList() {
        return Collections.unmodifiableList(this.customList);
    }

    @Override
    public void add(T element) {
        this.customList.add(element);
    }

    @Override
    public T remove(int index) {
        return this.customList.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.customList.contains(element);
    }

    @Override
    public void swap(int initialIndex, int swapIndex) {
        T initialIndexElement = this.customList.get(initialIndex);
        T swapIndexElement = this.customList.get(swapIndex);

        this.customList.set(initialIndex, swapIndexElement);
        this.customList.set(swapIndex, initialIndexElement);
    }

    @Override
    public int countGreaterThat(T element) {
        int greaterCount = 0;

        for (T currElement : this.customList) {
            if (currElement.compareTo(element) > 0) {
                greaterCount++;
            }
        }

        return greaterCount;
    }

    @Override
    public T getMax() {
        return Collections.max(this.customList, Collator.getInstance());
    }

    @Override
    public T getMin() {
        return Collections.min(this.customList, Collator.getInstance());
    }

    @Override
    public Iterator<T> iterator() {
        return customList.iterator();
    }
}
