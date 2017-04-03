package pr01.models;

import pr01.interfaces.IPerson;
import javax.naming.OperationNotSupportedException;

public class Person implements IPerson{

    private Long id;
    private String username;

    public Person(Long id, String username) throws OperationNotSupportedException {
        this.setId(id);
        this.setUsername(username);
    }

    private void setId(Long id) throws OperationNotSupportedException {
        if (id == null || id < 0) {
            throw new OperationNotSupportedException();
        }

        this.id = id;
    }

    private void setUsername(String username) throws OperationNotSupportedException {
        if (username == null) {
            throw new OperationNotSupportedException();
        }

        this.username = username;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
