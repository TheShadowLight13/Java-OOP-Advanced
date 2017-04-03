package pr01.tests;

import org.junit.Assert;
import org.junit.Test;
import pr01.interfaces.IPerson;
import pr01.models.Person;

import javax.naming.OperationNotSupportedException;

public class PersonTests {

    @Test(expected = OperationNotSupportedException.class)
    public void testNullIdThrowsException() throws OperationNotSupportedException {
        IPerson person = new Person(null, "test");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testNegativeIdThrowsException() throws OperationNotSupportedException {
        IPerson person = new Person(-1L, "test");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testNullUsernameThrowsException() throws OperationNotSupportedException {
        IPerson person = new Person(0L, null);
    }

    @Test
    public void testGetIdReturnsCorrectId() throws OperationNotSupportedException {
        IPerson person = new Person(0L, "test");
        Assert.assertEquals("Wrong id", 0L, person.getId());
    }

    @Test
    public void testGetUsernameReturnsCorrectUsername() throws OperationNotSupportedException {
        IPerson person = new Person(0L, "test");
        Assert.assertEquals("Wring username", "test", person.getUsername());
    }
}
