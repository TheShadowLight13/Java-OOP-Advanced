package pr06.models;

import pr06.interfaces.Database;
import pr06.interfaces.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server implements Database {

    private List<Message> tweets;

    public Server() {
        this.tweets = new ArrayList<>();
    }

    @Override
    public void addToDatabase(Message tweet) {
        if (tweet == null) {
            throw new IllegalArgumentException();
        }

        this.tweets.add(tweet);
    }

    @Override
    public List<Message> getAllMessage() {
        return Collections.unmodifiableList(this.tweets);
    }
}
