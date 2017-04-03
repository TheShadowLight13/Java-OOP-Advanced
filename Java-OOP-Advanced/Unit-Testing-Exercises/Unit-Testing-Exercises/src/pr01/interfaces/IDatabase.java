package pr01.interfaces;

import javax.naming.OperationNotSupportedException;

public interface IDatabase {

    void add(IPerson element) throws OperationNotSupportedException;

    void remove() throws OperationNotSupportedException;

    IPerson[] getStoredItems();

    IPerson findById(long id) throws OperationNotSupportedException;

    IPerson findByUsername(String username) throws OperationNotSupportedException;
}
