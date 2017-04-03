package pr04.models;

import pr04.interfaces.IBubble;
import java.util.Iterator;
import java.util.List;

public class Bubble implements IBubble{

    private List<Integer> collection;

    public Bubble(List<Integer> collection) {
        this.setCollection(collection);
    }

    private void setCollection(List<Integer> collection) {
        if (collection == null) {
            throw new IllegalArgumentException();
        }

        this.collection = collection;
    }

    private void swap(int leftElement, int rightElement, int leftIndex, int rightIndex) {

        this.collection.set(leftIndex, rightElement);
        this.collection.set(rightIndex, leftElement);
    }

    @Override
    public void sort() {
        boolean isSwapped;
        int indexOfLastUnsortedElement = this.collection.size() - 1;

        do {
            isSwapped = false;

            for (int i = 1; i <= indexOfLastUnsortedElement; i++) {
                int leftIndex = i - 1;
                int rightIndex = i;
                int leftElement = this.collection.get(leftIndex);
                int rightElement = this.collection.get(rightIndex);

                if (leftElement > rightElement) {
                    this.swap(leftElement, rightElement, leftIndex, rightIndex);
                    isSwapped = true;
                }
            }

            indexOfLastUnsortedElement -= 1;
        } while (isSwapped);
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.collection.iterator();
    }
}
