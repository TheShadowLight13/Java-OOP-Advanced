package pr06.interfaces;

import java.util.Date;

public interface Message {

    String retrieveMessage();

    Date retrieveCreatedTime();

    String retrieveAuthorUsername();
}
