package pr01.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pr01.interfaces.IPerson;
import pr01.models.Database;
import pr01.interfaces.IDatabase;
import pr01.models.Person;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {

    private static final int DEFAULT_CAPACITY = 16;

    private IDatabase database;
    private IPerson[] persons;

    @Before
    public void initializeTestObjects() throws OperationNotSupportedException {
        this.persons = new IPerson[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            this.persons[i] = new Person((long)i, "test" + i);
        }

        this.database = new Database(this.persons);
    }

    @Test
    public void testCtorWithInitialElements() throws OperationNotSupportedException {
        this.database = new Database(this.persons);
        Assert.assertEquals(DEFAULT_CAPACITY, database.getStoredItems().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseLowerLengthThrowsException()
            throws OperationNotSupportedException {

        this.persons = new IPerson[]{new Person(0L, "test")};
        this.database = new Database(this.persons);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElementThrowsException() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        this.database.remove();
        Assert.assertEquals(null, database.getStoredItems()[DEFAULT_CAPACITY - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < DEFAULT_CAPACITY + 1; i++) {
            this.database.remove();
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonWithSameIdThrowsException() throws OperationNotSupportedException {
        this.database.remove();
        this.database.add(new Person(0L, "tets"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByInexistentUsernameThrowsException() throws OperationNotSupportedException {
        this.database.findByUsername("test20");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByNullUsernameThrowsException() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByInexistentIdThrowsException() throws OperationNotSupportedException {
        this.database.findById(20);
    }

    @Test
    public void testAddPerson() throws OperationNotSupportedException {
        this.database.remove();
        this.database.add(new Person(20L, "test20"));
    }

    @Test
    public void testFindByIdPerson() throws OperationNotSupportedException {
        IPerson person = this.database.findById(0L);
        Assert.assertTrue(person.getId() == 0L && person.getUsername().equals("test0"));
    }

    @Test
    public void testFindByUsernamePerson() throws OperationNotSupportedException {
        IPerson person = this.database.findByUsername("test0");
        Assert.assertTrue(person.getId() == 0L && person.getUsername().equals("test0"));
    }
}
