package pr01.models;

import pr01.interfaces.IDatabase;
import pr01.interfaces.IPerson;

import javax.naming.OperationNotSupportedException;

public class Database implements IDatabase{

    private static final int DEFAULT_SIZE = 16;

    private IPerson[] innerCollection;
    private int nextIndex;

    public Database(IPerson... elements) throws OperationNotSupportedException {
        this.nextIndex = 0;
        this.initializeInnerCollection(elements);
    }

    private void initializeInnerCollection(IPerson[] elements)
            throws OperationNotSupportedException {

        if (elements == null || elements.length != DEFAULT_SIZE) {
            throw new OperationNotSupportedException();
        }

        this.innerCollection = new IPerson[DEFAULT_SIZE];
        for (IPerson element : elements) {
            this.add(element);
        }
    }

    private boolean isPersonExist(IPerson element) {
        long personId = element.getId();
        String personUsername = element.getUsername();

        for (IPerson person : this.innerCollection) {
            if (person != null) {
                if (personId == person.getId() || personUsername.equals(person.getUsername())) {
                    return true;
                }
            }
        }

        return false;
    }

    private IPerson getPersonByUsername(String username) {
        for (IPerson person : this.innerCollection) {
            if (person != null) {
                if (person.getUsername().equals(username)) {
                    return person;
                }
            }
        }

        return null;
    }

    private IPerson getPersonById(long id) {
        for (IPerson person : this.innerCollection) {
            if (person != null) {
                if (person.getId() == id) {
                    return person;
                }
            }
        }

        return null;
    }

    @Override
    public void add(IPerson element) throws OperationNotSupportedException {
        if (element == null || this.nextIndex >= this.innerCollection.length) {
            throw new OperationNotSupportedException();
        }

        if (this.isPersonExist(element)) {
            throw new OperationNotSupportedException();
        }

        this.innerCollection[nextIndex++] = element;
    }

    @Override
    public void remove() throws OperationNotSupportedException {
        if (this.nextIndex <= 0) {
            throw new OperationNotSupportedException();
        }

        this.nextIndex--;
        this.innerCollection[this.nextIndex] = null;
    }

    @Override
    public IPerson[] getStoredItems() {
        return this.innerCollection;
    }

    @Override
    public IPerson findById(long id) throws OperationNotSupportedException {
        IPerson targetPerson = this.getPersonById(id);
        if (targetPerson == null) {
            throw new OperationNotSupportedException();
        }

        return targetPerson;
    }

    @Override
    public IPerson findByUsername(String username) throws OperationNotSupportedException {
        if (username == null) {
            throw new OperationNotSupportedException();
        }

        IPerson targetPerson = this.getPersonByUsername(username);
        if (targetPerson == null) {
            throw new OperationNotSupportedException();
        }

        return targetPerson;
    }
}
