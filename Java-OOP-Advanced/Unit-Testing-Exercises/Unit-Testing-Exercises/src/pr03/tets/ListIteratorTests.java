package pr03.tets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pr03.models.ListIterator;
import pr03.interfaces.IListIterator;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListIteratorTests {

    private IListIterator collection;
    private List<String> elements;

    @Before
    public void initializeTestObjects() throws OperationNotSupportedException {
        this.collection = new ListIterator(new ArrayList<>());
        this.elements = new ArrayList<>();
        Collections.addAll(elements, "test", "test2");
    }

    @Test
    public void testCtorWithInitialElements() throws OperationNotSupportedException {
        this.collection = new ListIterator(this.elements);
        Assert.assertEquals(2, this.collection.getItems().size());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPassNullInCtorThrowsException() throws OperationNotSupportedException {
        this.collection = new ListIterator(null);
    }

    @Test
    public void testMoveWithNextIndex() throws OperationNotSupportedException {
        this.collection = new ListIterator(this.elements);
        Assert.assertTrue(this.collection.move());
    }

    @Test
    public void testMoveWithoutNextIndex() throws OperationNotSupportedException {
        Assert.assertFalse(this.collection.move());
    }

    @Test
    public void testHasNextWithEmptyCollection() {
        Assert.assertFalse(this.collection.hasNext());
    }

    @Test
    public void testHasNextWithCollection() throws OperationNotSupportedException {
        this.collection = new ListIterator(this.elements);
        Assert.assertTrue(this.collection.hasNext());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintWithEmptyCollection() {
        this.collection.print();
    }
}
