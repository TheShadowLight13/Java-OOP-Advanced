package pr06.interfaces;

import java.util.List;

public interface Database {

    void addToDatabase(Message tweet);

    List<Message> getAllMessage();
}
