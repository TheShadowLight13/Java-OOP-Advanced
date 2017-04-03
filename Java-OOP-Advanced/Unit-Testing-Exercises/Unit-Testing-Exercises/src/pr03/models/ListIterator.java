package pr03.models;

import pr03.interfaces.IListIterator;

import javax.naming.OperationNotSupportedException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListIterator implements IListIterator{

    private List<String> innerCollection;
    private int currIndex;

    public ListIterator(List<String> collection) throws OperationNotSupportedException {
        this.setInnerCollection(collection);
        this.currIndex = 0;
    }

    private void setInnerCollection(List<String> collection)
            throws OperationNotSupportedException {

        if (collection == null) {
            throw new OperationNotSupportedException();
        }

        this.innerCollection = collection;
    }

    @Override
    public boolean move() {
        if (this.hasNext()) {
            this.currIndex++;
            return true;
        }

        return false;
    }

    @Override
    public boolean hasNext() {
        if (this.currIndex + 1 < this.innerCollection.size()) {
            return true;
        }

        return false;
    }

    @Override
    public void print() {
        if (this.innerCollection.isEmpty()) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        System.out.println(this.innerCollection.get(this.currIndex));
    }

    @Override
    public List<String> getItems() {
        return Collections.unmodifiableList(this.innerCollection);
    }

    @Override
    public Iterator<String> iterator() {
        return this.innerCollection.iterator();
    }
}
