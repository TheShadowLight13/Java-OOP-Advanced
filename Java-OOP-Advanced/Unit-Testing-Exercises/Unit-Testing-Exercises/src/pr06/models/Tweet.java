package pr06.models;

import pr06.interfaces.Message;
import java.util.Date;

public class Tweet implements Message {

    private String authorUsername;
    private String message;
    private Date createdTime;

    public Tweet(String message, String authorUsername) {
        this.setAuthorUsername(authorUsername);
        this.setMessage(message);
        this.createdTime = new Date();
    }

    private void setAuthorUsername(String authorUsername) {
        if (authorUsername == null || authorUsername.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.authorUsername = authorUsername;
    }

    private void setMessage(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.message = message;
    }

    @Override
    public String retrieveMessage() {
        return this.message;
    }

    @Override
    public Date retrieveCreatedTime() {
        return this.createdTime;
    }

    @Override
    public String retrieveAuthorUsername() {
        return this.authorUsername;
    }
}
